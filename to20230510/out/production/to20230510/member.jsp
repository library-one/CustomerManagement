<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body>
<br/><br/>
<form name="regForm" method="post" action="memberProc.jsp">
<table>
    <tr> 
      <td colspan="2" class="title">회원 가입</td>
    </tr>
    <tr> 
      <td width="120">아이디</td>
      <td><input type="text" name="id" size="30" ></td>
    </tr>
    <tr> 
      <td>패스워드</td> 
      <td><input type="password" name="pwd" size="30" ></td>
    </tr>
    <tr> 
      <td>패스워드 확인</td>
      <td><input type="password" name="repwd" size="30" ></td>
    </tr>
    <tr>  
      <td>이름</td>
      <td><input name="name" size="30" ></td>
    </tr>
    <tr> 
      <td>생년월일</td>
      <td><input type="date" name="birthday" size="30"  placeholder="0000-00-00" ></td>
    </tr>
    <tr>  
      <td>이메일</td>
      <td><input name="email" size="30"></td>
    </tr>
    <tr> 
      <td colspan="2" align="center"> 
       <input type="button" value="회원가입" onclick="inputCheck()"> &nbsp; 
       <input type="reset" value="다시쓰기"> 
      </td>
    </tr>
</table>
</form>  
</body>
</html>