<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Form</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/login.css" rel="stylesheet" type="text/css">
    
    <!-- jQuery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div id="logreg-forms" class="mt-5">
                    <form class="form-signin" action="login" method="get">
                        <h1 class="h3 mb-3 font-weight-normal text-center">Sign in</h1>
                        
<%--                          <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger" role="alert">
                                ${errorMessage}
                            </div>
                        </c:if> --%>
<%--                         <%
				            String alertMessage = (String) request.getAttribute("alertMessage");
				            if (alertMessage != null) {
				                out.println("<script>" + alertMessage + "</script>");
				            }
				        %> --%>
                        
                        <div class="form-group">
                            <input name="user" type="text" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
                        </div>
                        <div class="form-group">
                            <input name="pass" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="form-group form-check">
                            <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Remember me</label>
                        </div>
                        <button class="btn btn-success btn-block" type="submit">
                            <i class="fas fa-sign-in-alt"></i> Sign in
                        </button>
                        <hr>
                        <button class="btn btn-primary btn-block" type="button" id="btn-signup">
                            <i class="fas fa-user-plus"></i> Sign up New Account
                        </button>
                    </form>

                    <form action="signup" method="post" class="form-signup d-none">
                        <h1 class="h3 mb-3 font-weight-normal text-center">Sign up</h1>
                        <div class="form-group">
                            <input name="user" type="text" id="user-name" class="form-control" placeholder="User name" required autofocus>
                        </div>
                        <div class="form-group">
                            <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="form-group">
                            <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required>
                        </div>
                        <button class="btn btn-primary btn-block" type="submit">
                            <i class="fas fa-user-plus"></i> Sign Up
                        </button>
                        <a href="#" id="cancel_signup" class="btn btn-secondary btn-block mt-2">
                            <i class="fas fa-angle-left"></i> Back
                        </a>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function() {
            $('#btn-signup').click(function() {
                $('.form-signin').addClass('d-none');
                $('.form-signup').removeClass('d-none');
            });

            $('#cancel_signup').click(function() {
                $('.form-signup').addClass('d-none');
                $('.form-signin').removeClass('d-none');
            });
        });
    </script>
</body>
</html>
