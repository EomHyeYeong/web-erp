<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%> <%-- JSP 파일임을 명시 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- jstl 라이브러리에서 tag를 연결시키기 위한 지시자 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <%-- formating --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/> <%-- context paht를 변수로  가져오기 --%>

<!doctype html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-1">
    <h2>Spring MVC Framework</h2>
    <div class="card">
        <div class="card-header">Header</div>
        <div class="card-body">
            <h5>책 리스트 보기</h5>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>가격</th>
                    <th>저자</th>
                    <th>페이지</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.num}</td>    <%-- ==book.getNum() --%>
                        <td>${book.title}</td>
                        <td>${book.price}</td>
                        <td>${book.author}</td>
                        <td>${book.page}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button class="btn btn-sm btn-primary" onclick="location.href='${cpath}/register'">등록</button>
        </div>
        <div class="card-footer">패스트캠퍼스 부트캠프 8기 엄혜영</div>
    </div>
</div>

</body>
</html>
