<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌개설 - 과목 목록</title>
<script type="text/css">
	td{ align:center;}
</script>
<script type="text/javascript">
	function resetForm(form){
		form.reset();
	}
	function moveto(form){
		form.action = "createCourse";
		form.submit();
	}

</script>
</head>
<body>
<div align="center">
<h1>과목 리스트</h1>

<h2>${userInfo.getUserName()}씨, 반갑습니다.</h2>
<c:choose>
<c:when test="${subjectInfo != null }">
	<table border="1" cellpadding="0" cellspacing="0" style="margin-top:-1px">
		<tr>
			<td align=center width = "70px">과목번호</td>
			<td align=center width = "150px">과목명</td>
			<td align=center width = "50px">학점</td>
			<td align=center width = "50px">개설</td>
		</tr>
	</table>
	<c:forEach items="${subjectInfo.getList() }" var="subject" varStatus="idx">
	<form action="createCourse" method=POST>
	<table border="1" cellpadding="0" cellspacing="0" style="margin-top:-1px">
		<tr>
			<td align=center width = "70px"><input name="SID" type="text" style="border-width:0px" size="3" value="${subject.getSid() }"></td>
			<td align=center width = "150px"><input name="NAME" type="text" style="border-width:0px" value="${subject.getName() }"></td>
			<td align=center width = "50px"><input name="UNIT" type="text" style="border-width:0px" size="1" value="${subject.getUnit() }"></td>
			<td align=center width = "50px"><button onclick="moveto(this.form);">개설</button></td>
		</tr>
		</table>
	</form>
	</c:forEach>
</c:when>
<c:when test="${subjectInfo == null }">
	<table>
		<tr>
			<td>${ isEmpty }
			</td>
		</tr>
	</table>
</c:when>
</c:choose>

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