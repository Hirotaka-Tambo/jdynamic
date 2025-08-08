<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Sample</title>
</head>
<body>
<%
pageContext.setAttribute("pageScope", new Date());
request.setAttribute("requestScope", new Date());
session.setAttribute("sessionScope", new Date());
application.setAttribute("applicationScope", new Date());
%>

<h1>現在の時刻</h1>
ページスコープ:<%=pageContext.getAttribute("pageScope") %><br>
リクエストスコープ:<%=request.getAttribute("requestScope") %><br>
セッションスコープ:<%=session.getAttribute("sessionScope") %><br>
アプリケーションスコープ:<%=application.getAttribute("applicationScope") %><br>

<p>
<a href="scopeSample.jsp">更新</a>
</p>

</body>
</html>
