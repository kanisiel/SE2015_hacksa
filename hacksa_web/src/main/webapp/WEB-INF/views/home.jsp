<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div align="center">
<h1>학사관리 시스템</h1>

<P>  현재시간은 ${serverTime} 입니다. </P>

	<form action="loginController/login.do" method="post">
		<table>
			<tr height="40px">
				<td>유저 아이디</td>
				<td><input type="text" name="userID"></td>
			</tr>
			<tr height="40px">
				<td>패스워드</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<font style="font-size:13px;color:#FF3333;">${map.errorCode.getSubtitleKor()}</font>
				</td>
			</tr>
		</table>
		<table>
			<tr height="40px">
				<td><input type="submit" value="로그인"></td>
				<td><input type="reset" value="리셋"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
