
<%@page import="java.util.Date" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%!
            public void jspInit() {
                System.out.println("jspInit() is invoked");
            }

            public void jspService() {
                System.out.println("jspService() is invoked");
            }

            public void jspDestroy() {
                System.out.println("jspDestroy() is invoked");
            }
        %>

        <h1>The date of now is: <%=new Date()%></h1>
    </body>
</html>
