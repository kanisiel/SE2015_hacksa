<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<div align=center>
	<form id=register method="POST" action="loginController/createAccount.do">
		<table cellspacing=0 cellpadding=0 class="inputTable">
			<tr>
				<td class="titleTD">아이디</td><td class="inputTD"><input id="USERID" type="text" value="${ loginInfo.getUserId() }"/></td>
				<td class="titleTD"></td><td class="inputTD"></td>
			</tr>
			<tr>
				<td class="titleTD">패스워드</td><td class="inputTD"><input id="USERPASSWORD" type="password" value="${ loginInfo.getUserPassword() }"/></td>
				<td class="titleTD">패스워드확인</td><td class="inputTD"><input id="PASSWORD" type="password"/></td>
			</tr>
			<tr>
				<td class="titleTD">학번</td><td class="inputTD"><input id="UIDX" type="text"/></td>
				<td class="titleTD">학과</td><td class="inputTD">
					<select id="DEPT">
						<c:forEach items=${ departments } var="department">
							<option value=${ department.getIdx() }><c:out value=${ department.getName() }></c:out></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>