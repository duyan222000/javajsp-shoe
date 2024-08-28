<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirmed Purchase</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message {
            margin-bottom: 20px;
        }
        .message a {
            color: blue;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="message">
    	<p><strong>Thank you for using our service!</p>
        <p style="font-style: italic; font-weight: 100; color: #888;">The system has recorded the order. Once again, thank you for your trust and ordering here!</p>
    </div>
    <a href="home">Back to Home</a>
</body>
</html>
