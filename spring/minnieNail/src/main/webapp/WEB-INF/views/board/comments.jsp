<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 좋아요아이콘 -->
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
 
<script>
var no = '${dto.no}'; //게시글 번호
var id = '${login.id}';
//alert('${dto.no}');

//댓글등록버튼클릭시 로그인안되어있으면 로그인페이지로, 
$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
	//alert('test');
	if (id==null){
		//다른컨트롤러로 보내려면 앞에 /슬래시붙여야함(루트의미)
		location.replace('/login/login.do')
		}
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져와서 serialize직렬화해서 json으로 만들어서 보내준다.
    commentInsert(insertData); //Insert 함수호출(아래)
});

//댓글 목록 =====================================
function commentList(){
    $.ajax({
        url : '/bcomment/list.do',
        type : 'get',
        data : {'no':no, 'id':id},
        success : function(data){
			//map에 replydto, replylikedto 두개 담아온다.
            var a =''; 
			//댓글리스트
			var repdto = data.repdto;

			//댓글좋아요리스트(내가 좋아요한 댓글 로드하여 버튼 색칠해진 모습으로 보이기 위함): 로그인 안되어있거나 좋아요한 리스트 없으면 null반환(undefined) -> if문
			var repLikeDto = data.repLikeDto; 
			//console.log(repLikeDto, typeof repLikeDto);
 
            $.each(repdto, function(key, value){ //list형식->반복문으로가져온다.
                var thumbsup = 'far fa-thumbs-up'; //빈손가락
                var thumbsdown = 'far fa-thumbs-down';
                
            	if(repLikeDto!=undefined){ //내가 좋아요한댓글이 있으면 : 반복문
    				$.each(repLikeDto, function(k, v){
						//console.log(repLikeDto, typeof repLikeDto);
        				
    	                if (v.REP_NO==value.REP_NO && id ==v.ID){ //내가좋아요한댓글번호와 해당댓글번호가 같고, 로그인상태의id와 db에 담긴id 같으면 (이미좋아요나 싫어요한상태)
       	               	 	if(v.LIKEDISLIKE == 0){//이미좋아요
        	               		thumbsup = 'fas fa-thumbs-up'; //색깔채운손가락
    	                	}else if(v.LIKEDISLIKE == 1){//이미싫어요
    	               			thumbsdown = 'fas fa-thumbs-down';
    	               		}
        				}

    				})
    	        }
    	          
           //==========================================================
                
                a += '<div class="media"><a href="#" class="pull-left"><img src="'+value.SNS_PROFILE+'" onerror="this.src=../upload/1.png" class="img-circle"></a>';
                a += '<div class="media-body">';
                a += '<span class="text-muted pull-right"><small class="text-muted">'+value.WRITEDATE+'</small></span></br>'

                //자기가 쓴댓글이면 수정삭제버튼이보인다.
                if (id == value.ID){
                a += '<div style="float:right;">';
                a += '<a onclick="commentUpdate('+value.REP_NO+',\''+value.CONTENT+'\');"> update </a>';
                a += '<a onclick="commentDelete('+value.REP_NO+');"> delete </a>';
                a += '</div>';
                }

                a += '<strong class="text-success">'+value.NICKNAME+'</strong>'
                a += '<div class="commentContent'+value.REP_NO+'">'+value.CONTENT+'</div>'
                a += '<p><i id="thumbsup" class="'+thumbsup+'" style=\'font-size:26px\' onclick="increaseLike('+value.REP_NO+')">'+value.TOTAL_LIKE+'</i> '
                a += '<i id="thumbsdown" class="'+thumbsdown+'" style=\'font-size:26px\' onclick="increaseDislike('+value.REP_NO+')">'+value.TOTAL_DISLIKE+'</i></p>'
                a += '</div></div></div></div></div>';

            });
            $(".commentList").html(a); //데이터넣어서 댓글리스트띄우기
		}
    });
}



//댓글 등록===================================================
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
 
//댓글 수정===============================
//기존 댓글 보여주기 
function commentUpdate(rep_no, content){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+rep_no+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+rep_no+');">update</button> </span>';
    a += '</div>';
    
    $('.commentContent'+rep_no).html(a); //댓글번호에해당하는 기존댓글을 input창에 뿌린다. 
    
}
 
//댓글 수정 보내기
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
 
//댓글 삭제 ==================================================
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


//좋아요클릭==================================================
function increaseLike(rep_no){
	//로그인안되어있으면 el객체 null이라 오류남.-> null변수 먼저 선언해주고, 대입. 쌍따옴표로 묶어야 한다.
	var id = null;
	id = "${login.id}";
	if (!id){
		//alert("This service requires sign-in.");
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
		success : function(response){ //리턴값 1: 좋아요 성공, 2: 이미좋아요(좋아요캔슬), 3: 이미싫어요(팝업창)
			//alert(response);
            if(response == 1) { 
                $('.thumbsup').attr('class', 'fas fa-thumbs-up');
                commentList(); //댓글 작성 후 댓글 목록 reload
            	}
            else if(response==2){ //이미좋아요->좋아요취소
                commentList(); //댓글 작성 후 댓글 목록 reload
            }          
            else{
				alert('The comment is already disliked.');
                }
        	}	
		
	});
	}
}

//싫어요 클릭시:===========================================
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
		success : function(response){ //리턴값 1: 싫어요 성공, 2: 이미좋아요, 3: 이미싫어요(싫어요취소)
            if(response == 1) { //싫어요 성공
                //commentList(), // 댓글 목록 reload
                //thumbsup = "fas fa-thumbs-down";
                //document.getElementByClassName("far fa-thumbs-down").className = "fas fa-thumbs-down";
                //$(this).className = "fas fa-thumbs-down";
                $(this).attr('class', 'fas fa-thumbs-down');
                commentList(); //댓글 작성 후 댓글 목록 reload
            	}
            else if(response==2){ //이미좋아요
                alert("The comment is already liked.");
                }
            else{
                $('.thumbsdown').attr('class', 'fas fa-thumbs-down');
                commentList(); //댓글 작성 후 댓글 목록 reload
                }
        	}	
		
	});
	}
}
 
</script>


