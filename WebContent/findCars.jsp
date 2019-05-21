<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Cars" %>
    <%@page import="java.util.List"%>
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
<li onclick="parent.location='bonuses.html'">Моите бонуси</li>
<li onclick="parent.location='changePassword.html'">Промени парола</li>
<li onclick="parent.location='CheckoutPage.jsp'">Изход</li>

</ul>
</div>
<div class="col-7 col-m-9">
<div id="box1">
       <div id="login">
<form class="contact_form" method="get" action="findCars"  >
    
<%
List<Cars> std = new ArrayList<Cars>();
std.addAll((ArrayList<Cars>)request.getAttribute("cars"));
       // std= (ArrayList<Cars>)request.getAttribute("cars"); 
        if(std.isEmpty()==false){
		       for(Cars s:std){
		      
		          
		               out.print(s.getId()+ " ");
		               out.print(s.getCarnum()+ " ");
		               out.print(s.getBattery()+ " ");
		               out.print(s.getClean()+ " ");
		               out.print(s.getTown_id()+ " ");
		               out.print(s.getMoneypermin()+ "");
		               out.print(s.getStreet()+ " \n\n");

           
                }
		 }
%>

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