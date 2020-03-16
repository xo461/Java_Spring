<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 좋아요아이콘 -->
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
 
<script>
var no = '${dto.no}'; //게시글 번호
//alert('${dto.no}');

//댓글등록버튼클릭시
$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
	//alert('test');
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져와서 serialize직렬화해서 json으로 만들어서 보내준다.
    commentInsert(insertData); //Insert 함수호출(아래)
});

window.addeventlistner('DOMContentLoaded', function(){
	
});

///////////////////////////////////////////////////////
//수정중: boardlistcontroller에서 map으로 바꿔서 replydto, replylikedto 두개 다 담기
//replylikedto에서 likedislike 필요하기 떄문. 이미좋아요/싫어요하면 맨처음 로드할떄 색칠한 버튼으로 로드해야 함.
var thumbsup = 'far fa-thumbs-up';
var thumbsdown = 'far fa-thumbs-down';
if (${likeDislike} == 0){ //이미좋아요한상태
	thumbsup = 'fas fa-thumbs-up';
}else if(${likeDislike} == 1){
	thumbsdown = 'fas fa-thumbs-down';
}
//==========================================================
//댓글 목록 
function commentList(){
    $.ajax({
        url : '/bcomment/list.do',
        type : 'get',
        data : {'no':no},
        success : function(data){
            var a =''; 
            $.each(data, function(key, value){ //list형식->반복문으로가져온다.
                //console.log(key+""+value.REP_NO); //대소문자주의
                
                a += '<div class="media"><a href="#" class="pull-left"><img src="'+value.SNS_PROFILE+'" alt="https://bootdey.com/img/Content/user_1.jpg" class="img-circle"></a><div class="media-body"><span class="text-muted pull-right"><small class="text-muted">'
                a += value.WRITEDATE+'</small></span>'
                a += '<strong class="text-success">'+value.NICKNAME+'</strong>'
                a += '<div class="commentContent'+value.REP_NO+'">'+value.CONTENT+'</div>'
                a += '<p><i id="thumbsup" class="'+thumbsup+'" style=\'font-size:26px\' onclick="increaseLike('+value.REP_NO+')">'+value.TOTAL_LIKE+'</i> '
                a += '<i id="'+value.REP_NO+'" class=\'far fa-thumbs-down\' style=\'font-size:26px\' onclick="increaseDislike('+value.REP_NO+')">'+value.TOTAL_DISLIKE+'</i></p>'
             
                a += '<a onclick="commentUpdate('+value.REP_NO+',\''+value.CONTENT+'\');"> update </a>';
                a += '<a onclick="commentDelete('+value.REP_NO+');"> delete </a> </div></div></div></div></div>';
            });
            
            $(".commentList").html(a); //데이터넣어서 댓글리스트띄우기
        }
    });
}



//댓글 등록
function commentInsert(insertData){
    $.ajax({
        url : '/bcomment/insert.do',
        type : 'POST',
        data : insertData,
        success : function(response){ //요청성공시
            if(response == 1) {
                commentList(); //댓글 작성 후 댓글 목록 reload
                $('[name=content]').val(''); //댓글창에 쓴 내용 사라짐
            }
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(rep_no, content){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+rep_no+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+rep_no+');">update</button> </span>';
    a += '</div>';
    
    $('.commentContent'+rep_no).html(a); //댓글번호에해당하는 기존댓글을 input창에 뿌린다. 
    
}
 
//댓글 수정
function commentUpdateProc(rep_no){
    var updateContent = $('[name=content_'+rep_no+']').val(); //수정한글내용
    
    $.ajax({
        url : '/bcomment/update.do',
        type : 'post',
        data : {'content' : updateContent, 'rep_no' : rep_no},
        success : function(data){
            if(data == 1) commentList(no); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function commentDelete(rep_no){
    $.ajax({
        url : '/bcomment/delete/'+rep_no+'.do',
        type : 'post',
        success : function(data){
            if(data == 1) commentList(rep_no); //댓글 삭제후 목록 출력 
        }
    });
}
 


 
$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력 
});


//좋아요클릭시:
function increaseLike(rep_no){
	//로그인안되어있으면 el객체 null이라 오류남.-> null변수 먼저 선언해주고, 대입. 쌍따옴표로 묶어야 한다.
	var id = null;
	id = "${login.id}";
	if (!id){
		alert("This service requires sign-in.");
		location.href="/login/login.do";
		}
	else{
	
	//1.좋아요누른사람등록
	$.ajax({
		url : '/bcomment/increaselike.do',
		method : 'post',
		contentType: 'application/json', //json으로 넘기고 vo,dto가 아닌 map으로 받으면 이 문구를 넣어줘야 에러가 안나고 이름 맵핑된다.
		data : JSON.stringify({ 
			id : id,
			no : ${dto.no},
			rep_no : rep_no,
			likeDislike : 0 //좋아요는 0, 싫어요는 -1보내기(총개수구하는용)
			}),
		success : function(response){ //리턴값 1: 좋아요 성공, 2: 이미좋아요, 3: 이미싫어요
            if(response == 1) { 
                commentList(); //댓글 작성 후 댓글 목록 reload
                $('#like').css("color", "red"); //댓글창에 쓴 내용 사라짐
            	}
            else if(response==2){ //이미좋아요
				$("message").html('The comment is already liked.');
                }
            else{
				$("message").html('The comment is already disliked.');
                }
        	}	
		
	});
	}
}

//싫어요 클릭시:
function increaseDislike(rep_no){
	//로그인안되어있으면 el객체 null이라 오류남.-> null변수 먼저 선언해주고, 대입. 쌍따옴표로 묶어야 한다.
	var id = null;
	id = "${login.id}";
	if (!id){
		alert("This service requires sign-in.");
		location.href="/login/login.do";
		}
	else{

	$.ajax({
		url : '/bcomment/increaselike.do',
		method : 'post',
		contentType: 'application/json', //json으로 넘기고 vo,dto가 아닌 map으로 받으면 이 문구를 넣어줘야 에러가 안나고 이름 맵핑된다.
		data : JSON.stringify({ 
			id : id,
			no : ${dto.no},
			rep_no : rep_no,
			likeDislike : 1 //좋아요는 0, 싫어요는 1보내기(총개수구하는용)
			}),
		success : function(response){ //리턴값 1: 좋아요 성공, 2: 이미좋아요, 3: 이미싫어요
            if(response == 1) { 
                //commentList(), // 댓글 목록 reload
                //thumbsup = "fas fa-thumbs-down";
                //document.getElementById(rep_no).className = "fas fa-thumbs-down";
                //this.className = "fas fa-thumbs-down";
                
            	}
            else if(response==2){ //이미좋아요
                alert("The comment is already liked.");
                }
            else{
                alert("The comment is already disliked.");
                }
        	}	
		
	});
	}
}
 
</script>


