package InJDBCutil;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class JDBCutil {
	//take the properties from application drive and load the driver with connectior//
	
	public static  Connection getJdbcConnection() throws IOException, SQLException {
		FileInputStream FIS=new FileInputStream("Application.properties");
		Properties p=new Properties();
		p.load(FIS);
		
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String password=p.getProperty("password");
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
	  
		Connection connection=DriverManager.getConnection(url, user, password);
		return connection;
	}
	//close resources
	
	public  void closeResource(Connection connection, PreparedStatement preparedstatement) throws SQLException {
		if(connection!=null) {
			connection.close();
		}
		if(preparedstatement!=null) {
			preparedstatement.close();
			
		}
	    
		
		
	}

}