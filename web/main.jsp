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
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f2f2f2;
    }

    .container {
        width: 50%;
        padding: 20px;
        margin: 100px auto;
        font-weight: bold;
        font-size: 20px;
        background-color: #cccccc;
        text-align: center;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    img {
        width: 20px;
        height: 20px;
    }

    .table {
        margin: 20px auto;
        width: 100%;
        border-collapse: collapse;
    }

    th,
    td {
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #dddddd;
    }

    .add,
    .search {
        display: inline-block;
        margin-top: 10px;
        margin-right: 5px;
        padding: 8px 12px;
        border: none;
        border-radius: 3px;
        background-color: #4caf50;
        color: #fff;
        font-weight: bold;
        text-decoration: none;
        cursor: pointer;
    }

    .add:hover,
    .search:hover {
        background-color: #45a049;
    }

    a {
        text-decoration: none;
        color: black;
    }
</style>

<script>
    function searchByID() {
        const param = document.getElementById("search").value;
        window.location.href = "${pageContext.request.contextPath}/searchByID?param=" + param;
    }

    function searchByName() {
        const param = document.getElementById("search").value;
        window.location.href = "${pageContext.request.contextPath}/searchByName?param=" + param;
    }

    function add() {
        window.location.href = "${pageContext.request.contextPath}/add.jsp";
    }
</script>

<body>
<div class="container">
    <input id="search" type="text" placeholder="">
    <button onclick="searchByName()" class="search">Name查询</button>
    <button onclick="searchByID()" class="search">ID查询</button>
    <button onclick="add()" class="add">添加</button>

    <table class="table">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>头像</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
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
