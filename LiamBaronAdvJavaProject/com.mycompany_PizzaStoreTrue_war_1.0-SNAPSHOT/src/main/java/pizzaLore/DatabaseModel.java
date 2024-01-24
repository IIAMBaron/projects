package pizzaLore;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseModel implements Serializable {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=AdvJava;user=Liam;password=1;encrypt=false";
    private Connection conn = null;

    
    public DatabaseModel() {
    }
    
    //Checking if there is a connection if there isn't it creates one
    public Connection getConnection() {
        if (conn == null) {
            createConnection();
        }
        return conn;
    }
    public void createConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url);
            System.out.println("The connection worked");
        } catch(SQLException e) {
            System.out.println("SQL Server error " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Close connection
    public void closeConnection() throws SQLException {
        conn.close();
    }
    
    // Returns the rows of data from a SQL Statement
    public ResultSet resultQuery(String query) {
        try {
            if (conn == null) {
                System.out.println("This is null resultQuery");
            }
            Statement sttmt = conn.createStatement();
            ResultSet result = sttmt.executeQuery(query);
            return result;
        }catch(SQLException e) {
            System.out.println("error");
            return null;
        }
    }
    // Retrieves the admin data that will be used to compare login info
    public String[] adminDetails() {
        String[] admin = new String[2];
        try {
            getConnection();
            if (conn == null) {
                System.out.println("This is null adminDetails");
            }
            ResultSet rs = resultQuery("SELECT * FROM AdminInfo");
            if (rs.next()) {
                // Storing the username and the password into an array
                String username = rs.getString("username");
                admin[0] = username;
                String password = rs.getString("password");
                admin[1] = password;
                System.out.println(Arrays.toString(admin));
            }
           
        } catch(SQLException e) {
            System.out.println("This does not work " + e.getMessage());
            return null;
        }
        return admin;
    }
    
    // This method will be used if you want to insert data into the database
    public int executeUpdate(String table,String query) {
        
        int ID = 0;
        
        try {
            getConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            // After the query is executed it will then looked for the latest ID created by 
            // the identity keyword and we will be returning it
            ResultSet r = resultQuery("SELECT IDENT_CURRENT('"+table+"') AS ID");
            while(r.next()){
                ID = r.getInt("ID");
                System.out.println(ID);
            }return ID;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ID;
    }
    
}
