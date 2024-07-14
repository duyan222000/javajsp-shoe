package context;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, userID, password);
    }   
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
     private final String serverName = "localhost";
     private final String dbName = "WISH";
     private final String portNumber = "3306";
     private final String userID = "root";
     private final String password = "";
     
//     public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    	 Connection connection = null;
//    	 Statement statement = null;
//    	 ResultSet resultSet = null;
//    	 try {
//    		 connection = new DBContext().getConnection();
//    	     statement = connection.createStatement();
//    	     resultSet = statement.executeQuery("SELECT * FROM product LIMIT 3"); // Lấy 3 sản phẩm đầu tiên
//    	        while (resultSet.next()) {
//    	            int id = resultSet.getInt("id");
//    	            String name = resultSet.getString("name");
//    	            String image = resultSet.getString("image");
//    	            double price = resultSet.getDouble("price");
//    	            String title = resultSet.getString("title");
//    	            String description = resultSet.getString("description");
//    	            
//    	            // In thông tin sản phẩm
//    	            System.out.println("Product ID: " + id);
//    	            System.out.println("Name: " + name);
//    	            System.out.println("Image: " + image);
//    	            System.out.println("Price: " + price);
//    	            System.out.println("Title: " + title);
//    	            System.out.println("Description: " + description);
//    	            System.out.println("------------------------");
//    	        }
//    	 } catch (SQLException e) {
//    	     System.out.println("Failed to connect to the database: " + e.getMessage());
//    	 } finally {
//    	     if (resultSet != null) {
//    	         resultSet.close();
//    	     }
//    	     if (statement != null) {
//    	         statement.close();
//    	     }
//    	     if (connection != null) {
//    	         connection.close();
//    	     }
//    	 }
//     }
}
 
