package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBConnection {
    public Connection con;
    private Statement statement;
    public static DBConnection db;

    private DBConnection() {
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "sparks?autoReconnect=true&useSSL=false";
	String driver = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "P@ssw0rd!";
	try {
	    Class.forName(driver).newInstance();
	    this.con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
	} catch (Exception sqle) {
	    sqle.printStackTrace();
	}
    }
    
    public static DBConnection getInstance() {
	if(db == null)
	    db = new DBConnection();
	return db;
    }
    
    
    public ResultSet query(String query) throws SQLException{
        statement = db.con.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    public int insert(String insertQuery) throws SQLException {
        statement = db.con.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }

}
