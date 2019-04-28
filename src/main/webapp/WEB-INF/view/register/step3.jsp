<%--
  Created by IntelliJ IDEA.
  User: jaeryongim
  Date: 2019-04-28
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>회원 가입</title>
</head>
<body>
    <p><string>${registerRequest.name} 님 </string>회원 가입을 완료했습니다.</p>
    <p><a href="<c:url value='/main'/>">[첫 화면 이동]</a></p>
</body>
</html>