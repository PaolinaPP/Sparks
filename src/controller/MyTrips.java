package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;
import model.Trips;

@WebServlet(name="MyTrips",  urlPatterns={"/trips"})
@MultipartConfig(maxFileSize = 16177215) 
public class MyTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPOst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trip_id=0;
		double distance=0;
		double price=0;
		String startpoint="", endpoint="";
		int car_id=0;
		ArrayList<Trips> trips=new ArrayList<Trips>();
		
		
		DBConnection conn = DBConnection.getInstance();
		String selectSQL="SELECT * from trips where client_id="+LoginServlet.id;
		HttpSession session = request.getSession();

		ResultSet rs = null;
		try {
			rs = conn.query(selectSQL);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				trip_id=rs.getInt("id");
				distance=rs.getDouble("distance");
				price=rs.getDouble("price");
				startpoint=rs.getString("startpoint");
				endpoint=rs.getString("endpoint");
				car_id = rs.getInt("car_id");
				trips.add(new Trips(trip_id,LoginServlet.id,distance,price,startpoint,endpoint,car_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("trips", trips);
		request.getRequestDispatcher("trips.jsp").forward(request, response);

	   
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

