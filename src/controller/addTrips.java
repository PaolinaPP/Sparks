package controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="addTrips",  urlPatterns={"/addTrip"})
@MultipartConfig(maxFileSize = 16177215) 
public class addTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int car_id = 0;
		
		//Users u=new Users();
		try {
			car_id = ((ResultSet) request).getInt("car_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String startpoint=request.getParameter("startpoint");
		String endpoint=request.getParameter("endpoint");
		double moneypermin=0;
		double distance=0;
		double price=0;
		try {
			distance=((ResultSet) request).getDouble("distance");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
       try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sparks?autoReconnect=true&useSSL=false","root", "P@ssw0rd!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//insert user into users
			 String query = "select moneypermin from cars where id=?";

		      // create the java statement
		      Statement st = conn.createStatement();
			((PreparedStatement) st).setInt(1,car_id);
			ResultSet rs = st.executeQuery(query);
			
	        while (rs.next()) {
	            moneypermin = rs.getDouble(1);
	        }
	        
	        String query2 = "insert into trips(client_id,distance,price,startpoint,endpoint,car_id) values(?,?,?,?,?,?)";
	        Statement st2 = conn.createStatement();
			((PreparedStatement) st2).setInt(1,LoginServlet.id);
			((PreparedStatement) st2).setDouble(2,distance);
			price = distance*moneypermin;
			((PreparedStatement) st2).setDouble(3,price);
			((PreparedStatement) st2).setString(4,startpoint);
			((PreparedStatement) st2).setString(5,endpoint);
			((PreparedStatement) st2).setInt(6,car_id);
			
			ResultSet rs2 = st2.executeQuery(query2);
	        st.close();
	        st2.close();
	        rs2.close();
	        rs.close();
	        //response.sendRedirect("login.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
	}
}
