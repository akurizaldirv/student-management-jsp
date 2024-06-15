<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15/06/2024
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management - Daftar Siswa</title>
    <script src="../assets/js/scrips.js"></script>
    <link rel="stylesheet" href="../assets/css/styles.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap"
            rel="stylesheet"
    />
</head>
<body class="student-body">
    <div class="student-container">
        <div class="student-title">
            <h1>Welcome, ${userId}</h1>
            <div class="student-logout-wrapper">
                <a href="/logout" class="student-logout-btn">Logout</a>
            </div>
        </div>
        <table border="0" class="student-table">
            <thead class="table-header">
                <td class="table-header-title">Department</td>
                <td class="table-header-title">Student ID</td>
                <td class="table-header-title">Marks</td>
                <td class="table-header-title">Pass (%)</td>
            </thead>
            <tbody>
                ${content}
            </tbody>
        </table>
    </div>
</body>
</html>
