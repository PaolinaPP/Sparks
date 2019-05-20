package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Trips;

@WebServlet(name="MyTrips",  urlPatterns={"/trips"})
@MultipartConfig(maxFileSize = 16177215) 
public class MyTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trip_id=0;
		double distance=0;
		double price=0;
		String startpoint="", endpoint="";
		int car_id=0;
		ArrayList<Trips> trips=new ArrayList<Trips>();
		
		
		java.sql.Connection conn = null;
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
		String selectSQL2="SELECT * from trips where client_id=?";
		PreparedStatement st1 = null;
		try {
			st1 = (PreparedStatement) conn.prepareStatement(selectSQL2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			st1.setInt(1, LoginServlet.id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st1.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				trip_id=rs.getInt("id");
				distance=rs.getDouble("distance");
				price=rs.getDouble("price");
				startpoint=rs.getString("startpoint");
				endpoint=rs.getString("endpoint");
				car_id = rs.getInt("car_id");
				Trips tr=new Trips(trip_id,LoginServlet.id,distance,price,startpoint,endpoint,car_id);
				trips.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("trips", trips);
		request.getRequestDispatcher("trips.jsp").forward(request, response);

	    try {
			st1.close();
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
		
		
	}

}

