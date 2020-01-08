<%-- 
    Document   : registerAccount
    Created on : Oct 10, 2019, 9:20:15 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new Account</title>
    </head>
    <body>
        <h1>Register account</h1>
        <form action="DispatchController" method="POST">
            <c:set var="errors" value="${requestScope.errors}" />
            Username <input type="text" name="txtUsername" value="${param.txtUsername}" /> (6 - 20 chars)<br>
            <c:if test="${not empty errors.usernameLengthError}">
                <font style="color: red">${errors.usernameLengthError}</font><br>
            </c:if>
            Password <input type="password" name="txtPassword" value="" /> (6 - 20 chars)<br>
             <c:if test="${not empty errors.passwordLengthError}">
                <font style="color: red">${errors.passwordLengthError}</font><br>
            </c:if>
            Confirm <input type="password" name="txtConfirm" value="" /> (6 - 20 chars)<br>
             <c:if test="${not empty errors.confirmNotMatchError}">
                <font style="color: red">${errors.confirmNotMatchError}</font><br>
            </c:if>
                Last name <input type="text" name="txtLastname" value="${param.txtLastname}" /> (2 - 30 chars)<br>
            <c:if test="${not empty errors.lastnameLengthError}">
                <font style="color: red">${errors.lastnameLengthError}</font><br>
            </c:if>
            <input type="submit" name="btnAction" value="Create new account" />
            <input type="reset" value="Reset"/><br>
            <c:if test="${not empty errors.duplicatedUsernameError}">
                <font style="color: red">${errors.duplicatedUsernameError}</font>
            </c:if>
        </form>
    </body>
</html>
