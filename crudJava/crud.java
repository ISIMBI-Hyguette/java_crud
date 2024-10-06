import java.sql.*;
import java.util.*;


public class crud {

	public static void main(String[] args) {
		String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		String JDBC_URL="jdbc:mysql://localhost:3306/javaCrud";
		String username="root";
		String password ="karabo";
		
		try{
			Class.forName(JDBC_DRIVER);
			Connection connection=DriverManager.getConnection(JDBC_URL,username,password);
			Statement statement = connection.createStatement();
			
			String query="CREATE TABLE IF NOT EXISTS users(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255),email VARCHAR(255))";
			
			statement.executeUpdate(query);
			Scanner scan= new Scanner(System.in);
			
			System.out.println("1.Add User");
			System.out.println("2.Read User");
			System.out.println("2.Update User");
			System.out.println("2.Delete User");
			
			System.out.println("Enter Choice:");
			
			String choice=scan.nextLine();
			
			switch(choice) {
			case "1":;
			System.out.println("Enter the user name:");
			String name=scan.nextLine();
			
			System.out.print("Enter user email:");
			String email=scan.nextLine();
			
			query = "INSERT INTO users(name,email) VALUES ('"+name+"','"+email+"')";
			break;
			case "2":;
			System.out.println("Enter user id:");
			int id = scan.nextInt();
			query = "SELECT * FROM users WHERE id ="+id;
			
			ResultSet rs =statement.executeQuery(query);
			
			if(rs.next()) {
				System.out.println("ID:"+rs.getInt("id"));
				System.out.println("Name:"+rs.getString("name"));
				System.out.println("Email:"+rs.getString("email"));
				
				
			}else {
				System.out.println("User not found !");
			}
			break;
			case "3":
				System.out.println("Enter user id:");
				id=scan.nextInt();
				
				scan.nextLine();//it skips a line
				
				System.out.println("Enter new  user name:");
			    name=scan.nextLine();
				
				System.out.println("Enter new user email:");
				email=scan.nextLine();
			
				query="UPDATE  users SET name='"+name+"',email='"+email+"' WHERE id= "+id;
				
				int result=statement.executeUpdate(query);
				
				if(result>0) {
					System.out.println("user updated successfully!");
					
				}else {
					System.out.println("User not found");
				}
			case "4":
				System.out.println("Enter user id:");
				id=scan.nextInt();
				
                query="DELETE FROM users WHERE id="+id;
				
				result=statement.executeUpdate(query);
				
				if(result>0) {
					System.out.println("user deleted successfully!");
					
				}else {
					System.out.println("User not found");
				
			
			}
			
			
			
			statement.executeUpdate(query);
			
			statement.close();
			connection.close();
			
		}
		}

	
		catch(Exception e) {
			System.out.println("Error"+ e.getMessage());
		}

}
}

