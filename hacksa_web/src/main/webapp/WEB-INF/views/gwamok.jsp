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
<h1>학사관리 시스템</h1>

<h2>${userInfo.getName()}씨, 반갑습니다.</h2>
<form action="sugangController/gaeseol" method=POST>
<table>
<c:forEach items="${gwamokInfo.getList() }" var="gwamok" varStatus="idx">
	<tr>
		<td><input name="gwamokID" type="radio" value="${gwamok.getGwamok_id() }" /></td>
		<td><c:out value="${gwamok.getGwamok_id() }"></c:out></td>
		<td><c:out value="${gwamok.getName() }"></c:out></td>
		<td><c:out value="${gwamok.getHakjeom() }"></c:out></td>
	</tr>
</c:forEach>
</table>
<table>
	<tr>
		<td><input type="submit" value="개설"/></td>
		<td><input type="reset" value="리셋"/></td>
	</tr>
</table>
</form>
<a href=${pageContext.request.contextPath}/loginController/logout>로그아웃</a>
</div>
</body>
</html>