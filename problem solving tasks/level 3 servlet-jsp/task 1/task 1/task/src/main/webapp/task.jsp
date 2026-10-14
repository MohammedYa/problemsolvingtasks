<%@ page import="java.util.List" %>
<%@ page import="task.user" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
        font-family: Arial, sans-serif;
        background: #f1f5f9;
        padding: 40px 20px;
    }

    .container {
        max-width: 700px;
        margin: auto;
    }

    .card {
        background: white;
        padding: 30px;
        border-radius: 16px;
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.08);
    }

    h1 {
        text-align: center;
        color: #1e293b;
        margin-bottom: 10px;
    }

    .subtitle {
        text-align: center;
        color: #64748b;
        margin-bottom: 25px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 14px;
        text-align: center;
        border-bottom: 1px solid #e2e8f0;
    }

    th {
        background: #2563eb;
        color: white;
    }

    tbody tr:nth-child(even) {
        background: #f8fafc;
    }

    tbody tr:hover {
        background: #dbeafe;
    }

    .result {
        margin-top: 25px;
        padding: 18px;
        background: #eff6ff;
        border-left: 4px solid #2563eb;
        border-radius: 8px;
    }

    .result h3 {
        color: #1d4ed8;
        margin-bottom: 12px;
    }

    .result p {
        color: #334155;
        margin: 8px 0;
    }
</style>
</head>
<body>
<%
    List<user> users = new ArrayList<>();

    users.add(new user(1, "Ahmed"));
    users.add(new user(2, "Mohamed"));
    users.add(new user(3, "Ali"));
%>


<div class="container">
    <div class="card">

        <h1>Student Details</h1>
        <p class="subtitle">Student information</p>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>

            <tbody>
                <% for (user u : users) { %>
                    <tr>
                        <td><%= u.getId() %></td>
                        <td><%= u.getName() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <div class="result">
            <h3>Returned Value</h3>

            <% for (user u : users) { %>
                <p>
                    Id : <%= u.getId() %>
                    Name is : <%= u.getName() %>
                </p>
            <% } %>

        </div>

    </div>
</div>

</body>
</html>