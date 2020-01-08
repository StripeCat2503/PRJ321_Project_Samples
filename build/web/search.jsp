<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@page import="com.account.AccountDTO"%>
<%@page import="com.account.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <font style="color: red">Welcome, ${sessionScope.loginBean.lastname}!</font>
        <c:url var="logoutURL" value="DispatchController">
            <c:param name="btnAction" value="Logout" />
        </c:url>
        <a href="${logoutURL}">Logout</a>
        <h1>Search Page</h1>
        <form action="DispatchController" method="GET">
            Search Value <input type="text" name="txtSearch" value="${param.txtSearch}"/> <br>
            <input type="submit" value="Search" name="btnAction"/>
        </form>

        <c:set var="searchValue" value="${param.txtSearch}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.searchResult}" />

            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Is Admin</th>                          
                            <th>Delete</th>                                
                            <th>Update</th>                                
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="DispatchController">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                </td>
                                <td>                                   
                                    <input type="password" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>
                                    ${dto.lastname}
                                </td>
                                <td>
                                    <input type="checkbox" name="checkAdmin" value="ON"
                                           <c:if test="${dto.role}">
                                               checked
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="urlRewriting" value="DispatchController">
                                        <c:param name="btnAction" value="Delete"/>
                                        <c:param name="username" value="${dto.username}"/>
                                        <c:param name="lastSearchValue" value="${searchValue}" />
                                    </c:url>
                                    <a href="${urlRewriting}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Update"/>
                                    <input type="hidden" name="lastSearchValue" value="${searchValue}"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No result!</h2>
        </c:if>
    </c:if>

    <%-- <% 
        Cookie[] cookies = request.getCookies();
        String username = "";
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(!cookie.getName().equals("JSESSIONID")){
                    username = cookie.getName();
                }
            }
        }
       
    %>
    <p style="color: red">Welcome, <%=username%>!</p>
    
    <% 
        String logoutUrl = "DispatchController?"
                           + "btnAction=Logout";
    %>
    
    <a href="<%= logoutUrl %>">Log out</a>
    <h1>Search Page</h1>
    <form action="DispatchController" method="GET">
        Search Value <input type="text" name="txtSearch"/> <br>
        <input type="submit" value="Search" name="btnAction"/>
    </form>

        <%
            String searchValue = request.getParameter("txtSearch");

            if (searchValue != null) {
                List<AccountDTO> result = (List<AccountDTO>) request.getAttribute("searchResult");
                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Last name</th>
                    <th>Is Admin</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;

                    for (AccountDTO dto : result) {
                        String urlRewriting = "DispatchController"
                                + "?btnAction=Delete"
                                + "&username=" + dto.getUsername()
                                + "&lastSearchValue=" + searchValue;
                %>
                <tr>
                    <form action="DispatchController">
                        <td><%= ++count%></td>
                        <td>
                            <%= dto.getUsername()%>
                            <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>"/>
                        </td>
                        <td>
                            <input type="password" name="txtPassword" value="<%= dto.getPassword()%>"/>
                        </td>
                        <td>                         
                            <input type="text" name="txtLastname" value="<%= dto.getLastname()%>"/>
                        </td>
                        <td>                                              
                            <input type="checkbox" name="checkAdmin" value="ON" 
                                   <% if(dto.isAdmin()){ %> 
                                        checked 
                                   <% } %>
                            />
                        </td>                   
                        <td>
                            <a href="<%= urlRewriting%>">Delete</a>
                        </td>       
                        <td>
                            <input type="hidden" value="<%= searchValue %>" name="lastSearchValue" />
                            <input type="submit" value="Update" name="btnAction" />
                        </td>
                    </form>
                </tr>
        <%
            }
        %>
    </tbody>
</table>
<%
} else {
%>
<h2>No result!</h2>
<%
        }
    }
%> --%>


</body>
</html>
