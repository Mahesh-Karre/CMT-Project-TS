<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="styles.css" rel="stylesheet"/>
    </head>
    <body>
    <center>
    <h1>Contract Management Tool</h1>
    <form action="index.jsp" method="POST">
        <h3>Login</h3>
        <table style="text-align:left">
            <tbody>
                <tr>
                    <td>Username :</td>
                    <td><input type="text" name="uname"  size="15" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="pwd" size="15" /></td>
                </tr>
            </tbody>
        </table>
        <p/>
        <input type="submit" value="Login" />
    </form>
    
    <%
       if ( request.getParameter("uname") == null) // first request
             return;
    %>
    
    <jsp:useBean id="user" scope="session" class="cmt.UserBean" />
    <jsp:setProperty name="user" property="*"/>
    <%
     if ( user.login())   
     {   session.setAttribute("logged","yes"); // used by filter
         response.sendRedirect("home.jsp");  
     }
     else
         out.println("<h4>Sorry! Invalid Login.</h4>");
    %>     
    
    </center>
    
    </body>
</html>
