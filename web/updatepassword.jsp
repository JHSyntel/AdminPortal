<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Password</title>
    </head>
    <body>
        <h1>Update Admin Password</h1>
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>

            <s:form action="updatepass">
                <s:password name="new_pass" placeholder="New Password" size="20" />
                <s:password name="new_pass2" placeholder="Confirm Password" size="20" />
                <s:password name="old_pass" placeholder="Old Password" size="20" />
                <s:submit name="submit" label="Submit" />
            </s:form>           
    </body>
</html>
