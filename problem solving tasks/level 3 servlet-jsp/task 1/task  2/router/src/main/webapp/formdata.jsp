
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Data</title>

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

    .form-container {
        background-color: white;
        width: 450px;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
    }

    .form-group {
        margin-bottom: 18px;
    }

    label {
        display: inline-block;
        color: #444;
        font-weight: bold;
        margin-bottom: 8px;
    }

    input[type="text"],
    input[type="password"],
    select {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 7px;
        font-size: 15px;
        outline: none;
        transition: 0.3s;
    }

    input[type="text"]:focus,
    input[type="password"]:focus,
    select:focus {
        border-color: #667eea;
        box-shadow: 0 0 5px rgba(102, 126, 234, 0.4);
    }

    .radio-group {
        display: flex;
        gap: 15px;
        flex-wrap: wrap;
        align-items: center;
    }

    .radio-group label {
        font-weight: normal;
        margin: 0;
        cursor: pointer;
    }

    input[type="radio"] {
        accent-color: #667eea;
        cursor: pointer;
    }

    .buttons {
        display: flex;
        gap: 12px;
        margin-top: 25px;
    }

    input[type="submit"],
    input[type="reset"] {
        flex: 1;
        padding: 12px;
        border: none;
        border-radius: 7px;
        color: white;
        font-size: 15px;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"] {
        background-color: #667eea;
    }

    input[type="submit"]:hover {
        background-color: #4c5fd5;
    }

    input[type="reset"] {
        background-color: #e74c3c;
    }

    input[type="reset"]:hover {
        background-color: #c0392b;
    }

    @media (max-width: 500px) {
        .form-container {
            width: 90%;
            padding: 22px;
        }
    }
</style>

</head>
<body>

    <div class="form-container">

        <h2>User Information Form</h2>

        <form action="result.jsp" method="post">

            <div class="form-group">
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName"
                       name="fullName" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password"
                       name="password" required>
            </div>

            <div class="form-group">
                <label for="age">Age:</label>
                <input type="text" id="age"
                       name="age" required>
            </div>

            <div class="form-group">
                <label>Address (Radio):</label>

                <div class="radio-group">
                    <label>
                        <input type="radio" name="radioAddress"
                               value="Cairo" required>
                        Cairo
                    </label>

                    <label>
                        <input type="radio" name="radioAddress"
                               value="Alex">
                        Alex
                    </label>

                    <label>
                        <input type="radio" name="radioAddress"
                               value="Menofia">
                        Menofia
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label for="address">Address (Select):</label>

                <select id="address" name="address">
                    <option value="Cairo">Cairo</option>
                    <option value="Alex">Alex</option>
                    <option value="Menofia">Menofia</option>
                </select>
            </div>

            <div class="buttons">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </div>

        </form>

    </div>

</body>
</html>
