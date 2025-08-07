<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>plus Result</title>
</head>
<body>
<%
  String num1= request.getParameter("number1");
  String num2= request.getParameter("number2");
  
  int i1= Integer.parseInt(num1);
  int i2= Integer.parseInt(num2);
  
  int answer = i1 + i2;
  
%>

<%= i1 %> + <%= i2 %> = <%= answer %>
</body>
</html>
