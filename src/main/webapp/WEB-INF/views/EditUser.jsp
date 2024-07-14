<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>User</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editUserModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editAccount" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit User</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${detail.id}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Username</label>
                                    <input value="${detail.user}" name="username" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input value="${detail.pass}" name="password" type="password" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Seller</label>
                                    <select name="isSell" class="form-select" aria-label="Default select example">
                                        <option value="1" ${detail.isSell == 1 ? 'selected' : ''}>Yes</option>
                                        <option value="0" ${detail.isSell == 0 ? 'selected' : ''}>No</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Admin</label>
                                    <select name="isAdmin" class="form-select" aria-label="Default select example">
                                        <option value="1" ${detail.isAdmin == 1 ? 'selected' : ''}>Yes</option>
                                        <option value="0" ${detail.isAdmin == 0 ? 'selected' : ''}>No</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
