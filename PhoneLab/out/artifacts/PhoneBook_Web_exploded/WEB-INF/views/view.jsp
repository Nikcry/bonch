<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="width: 95%; margin: auto">
<h1>PhoneBook</h1>
<%--<a href='create'>Add New User</a><br><br>--%>
<table border='1' width='100%' style="border-collapse: collapse" class="table table-bordered">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items = "${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.phone}"></c:out></td>
            <td><a href='update'>Update</a></td>
            <td><a href='delete'>Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>