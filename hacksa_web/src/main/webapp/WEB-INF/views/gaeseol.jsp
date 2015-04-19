<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌개설 - 강좌정보입력</title>
</head>
<body>
<div align="center">
<h1>학사관리 시스템</h1>

<form action="sugangController/gaeseol" method=POST>
<table>
	<tr>
		<td style="width:80px;">과목번호</td>
		<td>
			<input name="gwamok_id" type="text" value="${gwamok.getGwamok_id() }" disabled="disabled">
		</td>
		<td>강좌번호</td>
		<td>
			<input name="gangjwa_id" type="text" value="${gwamok.getGwamok_id() }" >
		</td>
	</tr>
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