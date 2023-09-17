package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import InJDBCutil.JDBCutil;

public class UpdateQuery {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		
		try {
			connection=JDBCutil.getJdbcConnection();
			
			if(connection!=null) {
				Scanner sc=new Scanner(System.in);
				
				String mysqlQuery="Update student set result=? where id=?";
				
				preparedstatement=connection.prepareStatement(mysqlQuery);
				
				if(preparedstatement!=null) {
					
					System.out.println("Enter the id which you want to update");
					
					int id=sc.nextInt();	
					
					System.out.println("Enter the  update result");
					String result=sc.next();
					
					
					preparedstatement.setString(1, result);
					preparedstatement.setInt(2, id);
					
					
					int roweffected=preparedstatement.executeUpdate();
					if(roweffected==1) {
						System.out.println("Row inserted");
					}else {
						System.out.println("Row not inserted");
						
					}
				}
		
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil jdbCutil = new JDBCutil();
			try {
				jdbCutil.closeResource(connection, preparedstatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
