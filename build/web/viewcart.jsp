<%-- 
    Document   : viewcart
    Created on : Oct 3, 2019, 9:53:34 AM
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="cart.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Cart</title>
    </head>
    <body>
        <h1>Your cart:</h1>
        <c:set var="cart" value="${sessionScope.CART}" />
        <c:if test="${not empty cart}">
            <c:set var="cartItems" value="${cart.items}" />
            <c:if test="${not empty cartItems}">
                <form action="DispatchController">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Name</th>
                                <th>Quantity</th>                           
                                <th>Action</th>                                       

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="entry" items="${cartItems}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${entry.key}</td>
                                    <td>${entry.value}</td>
                                    <td>
                                        <input type="checkbox" name="checkItem" value="${entry.key}" />
                                    </td>                               
                                </tr>
                            </c:forEach>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" name="btnAction" value="Remove seleted books"/>
                                    </td>
                                    <td colspan="2" style="text-align: center">
                                        <a href="shopping.html">Go shopping</a>
                                    </td>
                                </tr>
                        </tbody>
                    </table>
                </form>
            </c:if>
        </c:if>
        <c:if test="${empty cart}">
            <h2>Cart does not exist!</h2>
        </c:if>

        <%--<%
            // 1. go to cart place
            if (session != null) {
                // 2. get cart
                Cart cartObj = (Cart) session.getAttribute("CART");
                if (cartObj != null) {
                    Map<String, Integer> items = cartObj.getItems();
                    if (items != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                %>
            <form action="DispatchController">
                <%
                    for (String itemName : items.keySet()) {
                %>
                <tr>
                    <td><%= ++count%></td>
                    <td><%= itemName%></td>
                    <td><%= items.get(itemName)%></td>
                    <td>
                        <input type="checkbox" name="chkItem" value="<%= itemName%>" />
                    </td>
                </tr>   
                <%
                    }

                %>
                <tr>
                    <td colspan="3">
                        <a href="shopping.html">Add more books to cart</a> 
                    </td>
                    <td>
                        <input type="submit" name="btnAction" value="Remove seleted books" />
                    </td>
                </tr>
            </form>
        </tbody>
    </table>

    <%                        return;
                }
            }
        }
    %>

    <h2>Cart does not exist!</h2>
        --%>

    </body>
</html>
