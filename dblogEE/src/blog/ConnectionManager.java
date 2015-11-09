package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost/mydb";
	final static String USER = "root";
	final static String PASS = "moca0822";
	
	/* DB接続 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("fail to class load : " + e.getMessage());
		}
		
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		
		return con;
	}

	/* DB接続テスト */
	public static void main(String[] args) throws SQLException {
		Connection con = getConnection();
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from topic");
		while (rs.next()) {
			String s = "ID=" + rs.getString("ID")
				+ ",CONTENT=" + rs.getString("CONTENT")
				+ ",POST_DATE=" + rs.getString("POST_DATE");
			System.out.println(s);
		}
		smt.close();
		con.close();
		System.out.println("END");
	}
}
