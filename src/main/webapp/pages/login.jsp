<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15/06/2024
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management - Login Page</title>
    <link rel="stylesheet" href="../assets/css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap"
            rel="stylesheet"
    />
    <script>
        window.onload = function() {
            const alertMessage = "<%= session.getAttribute("alertMessage") %>";
            if (alertMessage && alertMessage !== "null") {
                alert(alertMessage);
                <% session.removeAttribute("alertMessage"); %>
            }
        };
    </script>
</head>
<body class="login-body">
    <div class="login-wrapper">
        <h1 style="text-align: center;">Login</h1>
        <form id="#loginForm" action="" method="post" class="login-form">
            <div class="login-input-group">
                <label for="userInput" class="login-label">User ID</label>
                <input id="userInput" type="text" placeholder="Username" name="userId" class="login-input" required>
            </div>
            <div class="login-input-group">
                <label for="passwordInput" class="login-label">Password</label>
                <input id="passwordInput" type="password" placeholder="Password" name="password" class="login-input" required>
            </div>
            <input type="submit" value="Login" class="login-button">
        </form>
    </div>
</body>
</html>
