<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Cars" %>
    <%@page import="java.util.List"%>
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
<form class="contact_form" method="get" action="findCars"  >
    
<% 
		String selectSQL = "SELECT id,carnum, battery, town_id, moneypermin, clean, isfree, street FROM cars";
		DBConnection conn = DBConnection.getInstance();
		ResultSet rs = null;
		
		rs = conn.query(selectSQL);
		
		
		while (rs.next()) {%>
		<TR>
                <TD>Car id : <%= rs.getInt("id") %></td>
                <TD>Car number:  <%= rs.getString("carnum") %></TD>
                <TD>Car battery: <%= rs.getInt("battery") %></TD>
                <TD>Town id: <%= rs.getInt("town_id") %></TD>
                <TD>Money per minute: <%= rs.getDouble("moneypermin") %></TD>
                <TD>Clean percent: <%= rs.getInt("clean") %></TD>
                <TD>Street: <%= rs.getString("street") %></TD></br></br>
            </TR>
			
			
		<%}%>
		<%!
		/*public void func(){
		DBConnection conn = DBConnection.getInstance();
		String a = request.getParameter("id");
		int id=Integer.parseInt(a);
		String sql="update  cars set isfree=false where id="+id;
	    if(a != null){
	        int res=conn.insert(sql);
	        
	     }
	    }*/ %>

<br>
</form>
</div>
</div>
</div>

<div class="col-3 col-m-12">
<p><input type="text" name="id" value="" placeholder="Car id"></p>
<input class="submit_button" name="carId" type="submit" value="Reserve Car" />
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