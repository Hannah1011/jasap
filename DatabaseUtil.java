package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	public static Connection getConnection()  { //�����ͺ��̽��� ������� ����
		try {
			String dbURL = "jdbc:mysql://127.0.0.1:3306/registerdb";
			String dbID = "molcham";
			String dbPassword = "e0e867e6^^!!";
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return null;
	}
}