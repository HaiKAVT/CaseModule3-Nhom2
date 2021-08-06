<%--
  Created by IntelliJ IDEA.
  User: tam
  Date: 05/08/2021
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: iU LOVE
  Date: 7/30/2021
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trung tâm quản lý</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        td {
            font-size: 16px;
            font-family: Tahoma;
            text-align: center;
            color: black;
            background-color: white;
        }

        tr {
            background-color: gray;
            color: white;
        }

    </style>
</head>
<body>
<h1 style="text-align: center">Admin</h1>
<br>

<table style="color: blue" ; border="1px">

    <%--    Quản lý tài khoản--%>
    <thead>
    <th colspan="9">
        <h1 style="text-align: center">Quản lý tài khoản</h1>
    </th>
    </tr>
    <tr>
        <td width="300px" height="60px"><b>Name</b></td>
        <td width="300px" height="60px"><b>Phone Number</b></td>
        <td width="300px" height="60px"><b>Email</b></td>
        <td width="300px" height="60px"><b>Address</b></td>
        <td width="300px" height="60px"><b>Birthday</b></td>
        <td width="300px" height="60px"><b>UserName</b></td>
        <td width="300px" height="60px"><b>PassWord</b></td>
        <td colspan="3" width="300px" height="60px"><b>Actison</b></td>


    </tr>
    </thead>
    <c:forEach var="user" items="${listUser}" varStatus="loop">
        <div class="col-sm-4">
            <tr>
                    <%--                    lấy dữ liệu từ mảng ra rồi show ra trang web--%>
                <td>${user.ten}</td>
                <td>${user.sdt}</td>
                <td>${user.email}</td>
                <td>${user.diachi}</td>
                <td>${user.birthday}</td>
                <td>${user.userName}</td>
                <td>${user.passWord}</td>
                <td style="width: 100px; height: 100px"><a href="/login?action=deleteUser&id=${user.id}"
                                                           class="btn btn-success">Delete</a></td>
            </tr>
        </div>
    </c:forEach>

    <%--    Quản lý sản phẩm--%>
    <thead>
    <th colspan="8">
        <h1 style="text-align: center">Quản lý sản phẩm</h1>
    </th>
    </tr>
    <tr>
        <td width="300px" height="60px"><b>ID</b></td>
        <td width="300px" height="60px"><b>Product Name</b></td>
        <td width="300px" height="60px"><b>Price</b></td>
        <td width="300px" height="60px"><b>Product Type</b></td>
        <td width="300px" height="60px"><b>Photo</b></td>
        <td colspan="3" width="300px" height="60px"><b>Actison</b></td>


    </tr>
    </thead>
    <c:forEach var="sp" items="${ahi}" varStatus="loop">
        <div class="col-sm-4">
            <tr>
                    <%--                    lấy dữ liệu từ mảng ra rồi show ra trang web--%>
                <td>${sp.id}</td>
                <td>${sp.ten}</td>
                <td>${sp.gia}</td>
                <td>${sp.idloai}</td>
                <td><img width="330" height="347" src="${sp.img}"></td>
                <td style="width: 100px; height: 100px"><a href="/?action=createSp" class="btn btn-success">Create</a></td>
                <td style="width: 100px; height: 100px"><a href="/?action=editSp&index=${loop.index}"class="btn btn-success">Edit</a></td>
                <td style="width: 100px; height: 100px"><a href="/?action=deleteSp&index=${loop.index}"
                                                           class="btn btn-success">Delete</a></td>
            </tr>
        </div>
    </c:forEach>
    <br>

    <%--    <a href="/views/selectSV.jsp" class="btn btn-success">FindName</a>--%>
    <a href="views/homeUser.jsp" class="btn btn-info">Home</a>
    <a href="/login" class="btn btn-info">Log Out</a>
</table>
</body>
</html>
