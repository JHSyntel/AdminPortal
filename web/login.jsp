<%-- 
    Document   : login
    Created on : Apr 24, 2015, 10:41:24 AM
    Author     : JE5024472
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>%
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="WebStyle1.css" rel="stylesheet" type="text/css" />
        <title>Admin Login</title>
    </head>
    <body>
        <fieldset>
            <legend>Administrator Login</legend>

            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>

            <s:form action="login">
                <s:textfield name="username" placeholder="Username" size="20" />
                <s:password name="password" placeholder="Password" size="20" />
                <s:submit name="submit" label="Submit" />
            </s:form>    
        </fieldset>
    </body>
</html>
