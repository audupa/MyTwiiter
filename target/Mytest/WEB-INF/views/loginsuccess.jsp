<!doctype html>

<html lang="en">

<%@page import="com.intuit.classes.User"%>
<%
   User user=(User)request.getAttribute("user");%>
<%int id=user.getId();%>
<%String name=user.getUserName();%>
<head>
    <meta charset="utf-8" />
    <title>jQuery UI Sortable - Default functionality</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.21/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css" />
    <link href="/css/loginTest.css" media="screen" rel="stylesheet" type="text/css" />

    <style>
        #sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
        #sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
        #sortable li span { position: absolute; margin-left: -1.3em; }

    </style>
    <script>
        $(function() {
            $( "#tabs" ).tabs();

            $( "#sortable" ).sortable();
            $( "#sortable" ).disableSelection();

        });

        function logout(){
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    </script>
</head>
<body>

<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Home</a></li>
        <li><a href="#tabs-2">@Connect</a></li>
        <li><a href="#tabs-3">#Discover</a></li>

        <a href="index.jsp" id="sign_out_link" onclick="return confirm('Are you sure you want to sign out?');">Sign out</a>
    </ul>
    <div id="tabs-1">

        <!-- Profile pic -->

        <div >
            <img src = "contact.jpg" height = "100"  width ="100">
            <p> Hello <%out.print(name);%> </p>

        </div>


        <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
        <ul id="sortable1">
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 1</li>
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 2</li>
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 3</li>
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 4</li>
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 5</li>
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 6</li>
            <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 7</li>
        </ul>
    </div>

  </div>

</body>
</html>
