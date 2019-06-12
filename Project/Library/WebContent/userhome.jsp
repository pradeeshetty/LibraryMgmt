<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@page import="com.DbConnection.*,java.util.*"%>
<!DOCTYPE HTML>
<html>
<head>
<title>The Public-Library a Educational Category Flat Responsive web template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='//fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
</head>
<body>

<%
      if (session != null) {
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.print("Hello, " + name + "  Welcome to ur Profile");
         } else {
            response.sendRedirect("login.jsp");
         }
      }
   %>


<div class="btm_border">
<div class="h_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<h1><a href="index.html"><img src="images/logo.png" alt=""></a></h1>
		</div>
		<div class="social-icons">
			<ul>
			     <li><a class="facebook" href="https://fb.com/whopradeep" target="_blank"> </a></li>
			     <li><a class="twitter" href="https://twitter.com/pradeeshetty" target="_blank"></a></li>
			    
		   </ul>
		</div>	
		<div class="clear"></div>
	</div>
	<div class='h_btm'>
		<div class='cssmenu'>
			<ul>
			    <li class='active'><a href='userhome.jsp'><span>Home</span></a></li>
			    <li><a href='about.jsp'><span>About</span></a></li>
			    <li class='has-sub'><a href='userbooks.jsp'><span>Books</span></a></li>
			    <li><a href='usermsg.jsp'><span>Messages</span></a></li>
			 
			    <li class='last'><a href='Logout'><span>Logout</span></a></li>
			 	<div class="clear"></div>
			 </ul>
	</div>
	
	<div class="clear"></div>
</div>
</div>
</div>
</div>


<%
String name = (String) session.getAttribute("user");
	
DbConnection d=new DbConnection();
String id=d.getid(name);
request.setAttribute("id", id);

%>









<!------ Slider_bg ------------>
<div class="slider_bg">
<div class="wrap">
	<!------ Slider------------>
		  <div class="slider">
	      	<div class="slider-wrapper theme-default">
	            <div id="slider" class="nivoSlider">
	                <img src="images/banner1.jpg" data-thumb="images/1.jpg" alt="" />
	                <img src="images/banner2.jpg" data-thumb="images/2.jpg" alt="" />
	                <img src="images/banner3.jpg" data-thumb="images/3.jpg" alt="" />
	            </div>
	        </div>
	      </div>
		<!------End Slider ------------>
		
</div>
<!--main-->

<!--footer-->

<!--footer1-->
<div class="ftr-bg">
	<div class="wrap">
		<div class="footer">
		<div class="copy">
			<p class="w3-link">&copy; 2013 Public-Library. All Rights Reserved</a></p>
		</div>
		<div class="clear"></div>	
	</div>
	</div>
</div>
</body>
</html>