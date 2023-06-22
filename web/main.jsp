<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/6/21
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .container {
        margin: 100px auto;
        background-color: #cccccc;
        text-align: center;
    }

    img {
        width: 20px;
        height: 20px;
    }

    .table {
        margin: 100px auto;
    }
</style>

<script>
    function search() {
        const param = document.getElementById("search").value;
        window.location.href = "${pageContext.request.contextPath}/searchServlet?param=" + param;
    }
</script>

<body>
<div class="container">
    <label>用户列表</label>
    <input id="search" type="text" placeholder="查询">
    <button onclick="search()">查询</button>
    <a href="add.jsp">添加</a>
    <table class="table">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>头像</th>
        </tr>
        <tbody>

        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.username}</td>
                <td>${student.gender}</td>
                <td><img src="${student.img}"></td>
                <td>
                    <a href="/TurnToEdit?id=${student.id}">修改</a>
                    <a href="/delete?id=${student.id}">删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>