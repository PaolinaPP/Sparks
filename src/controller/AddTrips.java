package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;


@WebServlet(name="AddTrips",  urlPatterns={"/AddTrip"})
@MultipartConfig(maxFileSize = 16177215) 
public class AddTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int car_id = 0;
		double moneypermin=0;
		double distance=0;
		double price=0;
		//Users u=new Users();
		try {
			car_id = ((ResultSet) request).getInt("car_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String startpoint=request.getParameter("startpoint");
		String endpoint=request.getParameter("endpoint");
		try {
			distance=((ResultSet) request).getDouble("distance");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DBConnection conn = DBConnection.getInstance();
		String query = "select moneypermin from cars where id="+car_id;
		ResultSet rs=null;
		try {
			rs = conn.query(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			 
        try {
			while (rs.next()) {
			    moneypermin = rs.getDouble("moneypermin");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        price = distance*moneypermin;
        String query2 = "insert into trips(client_id,distance,price,startpoint,endpoint,car_id) values("+LoginServlet.id+","+distance+","+price+","+startpoint+","+endpoint+","+car_id+")";
       try {
		@SuppressWarnings("unused")
		int res=conn.insert(query2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        //response.sendRedirect("login.html");
	
		
		
	}
}
