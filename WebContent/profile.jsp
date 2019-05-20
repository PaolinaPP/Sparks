<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Моят профил</title>
<link rel="stylesheet" type="text/css" href="sparks-css.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="header">
 Sparks
</div>
<div class="row">
<div class="col-2 col-m-3 menu">
<ul>
<li onclick="parent.location='profile.jsp'">Моят профил</li>
<li onclick="parent.location='addTrip.html'">Добави пътуване</li>
<li onclick="parent.location='findCars.jsp'">Намери кола</li>
<li onclick="parent.location='trips.jsp'">Моите пътувания</li>
<li onclick="parent.location='bonuses.html'">Моите бонуси</li>
<li onclick="parent.location='changePassword.html'">Промени парола</li>
<li onclick="parent.location='CheckoutPage.jsp'">Изход</li>

</ul>
					

</div>
<div class="col-7 col-m-9">
<div id="box1">
       <div id="login">
<form class="contact_form" method="get" action="login"  >
    
    <%
//allow access only if session exists
String fname=(String) session.getAttribute("fname");
String lname=(String) session.getAttribute("lname");
String address=(String) session.getAttribute("address");
String egn=(String) session.getAttribute("egn");
String possition=(String) session.getAttribute("possition");
String phone=(String) session.getAttribute("phone");
String email=(String) session.getAttribute("email");
String user = (String) session.getAttribute("user");
//int id=(Integer) session.getAttribute("id_car");
//out.print(id+"\n ");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<h1 style="color:black;">Hello, <%=fname %> <%=lname %>.</h1>
<br>
<div style="color:black;">
Email: <%=address %> </br>
EGN: <%=egn %> </br>
Position: <%=possition %> </br>
Phone: <%=phone %> </br>
</div>
<br>
</form>
</div>
</div>
</div>

<div class="col-3 col-m-12">
……
</div>
</div>
<div class="footerholder">
<div class="footer">
Sparks | All rights reserved. 2019
</div>
</div>
</body>
</body>
</html>