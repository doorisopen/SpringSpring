<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/board.css">
<title>DOOP</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div align=center>
	 <header>게시글 상세보기</header>
			<table>
				<tr>
					<th>게시글 번호</th>
					<td><input type="text" id="boardIdx" name="boardIdx" value="${boardDetail.boardIdx}" placeholder="boardIdx" disabled /></td>
				</tr>
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" id="boardTitle" name="boardTitle" value="${boardDetail.boardTitle}" placeholder="boardTitle" disabled /></td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><input type="text" id="boardContent" name="boardContent" value="${boardDetail.boardContent}" placeholder="boardContent" disabled /></td>
				</tr>
				<tr>
					<th>게시글 작성자</th>
					<td><input type="text" id="writer" name="writer" value="${boardDetail.writer}" placeholder="writer" disabled /></td>
					
				</tr>
			</table>
			<div>
				<a href="/myspring/Board/boardUpdateView?boardIdx=${boardDetail.boardIdx}">수정하기</a>
			</div>
			<div>
				<a href="/myspring/Board/boardRead">게시글 리스트 가기</a>
			</div>
			<div>
				<a href="/myspring/Board/boardDelete?boardIdx=${boardDetail.boardIdx}">게시글 삭제</a>
			</div>
			

			<a href="javascript:void(0)" onclick="fn_replyToReplyRead(${boardDetail.boardIdx})" >TEST</a>
			
			
		<!-- Reply Form {s} -->
		<div style="padding-top: 10px">
			<form:form name="form" id="form" role="form" modelAttribute="replyVO" method="post">
				<form:hidden path="boardIdx" id="boardIdx" />
				<div>
					<div>
						<form:textarea path="replyContent" id="replyContent" rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>
						<form:input path="replyWriter" id="replyWriter" placeholder="댓글 작성자"></form:input>
						<button type="button" id="btnReplyCreate" style="margin-top: 10px">저 장</button>
					</div>
				</div>
			</form:form>
		</div>
		<!-- Reply Form {e} -->



		<!-- Reply List {s}-->
		<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
			<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
			<c:set var="boardIdx" value='${boardDetail.boardIdx}'/>
			<!--  <div id="replyList"></div> -->
			<div style="display:inline-flex;">
				<table id="replyList" class="reply" border="1"></table>
			</div>
		</div>

		<!-- Reply List {e}-->

	</div>
</body>
<script src="../resources/js/reply.js"></script>
</html>