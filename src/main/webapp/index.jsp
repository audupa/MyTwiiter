<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Twitter Login</title>
</head>
<body>
<table cellpadding='2' cellspacing='0' border='0' id='ap_table'>
    <tr><td bgcolor="blue"><table cellpadding='0' cellspacing='0' border='0' width='100%'><tr><td bgcolor="blue" align=center style="padding-top: 2;padding-right: 2;padding-left: 2;padding-bottom: 4;padding-bottom:4"><font size=-1 color="white" face="verdana,arial"><b>Enter your login and password</b></font></tr>
        <tr><td bgcolor="white" style="padding:5"><br>
            <form method="post" name="aform" action="login" target="_top">
                <input type="hidden" name="action" value="login">
                <input type="hidden" name="hide" value="">
                <center><table>
                    <tr><td><font face="verdana,arial" size=-1>Username:</font></td><td><input type="text" name="login"></td></tr>
                    <tr><td><font face="verdana,arial" size=-1>Password:</font></td><td><input type="password" name="password"></td></tr>
                    <tr><td><font face="verdana,arial" size=-1>&nbsp;</font></td><td><font face="verdana,arial" size=-1><input type="submit" value="Login"></font></td></tr>
                    <tr><td colspan=2><font face="verdana,arial" size=-1>&nbsp;</font></td></tr>
                    <tr><td colspan=2><font face="verdana,arial" size=-1>Lost your username or password? Find it <a>here</a>!</font></td></tr>
                    <tr><td colspan=2><font face="verdana,arial" size=-1>Not member yet? Click <a>here</a> to register.</font></td></tr>
                </table></center>
            </form>
        </td></tr></table></td></tr></table>
</body>
</html>
