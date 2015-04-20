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
<form action="sugangController/sincheong" method=POST>
<table width="80%" border="2px" cellpadding="0px" cellspacing="0px" style="border-weight:2px;border-color:#33AA33;">
	<tr align="center" height="30px">
		<td><font style="font-size:14px;font-weight:bold;">과목번호</font></td>
		<td><font style="font-size:14px;font-weight:bold;">강좌번호</font></td>
		<td><font style="font-size:14px;font-weight:bold;">과목명</font></td>
		<td><font style="font-size:14px;font-weight:bold;">담당교수</font></td>
		<td><font style="font-size:14px;font-weight:bold;">학점</font></td>
		<td><font style="font-size:14px;font-weight:bold;">신청</font></td>
	</tr>
<c:forEach items="${gangjwaInfo.getList() }" var="gangjwa" varStatus="idx">
	<tr align="center" height="30px">
		<td><c:out value="${gangjwa.getGwamok_id() }"></c:out></td>
		<td><c:out value="${gangjwa.getGangjwa_id() }"></c:out></td>
		<td><c:out value="${gangjwa.getName() }"></c:out></td>
		<td><c:out value="${gangjwa.getInstructor() }"></c:out></td>
		<td><c:out value="${gangjwa.getHackjeom() }"></c:out></td>
		<td><input name="gwamokID" type="button" value="신청" /></td>
	</tr>
</c:forEach>
</table>
<!-- <table>
	<tr>
		<td><input type="submit" value="개설"/></td>
		<td><input type="reset" value="리셋"/></td>
	</tr>
</table> -->
</form>
<table>
	<tr>
		<td>
		<a href=${pageContext.request.contextPath}/loginController/logout>로그아웃</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>