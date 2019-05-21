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
import model.Bonuses;

@WebServlet(name="MyTrips",  urlPatterns={"/trips"})
@MultipartConfig(maxFileSize = 16177215) 
public class MyBonuses extends HttpServlet {
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
		int b_id=0,c_id=0,e_id=0,car_id=0;
		double value=0;
		String descr="";
		ArrayList<Bonuses> bonuses=new ArrayList<Bonuses>();
		
		
		DBConnection conn = DBConnection.getInstance();
		String selectSQL="SELECT * from bonuses where client_id="+LoginServlet.id;
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
				b_id=rs.getInt("id");
				c_id=rs.getInt("client_id");
				value=rs.getDouble("value");
				descr=rs.getString("description");
				e_id=rs.getInt("employee_id");
				car_id = rs.getInt("car_id");
				bonuses.add(new Bonuses(b_id,c_id,value,descr,e_id,car_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("bonuses", bonuses);
		request.getRequestDispatcher("bonuses.jsp").forward(request, response);

	   
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


