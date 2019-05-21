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
		double moneypermin=0;
		double price=0;
		@SuppressWarnings("unused")
		int res=0;
		String car_id = request.getParameter("car_id");
		int c_id=Integer.parseInt(car_id);
		String startpoint=request.getParameter("startpoint");
		String endpoint=request.getParameter("endpoint");
		String distance=request.getParameter("distance");
		double d=Double.parseDouble(distance);
		
		DBConnection conn = DBConnection.getInstance();
		String query = "select moneypermin from cars where id="+c_id;
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
        price = d*moneypermin;
        String query2 = "insert into trips(client_id,distance,price,startpoint,endpoint,car_id) values("+LoginServlet.id+","+d+","+price+",'"+startpoint+"','"+endpoint+"',"+c_id+")";
       try {
			res=conn.insert(query2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       String sql="update  cars set street='"+endpoint+"' where id="+c_id;
       try {
		res=conn.insert(sql);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    response.sendRedirect("addTrip.html");
	
		
		
	}
}
