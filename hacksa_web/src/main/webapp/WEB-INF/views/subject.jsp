<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌개설 - 과목 목록</title>
</head>
<body>
<div align="center">
<h1>과목 리스트</h1>

<h2>${userInfo.getUserName()}씨, 반갑습니다.</h2>
<form action="sugangController/gaeseol" method=POST>
<table>
<c:choose>
<c:when test="${subjectInfo != null }">
	<c:forEach items="${subjectInfo.getList() }" var="subject" varStatus="idx">
		<tr>
			<td><input name="SID" type="radio" value="${subject.getSid() }" /></td>
			<td><c:out value="${subject.getSid() }"></c:out></td>
			<td><c:out value="${subject.getName() }"></c:out></td>
			<td><c:out value="${subject.getUnit() }"></c:out></td>
		</tr>
	</c:forEach>
</c:when>
<c:when test="${subjectInfo == null }">
	<tr>
		<td>${ isEmpty }
		</td>
	</tr>
</c:when>
</c:choose>
</table>
<table>
	<tr>
		<td><button onclick="location.href='${pageContext.request.contextPath}/createSubject'">개설</button>
		<td><input type="submit" value="변경"/></td>
		<td><input type="reset" value="리셋"/></td>
	</tr>
</table>
</form>
<table>
	<tr>
		<td>
		<a href=${pageContext.request.contextPath}/logged>뒤로</a>
		</td>
		<td>
		<a href=${pageContext.request.contextPath}/loginController/logout>로그아웃</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>