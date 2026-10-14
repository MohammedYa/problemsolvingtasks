
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>

<style>
    * {
        box-sizing: border-box;
    }

    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #667eea, #764ba2);
        margin: 0;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background-color: white;
        width: 450px;
        max-width: 90%;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
        border-bottom: 2px solid #667eea;
        padding-bottom: 15px;
    }

    .row {
        display: flex;
        justify-content: space-between;
        align-items: center;
        gap: 15px;
        padding: 14px 10px;
        margin-bottom: 10px;
        background-color: #f5f6fa;
        border-radius: 8px;
        border-left: 4px solid #667eea;
    }

    .row strong {
        color: #444;
    }

    .row span {
        color: #667eea;
        font-weight: bold;
        overflow-wrap: anywhere;
        text-align: right;
    }

    .back-btn {
        display: block;
        text-align: center;
        text-decoration: none;
        background-color: #667eea;
        color: white;
        padding: 12px;
        border-radius: 8px;
        margin-top: 20px;
        transition: 0.3s;
    }

    .back-btn:hover {
        background-color: #4c5fd5;
    }
</style>

</head>
<body>

<%
String name = request.getParameter("fullName");
String pass = request.getParameter("password");
String ageValue = request.getParameter("age");
String radioAddress = request.getParameter("radioAddress");
String address = request.getParameter("address");

int age = 0;

if (ageValue != null && !ageValue.trim().isEmpty()) {
    try {
        age = Integer.parseInt(ageValue);
    } catch (NumberFormatException e) {
        age = 0;
    }
}
%>

<div class="container">

    <h2>User Details</h2>

    <div class="row">
        <strong>Name:</strong>
        <span><%= name != null ? name.toUpperCase() : "" %></span>
    </div>

    <div class="row">
        <strong>Password:</strong>
        <span><%= pass != null ? pass : "" %></span>
    </div>

    <div class="row">
        <strong>Age:</strong>
        <span><%= age %></span>
    </div>

    <div class="row">
        <strong>Radio Address:</strong>
        <span><%= radioAddress != null ? radioAddress.toUpperCase() : "" %></span>
    </div>

    <div class="row">
        <strong>Selected Address:</strong>
        <span><%= address != null ? address.toUpperCase() : "" %></span>
    </div>

    <a href="formdata.jsp" class="back-btn">Back to Form</a>

</div>

</body>
</html>
