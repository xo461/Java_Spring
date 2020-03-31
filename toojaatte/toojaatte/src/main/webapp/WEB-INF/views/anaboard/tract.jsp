<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>키워드 추출</title>
<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	
	<h1 align="center">키워드 추출</h1>
	<!-- 검색 : 제목, 내용, 작성자, 그 외 복합 -->
	<!-- 페이지는 1 페이지, 한 페이지에 표시할 데이터 갯수는 전달 (hidden) -->
	<div class="row" style="display:list-item; list-style: none;">
	<div style="float:right; padding: 30px 0px 10px 0px; vertical-align: middle">
		<div id="searchDiv">
			<form action="tract.do" class="form-inline">
				<input name="page" value="1" type="hidden"/>
				<input name="key" value="${pageObject.key }" type="hidden"/>
				<input name="word" value="${pageObject.word }" type="hidden"/>
				<input name="gradeType" value="${pageObject.gradeType }" type="hidden"/>
				<input name="headerType" value="${pageObject.headerType }" type="hidden"/>
				<input name="orderType" value="${pageObject.orderType }" type="hidden"/>
				
				<div class="form-group">
               		<span class="input-group-addon">
					<input type='date' class="form-control" name="startDate"/>
	                   	<span class="glyphicon glyphicon-calendar">
	                   	</span>
	                    ~
						<input type='date' class="form-control" name="endDate"/>
	                   	<span class="glyphicon glyphicon-calendar">
	                   	</span>
                    </span>
				</div>
				<br>
				<div class="form-group">
					<select class="form-control" id="gradeType" name="gradeType">
						<option value="a" ${(param.gradeType == "a")?"selected='selected'":"" }>전체</option>
						<option value="b" ${(param.gradeType == "b")?"selected='selected'":"" }>전문분석가</option>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" id="orderType" name="orderType">
						<option value="h" ${(param.orderType == "h")?"selected='selected'":"" }>최신 글</option>
						<option value="rn" ${(param.orderType == "rn")?"selected='selected'":"" }>추천 수</option>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" id="headerType" name="headerType">
						<option value="all" ${(param.headerType == "all")?"selected='selected'":"" }>전체</option>
						<option value="real" ${(param.headerType == "real")?"selected='selected'":"" }>주식</option>
						<option value="fake" ${(param.headerType == "fake")?"selected='selected'":"" }>가상화폐</option>
						<option value="etc" ${(param.headerType == "etc")?"selected='selected'":"" }>기타</option>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
						<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
						<option value="w" ${(param.key == "w")?"selected='selected'":"" }>작성자</option>
						<option value="tc" ${(param.key=="tc")?"selected='selected'":"" }>제목/내용</option>
					</select>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="word" value="${param.word }">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
		</div>
	</div><!-- 	end div row -->
	<!-- 데이터 테이블 -->
	<table class="table">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수/추천수</th>
			<th>작성일</th>
		</tr>
		<!-- 데이터의 갯수만큼 tr을 만든다. : 반복문  -> jsp jstl 사용 태그로 작성-->
		<c:forEach items="${list}" var="dto">
			<tr class="dataRow">
				<%-- 클릭-> 1개 :id, 여러개:class --%>
				<td class="no">${dto.no }</td>
				<td>
				<font color="${(dto.grade == 8) ? 'blue':''}">
				<c:if test="${dto.titleType == 1}">[주식]</c:if>
				<c:if test="${dto.titleType == 2}">[가상화폐]</c:if>
				<c:if test="${dto.titleType == 3}">[기타]</c:if>
				${dto.title }
				</font>
				<span>&nbsp;[${dto.reply_cnt }]</span></td>
				<td>${dto.writer }</td>
				<td>${dto.hit }<span>&nbsp;[${dto.r_cnt }/${dto.n_cnt }]</span></td>
				<td><fmt:formatDate value="${dto.writeDate }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>