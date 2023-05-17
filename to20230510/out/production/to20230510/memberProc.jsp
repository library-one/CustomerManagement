<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="regBean" class="MemberBean" />
<jsp:setProperty name="regBean" property="*" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<br/><br/>
<form name="regForm" method="post" action="memberInsert.jsp">
<table>
	<tr>
		<td colspan="2" class="title">
			<%=regBean.getName() %>
			회원님이 작성한 내용입니다. 확인해 주세요. 
		</td>
	</tr>
	<tr>
		<td width="175px">아이디</td>
		<td><%=regBean.getId() %></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td><%=regBean.getPwd() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=regBean.getName() %></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><%=regBean.getBirthday() %></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><%=regBean.getEmail() %></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="확인완료">&nbsp;
			<input type="button" value="다시쓰기" onClick="history.back()">
		</td>
	</tr>
</table>
</form>
</body>
</html>