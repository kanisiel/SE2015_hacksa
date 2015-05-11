<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="form.css" type="text/css" rel="stylesheet">
<title>강좌 정보 입력</title>
</head>
<body>
	<form action="loginController/login.do" method="post">
		<table cellspacing=0 cellpadding=0 class="inputTable">
			<tr>
				<td class="titleTD">과목번호</td><td class="inputTD"><input id="SID" type="text"/></td>
			</tr>
			<tr>
				<td class="titleTD">과목명</td><td class="inputTD"><input id="NAME" type="text"/></td>
			</tr>
			<tr>
				<td class="titleTD">학점</td><td class="inputTD"><select id="UNIT">
					<option value=0>0</option>
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
				</select></td>
			</tr>
		</table>
	</form>
</body>
</html>