package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;


@WebServlet(name="AddCar",  urlPatterns={"/addCar"})
@MultipartConfig(maxFileSize = 16177215) 
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		int res=0;
		String carnum = request.getParameter("carnum");
		String town_id=request.getParameter("town_id");
		String moneypermin=request.getParameter("moneypermin");
		String street=request.getParameter("street");
		int t_id=Integer.parseInt(town_id);
		double mpm=Double.parseDouble(moneypermin);
		
		DBConnection conn = DBConnection.getInstance();
		
		String query="insert into cars(carnum,battery,town_id,moneypermin,clean,isfree,street) values('"+carnum+"',100,"+t_id+","+mpm+",100,true,'"+street+"')";
		try {
			res=conn.insert(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			 
        
	    response.sendRedirect("addBonuses.html");
	
		
		
	}
}

