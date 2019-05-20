<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@page import="java.util.List"%>
    <%@ page import="model.Trips" %>
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
<form class="contact_form" method="get" action="login"  >
    
    <%
//allow access only if session exists
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
<br>
<div style="color:black;">
<%
List<Trips> std = new ArrayList<Trips>();
        std= (ArrayList<Trips>)request.getAttribute("trips"); 
        if(std.isEmpty()==false){
        for(Trips s:std){
       
           
                out.print(s.getStartpoint()+ " ");
                out.print(s.getEndpoint()+ " ");
                out.print(s.getDistance()+ " ");
                out.print(s.getPrice()+ " ");
                out.print(s.getCar_id()+ "\n\n");
               
           
            }}%> 
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