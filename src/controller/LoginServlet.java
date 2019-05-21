package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;
import model.Users;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="/LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private final String userID;
	//private final String password;
	public static String user="";
	public static Users u=new Users();
	public static int id = 0;
	
       
    public static String getUser() {
		return user;
	}

	public void setUser(String user) {
		LoginServlet.user = user;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user = request.getParameter("email");
		String pwd = request.getParameter("password");
		String fname="", lname="", address="", egn="", password="", possition="", phone="", email="";
		int id_car=0;
		
		DBConnection conn = DBConnection.getInstance();
		String selectSQL = "SELECT id,fname,lname,address,egn,password,possition,phone,email FROM users WHERE email='"+user+"'";
		
		ResultSet rs=null;
		try {
			rs = conn.query(selectSQL);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				id=rs.getInt("id");
				fname=rs.getString("fname");
				lname=rs.getString("lname");
				address=rs.getString("address");
				egn=rs.getString("egn");
				password = rs.getString("password");
				possition=rs.getString("possition");
				phone=rs.getString("phone");
				email=rs.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SHA256 newOwner=new SHA256(pwd);
		String hashedPassword = null;
		try {
			
			hashedPassword = newOwner.secureAndVerifyPassword();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password.equals(hashedPassword)){
			
			u.setEmail(user);
			u.setId(id);
			u.setAddress(address);
			u.setEgn(egn);
			u.setFname(fname);
			u.setLname(lname);
			u.setPassword(password);
			u.setPhone(phone);
			u.setPossition(possition);
			u.setEmail(email);
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			session.setAttribute("email", email);
			session.setAttribute("phone", phone);
			session.setAttribute("possition", possition);
			session.setAttribute("egn", egn);
			session.setAttribute("address", address);
			session.setAttribute("id_car", id_car);

			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			if(possition.equals("client")) 
			    response.sendRedirect("profile.jsp");
			else if(possition.equals("employee"))
				response.sendRedirect("employee.jsp");
			else if(possition.equals("admin"))
				response.sendRedirect("admin.jsp");
			request.getSession().setAttribute("http.proxyUser", user);
			request.getSession().setAttribute("http.proxyPassword", hashedPassword);
			
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	

	}

}
