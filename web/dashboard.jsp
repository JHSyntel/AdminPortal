
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

 <%
    HttpSession sess = request.getSession(true);
    if (sess.getAttribute("username")==null)
    {
    %>
        <jsp:forward page="/login.jsp?msg=You will have to login first in order to access other pages"></jsp:forward>
    <%
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="WebStyle1.css" rel="stylesheet" type="text/css" />
        <title>Admin Dashboard</title>
    </head>
    
    <body>
        <header><h1>Welcome to the Administrator Dashboard...<s:property value="#session['username']"/> </h1></header>
       
        <s:form action="logout"><s:submit name="logout" value="Logout"/></s:form>
            <ul>
                <li><a href="#">Manage Customers</a></li>
                <li><a href="#">Manage Branches</a></li>
                <li><a href="#">Verify Checks</a></li>
                <li><a href="updatepassword.jsp">Change Password</a></li>
            </ul>
        
        
        <footer>Copyright &copy 2015 Bank of Kyle</footer>
    </body>
    
</html>
