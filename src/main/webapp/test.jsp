<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%> <%-- JSP 파일임을 명시 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- jstl 라이브러리에서 tag를 연결시키기 위한 지시자 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <%-- formating --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/> <%-- context paht를 변수로  가져오기 --%>
<c:set var="sum" value="11"/> <%-- set: 변수 선언 --%>
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
    for (int i = 1; i <= 10; i++) {
        out.println(i + "<br/>");
    }

    java.util.Date date = new java.util.Date();
%>
지금 시간은? <%=date.toString()%> (동적인 데이터)<br/><br/>

${"1~10 중 짝수만 출력"}<br/>
<c:forEach var="i" begin="1" end="10" step="1"> <%-- c: 접두사, step: default 1 --%>
    <c:if test="${i%2==0}"> <%-- test: 조건식 --%>
        ${i}<br/> <%-- ${}: 표현식(출력식) 연산자를 사용할 수 있음. --%>
    </c:if>
</c:forEach>
${sum}

<c:choose> <%-- switch-case 문 --%>
    <c:when test="${sum%2==0}">
        : 짝수입니다.<br/>
    </c:when>
    <c:otherwise>
        : 홀수입니다.<br/>
    </c:otherwise>
</c:choose>

<a href="${cpath}/hello">경로 이동</a> <%-- 그냥 hello만 써도 가능함. /가 붙으면 전체 경로를 적어줘야 함 --%>
</body>
</html>