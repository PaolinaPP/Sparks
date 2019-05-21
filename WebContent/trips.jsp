<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@page import="java.util.List"%>
    <%@ page import="model.Trips" %>
    <%@ page import="controller.LoginServlet" %>
    <%@ page import="db.DBConnection" %>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trips</title>
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
<li onclick="parent.location='bonuses.jsp'">Моите бонуси</li>
<li onclick="parent.location='changePassword.html'">Промени парола</li>
<li onclick="parent.location='CheckoutPage.jsp'">Изход</li>

</ul>
</div>
<div class="col-7 col-m-9">
<div id="box1">
       <div id="login">
<form class="contact_form" method="get" action="trips"  >
    
 
<br>
<div style="color:black;">
<%
DBConnection conn = DBConnection.getInstance();
String selectSQL="SELECT * from trips where client_id="+LoginServlet.id;

ResultSet rs = null;

	rs = conn.query(selectSQL);


while (rs.next()) {%>
	
	<TR>
    <TD>Trip id : <%= rs.getInt("id") %></td>
    <TD>Trip distance:  <%= rs.getDouble("distance") %></TD>
    <TD>Trip price: <%= rs.getDouble("price") %></TD>
    <TD>Trip start point: <%= rs.getString("startpoint") %></TD>
    <TD>Trip end point: <%= rs.getString("endpoint") %></TD>
    <TD>Car id: <%= rs.getInt("car_id") %></TD></br></br>
</TR>
	
<%}%> 
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