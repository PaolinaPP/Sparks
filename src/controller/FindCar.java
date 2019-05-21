package controller;

import java.io.IOException;
import java.sql.DriverManager;
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
import javax.servlet.http.HttpSession;

import db.DBConnection;
import model.Cars;

@WebServlet(name="FindCar",  urlPatterns={"/findCars"})
@MultipartConfig(maxFileSize = 16177215) 
public class FindCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cars> cars=new ArrayList<Cars>();
		boolean isfree=false;
		String carnum="", street="";
		int battery=0, clean=0, car_id=0, town_id=0;
		double moneypermin=0;
		
		String selectSQL = "SELECT id,carnum, battery, town_id, moneypermin, clean, isfree, street FROM cars";
		//String selectSQL = "SELECT id FROM cars";
		System.out.println("here\n");
		DBConnection conn = DBConnection.getInstance();
		ResultSet rs = null;
		try {
			rs = conn.query(selectSQL);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		
		try {
			while (rs.next()) {
				car_id=rs.getInt("id");
				carnum=rs.getString("carnum");
				System.out.println(carnum);
				battery=rs.getInt("battery");
				town_id=rs.getInt("town_id");
				moneypermin=rs.getDouble("moneypermin");
				clean=rs.getInt("clean");
				isfree=rs.getBoolean("isfree");
				street=rs.getString("street");
				if(isfree)	
					cars.add(new Cars(car_id,carnum,battery,town_id,moneypermin,clean,isfree,street));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("cars", cars);

		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
