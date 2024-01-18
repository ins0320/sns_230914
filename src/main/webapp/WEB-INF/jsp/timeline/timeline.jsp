<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">    
<div class="d-flex justify-content-center">
	<div class="w-50">
		<c:if test="${ not empty userId}">
			<div>
				<textarea>내용을 입력해주세요</textarea>
				<div class="d-flex justify-content-between">
					<i class="bi bi-card-image"></i>
					<input type="submit" value="게시" class="btn btn-info">
				</div>
			</div>	
		</c:if>
		<!--  피드 -->
		<c:forEach  var="post" items="${postList }">
			<div class="d-flex justify-content-between">
				<b>글쓴이</b>
				<i class="bi bi-three-dots"></i>
			</div>
			<div>
				<img src="https://cdn.pixabay.com/photo/2023/10/23/17/10/landscape-8336496_640.jpg">
			</div>
			<div>
				<img src="https://www.iconninja.com/files/527/809/128/heart-icon.png" width = 20>
				좋아요 11개
			</div>

			<div class="d-flex">
				<b>{}</b>
				<div>비지도 학슴</div>
			</div>
		</c:forEach>
	</div>
</div>
