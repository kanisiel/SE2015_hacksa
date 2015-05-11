<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강신청</title>
</head>
<body>
<div align="center">
<h1>학사관리 시스템</h1>

<h2>${map.userInfo.getUser_Name()}씨, 반갑습니다.</h2>

<c:if test="${map.userInfo.getUser_Type()==1 }">
	<a href="${pageContext.request.contextPath}/sugangController/register">수강신청</a>
</c:if>
<c:if test="${map.userInfo.getUser_Type()==2 }">
	<a href="${pageContext.request.contextPath}/sugangController/createCourse">강좌개설</a>
</c:if>
<c:if test="${map.userInfo.getUser_Type()==3 }">
	<a href="${pageContext.request.contextPath}/sugangController/createSubject">과목개설</a>
</c:if>
<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
</div>
</body>
</html>