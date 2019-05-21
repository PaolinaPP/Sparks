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


@WebServlet(name="AddBonus",  urlPatterns={"/addBonuses"})
@MultipartConfig(maxFileSize = 16177215) 
public class AddBonus extends HttpServlet {
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
		String car_id = request.getParameter("car_id");
		String client=request.getParameter("client_id");
		int c_id=Integer.parseInt(car_id);
		int cl_id=Integer.parseInt(client);
		
		String description=request.getParameter("descripton");
		String value=request.getParameter("value");
		double v=Double.parseDouble(value);
		
		DBConnection conn = DBConnection.getInstance();
		//String query = "insert into bonuses(client_id,value,description,employee_id,car_id) values("+cl_id+","+v+",'"+description+"',"+LoginServlet.id+","+c_id+")";
		String query="insert into bonuses(client_id,value,description,employee_id,car_id) values(16,12.30,'miene',19,1)";
		try {
			res=conn.insert(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			 
        
	    response.sendRedirect("addBonuses.html");
	
		
		
	}
}

