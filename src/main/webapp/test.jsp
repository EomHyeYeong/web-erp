<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%-- JSP 파일임을 명시 --%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    Hello Java Spring~~~(엄혜영)<br/>
    <%--  java code를 사용하기 위해 <% %> 사용, = 붙으면 출력  --%>
    <%
        java.util.Date date = new java.util.Date();
    %>
    지금 시간은? <%=date.toString()%> (동적인 데이터)
</body>
</html>