package controller;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="AddEmployee",  urlPatterns={"/addEmployee"})
@MultipartConfig(maxFileSize = 16177215) 
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public boolean checkEgnPhone(String egn, String phone) {
    	if(egn.length()==10 && phone.length()==10 && egn.matches("[0-9]+") && phone.matches("[0-9]+")) {
    		return true;
    	}
   		return false;
    	
    }
    public static boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
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
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String egn=request.getParameter("egn");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String possition=request.getParameter("possition");
		SHA256 hashpass=new SHA256(password);
		String shp = null;
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();

		if(!checkEgnPhone(egn,phone)) 
			System.out.println("Egn or phone is not correct");
		if (!isValidEmail(email))
			System.out.println("Email is not correct");
		try {
			shp=hashpass.secureAndVerifyPassword();
		} catch (Exception e1) {
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
			java.sql.PreparedStatement st= conn.prepareStatement("INSERT INTO users(fname, lname, address, egn, password, possition, phone, email) values(?,?,?,?,?,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
			st.setString(1,fname);
			st.setString(2, lname);
			st.setString(3, address);
			st.setString(4,egn);
			st.setString(5,shp);
			st.setString(6,"employee");
			st.setString(7, phone);
			st.setString(8,email);
			st.executeUpdate();
			ResultSet rs=st.getGeneratedKeys();
			//get id of the inserted user
			int id = 0;
	        while (rs.next()) {
	            id = rs.getInt(1);
	        }
	        //insert this user into clients
	        java.sql.PreparedStatement st2= conn.prepareStatement("INSERT INTO employees(user_id, possition) values(?,?) ");
	        st2.setInt(1,id);
	        st2.setString(2, possition);
	        st2.executeUpdate();
            
	        st.close();
	        st2.close();
	        response.sendRedirect("admin.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
	}

}