package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementationJDBC {

public static void main(String[] args) {
		
	Connection connection=null;
	ResultSet resultSet=null;
	Statement statement=null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded successfully");
			String uname="root";
			String password="root1234";
			String url="jdbc:mysql:///test";
			connection=DriverManager.getConnection(url, uname, password);
			statement=connection.createStatement();
			String query="SELECT * FROM test";
			resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id= resultSet.getInt("id");
				String name=resultSet.getString("name");
				int age=resultSet.getInt("age");
				String team= resultSet.getString("team");
				System.out.println(id+"\t"+name+"\t"+age+"\t"+team);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
}
