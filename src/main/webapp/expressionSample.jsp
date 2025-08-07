<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Sample</title>
</head>
<body>
<%
for(int i =0; i < 5; i++) {%>HelloJSP<br><%}
%>

現在の時刻は<%= new Date() %>です。<br>
</body>
</html>
