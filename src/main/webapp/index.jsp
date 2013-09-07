<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Twitter Login</title>
    <link href="css/loginTest.css" media="screen" rel="stylesheet" type="text/css" />
</head>
<body class="test">

<table cellpadding='2' cellspacing='0' border='0' id='ap_table'>
    <tr><td bgcolor="blue"><table cellpadding='0' cellspacing='0' border='0' width='100%'><tr><td bgcolor="blue" align=center style="padding-top: 2;padding-right: 2;padding-left: 2;padding-bottom: 4;padding-bottom:4"><font size=-1 color="white" face="verdana,arial"><b>Enter your login and password</b></font></tr>
        <tr><td bgcolor="white" style="padding:5"><br>
            <form method="post" name="aform" action="login" target="_top">
                <input type="hidden" name="action" value="login">
                <input type="hidden" name="hide" value="">
                <center><table>
                    <tr><td><font face="verdana,arial" size=-1>UserName:</font></td><td><input type="text" name="login"  class="inputbox"></td></tr>
                    <tr><td><font face="verdana,arial" size=-1>Password:</font></td><td><input type="password" name="password" class="inputbox"></td></tr>
                    <tr><td><font face="verdana,arial" size=-1>&nbsp;</font></td><td><font face="verdana,arial" size=-1><input type="submit" value="Login"></font></td></tr>
                    <tr><td colspan=2><font face="verdana,arial" size=-1>&nbsp;</font></td></tr>
                    <tr><td colspan=2><font face="verdana,arial" size=-1>Lost your username or password? Find it <a>here</a>!</font></td></tr>
                    <tr><td colspan=2><font face="verdana,arial" size=-1>Not member yet? Click <a>here</a> to register.</font></td></tr>
                </table></center>
            </form>
        </td></tr></table></td></tr></table>

</body>
</html>
--%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="loginForm1.css">
</head>
<body>
<div id="loginContent">
    <section class="dialog-outer">
        <div class="dialog">

            <header>
                <h1 class="logo">Tastebuddy</h1>

            </header>





            <div class="dialog-main">



                <form method="POST" id="login-form" class="adjacent" action="/login">
                    <p><label for="id_username">Username:</label> <input name="userName" maxlength="30" autocapitalize="off" autocorrect="off" type="text" id="id_username" /></p>
                    <p><label for="id_password">Password:</label> <input autocapitalize="off" autocorrect="off" type="password" name="password" id="id_password" /></p>
                    <p class="form-actions">
                        <a href="/accounts/password/reset/">Forgot password?</a>
                        <input type="submit" class="button-green" value="Log in" />
                    </p>
                </form>
            </div>

        </div>
    </section>

</div>

</body>
</html>

