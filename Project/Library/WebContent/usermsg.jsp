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

<style>
table {
    background: #f5f5f5;
    border-collapse: separate;
    box-shadow: inset 0 1px 0 #fff;
    font-size: 12px;
    line-height: 24px;
    margin: 30px auto;
    text-align: left;
    width: 1300px;
}   

th {
    background: url(https://jackrugile.com/images/misc/noise-diagonal.png), linear-gradient(#777, #444);
    border-left: 1px solid #555;
    border-right: 1px solid #777;
    border-top: 1px solid #555;
    border-bottom: 1px solid #333;
    box-shadow: inset 0 1px 0 #999;
    color: #fff;
  font-weight: bold;
    padding: 10px 15px;
    position: relative;
    text-shadow: 0 1px 0 #000;  
}

th:after {
    background: linear-gradient(rgba(255,255,255,0), rgba(255,255,255,.08));
    content: '';
    display: block;
    height: 25%;
    left: 0;
    margin: 1px 0 0 0;
    position: absolute;
    top: 25%;
    width: 100%;
}

th:first-child {
    border-left: 1px solid #777;    
    box-shadow: inset 1px 1px 0 #999;
}

th:last-child {
    box-shadow: inset -1px 1px 0 #999;
}

td {
    border-right: 1px solid #fff;
    border-left: 1px solid #e8e8e8;
    border-top: 1px solid #fff;
    border-bottom: 1px solid #e8e8e8;
    padding: 10px 15px;
    position: relative;
    transition: all 300ms;
}

td:first-child {
    box-shadow: inset 1px 0 0 #fff;
}   

td:last-child {
    border-right: 1px solid #e8e8e8;
    box-shadow: inset -1px 0 0 #fff;
}   

tr {
    
}

tr:nth-child(odd) td {
  
}

tr:last-of-type td {
    box-shadow: inset 0 -1px 0 #fff; 
}

tr:last-of-type td:first-child {
    box-shadow: inset 1px -1px 0 #fff;
}   

tr:last-of-type td:last-child {
    box-shadow: inset -1px -1px 0 #fff;
}   

tbody:hover td {
    color: transparent;
    text-shadow: 0 0 3px #aaa;
}

tbody:hover tr:hover td {
    color: #444;
    text-shadow: 0 1px 0 #fff;
}
</style>

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
			 	
			 </ul>
	</div>
	
	<div class="clear"></div>
</div>
</div>
</div>
</div>
<!------ Slider_bg ------------>
<div class="slider_bg">
<div class="wrap">
	 <form action="BookRequest" method="post">
            	<table>
            	<tr><th>Book Name:</th>  <th> Status:</th></tr>
            	
            	<%
                HttpSession ss=request.getSession(false);  
                String id=(String)ss.getAttribute("id");  
                DbConnection d=new DbConnection();
                String name = (String) session.getAttribute("user");
                String userid=d.getid(name);
            	List l=d.getmsg(userid);
            	 Iterator iterator = l.iterator();
                 while(iterator.hasNext()) {  
                	 
                	 
                	// iterator.next();
                	 
                	 
                	 
                %>

                 <tr>
              <td>   <%=iterator.next() %></td>
                  <td>  Book has been issued goto library and collect it </td>
              
<%--                 <input type="hidden" name="userid" value="<%=userid %>"> --%>
<!--              <td><input type="submit" value="Request"></td> -->
                 </tr>
                <br>
                  <% 
                 }
            	
            	%>
                       </table>     
                       </form>   
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!--footer1-->
<div class="ftr-bg" style="padding: 10px 10px 10px 10px "  >
	<div class="wrap">
		<div class="footer">
		<div class="copy">
			<p class="w3-link">© 2013 Public-Library. All Rights Reserved | Design by&nbsp; <a href="http://w3layouts.com/"> W3Layouts</a></p>
		</div>
		<div class="clear"></div>	
	</div>
	</div>
</div>
</body>
</html>