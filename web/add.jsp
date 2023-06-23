<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/6/21
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        width: 300px;
        margin: 100px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"],
    input[type="file"] {
        width: 100%;
        padding: 8px;
        border-radius: 3px;
        border: 1px solid #ccc;
    }

    input[type="radio"] {
        margin-right: 5px;
    }

    input[type="submit"] {
        display: block;
        width: 100%;
        padding: 10px;
        border: none;
        background-color: #4caf50;
        color: #fff;
        font-weight: bold;
        cursor: pointer;
        border-radius: 3px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
<body>
<div class="container">

    <form action="/addServlet" method="POST" enctype="multipart/form-data">
        <h2>Student Information</h2>

        <div class="form-group">
            <label for="id">学号</label>
            <input type="text" value="${student.id}" name="id" id="id">
        </div>

        <div class="form-group">
            <label for="username">姓名</label>
            <input type="text" value="${student.username}" name="username" id="username">
        </div>

        <div class="form-group">
            <label>性别</label>
            <input type="radio" name="gender" value="男" id="man"> <label for="man">男</label>
            <input type="radio" name="gender" value="女" id="woman"> <label for="woman">女</label>
        </div>

        <div class="form-group">
            <label for="img">头像</label>
            <input type="file" name="img" id="img">
        </div>

        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
