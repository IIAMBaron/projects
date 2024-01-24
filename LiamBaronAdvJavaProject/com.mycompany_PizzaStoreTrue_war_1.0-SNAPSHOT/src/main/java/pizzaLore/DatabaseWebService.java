package pizzaLore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author EDUV4813733
 */
@WebService(serviceName = "DatabaseWebService")
public class DatabaseWebService {
    DatabaseModel x = new DatabaseModel();
    private String adminUsername;
    private String adminPassword;
    private ResultSet rs;

    /**
     * Web service operation
     * @param username
     * @param password
     * @return 
     */
    
    // This method will return the result of whether the login info inserted was correct or not
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        try {
            x.createConnection();
        String[] admin = x.adminDetails();
        // We are storing the details from the database
        adminUsername = admin[0];
        adminPassword = admin[1];
        
        // This is where the check happens to see if the credentials are correct
        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            System.out.println("It worked in the login Web Service");
            return "True";
        }
        else {
            System.out.println("It did not work in the login Web Service");
            return "False";
        }
        }catch(Exception e) {
            System.out.println("Error " + e.getMessage());
        }
       
        return null;
    }

    /**
     * Web service operation
     * @return 
     */
    // This method just returns an ArrayList of type String with all the categories available
    @WebMethod(operationName = "prodTypes")
    public ArrayList<String> prodTypes() {
        ArrayList<String> arrList= new ArrayList<>();
        try {
            x.getConnection();
            // We are executing a SQL Statement
            ResultSet rs = x.resultQuery("SELECT * FROM ProductCategory ");
            // We are then going through the rows of data retrieved until there is no more rows
            while (rs.next()) {
                // Adding a specific instance from a specific column
                arrList.add(rs.getString("name"));
            }
            return arrList;
        }catch(Exception e) {
            System.out.println("This prodTypes does not work" + e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param prodType
     * @return 
     */
    // We are kind of returning a 2D ArrayList of type String it is just the string is also an arraylist
    @WebMethod(operationName = "homePage")
    public ArrayList<String> homePage(@WebParam(name = "prodType") String prodType) {
        ArrayList<String> products = new ArrayList<String>();
        try {
            // We are checking what the filter is set on and then calling those items for that
            // specifc category
            if (prodType.equals("1") || prodType.equals("2")) {

                    x.getConnection();
                    rs = x.resultQuery("SELECT * FROM ProductInfo WHERE prodType = " + prodType );
            // This to catch if no option was select so when the page is first launched
            }else {
                    x.getConnection();
                    rs = x.resultQuery("SELECT * FROM ProductInfo");
            }
                while (rs.next()) {
                        List product = new ArrayList<Object>();
                        product.add(rs.getInt("productID"));
                        product.add(rs.getString("name"));
                        product.add(rs.getFloat("price"));
                        product.add(rs.getString("prodDesc"));
                        product.add(rs.getString("imageLocation"));
                        product.add(rs.getString("prodType"));
                        // we convert then inner array to a string as we can't return 2D arrays
                        // we will eventually convert this later on in the program
                        products.add(product.toString());   
                }
                return products;       
        }catch (SQLException e) {
            System.out.println("This does not work " + e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param table
     * @param streetNum
     * @param streetName
     * @param city
     * @param suburb
     * @return 
     */
    // We are individually updating each table with a method
    // In this instance we are updating the address table and returning the latest ID that was assigned
    @WebMethod(operationName = "address")
    public int address(@WebParam(name = "table") String table, @WebParam(name = "streetNum") String streetNum, @WebParam(name = "streetName") String streetName, @WebParam(name = "suburb") String suburb, @WebParam(name = "city") String city) {
        x.getConnection();
        System.out.println("("+streetNum+","+"'" + streetName+"'" +"," +"'"+suburb+"'"+","+"'"+city+"'"+")");
        int addID = x.executeUpdate(table,"INSERT INTO AddressInfo VALUES ("+streetNum+","+"'" + streetName+"'" +"," +"'"+suburb+"'"+","+"'"+city+"'"+")");
        // make it so that it returns the ID of the address as well.
        if (addID> 0) {
            
            return addID;
        }else {
            return 0;
        }
        
    }

    /**
     * Web service operation
     * @param table
     * @param orderDate
     * @param mode
     * @param pay
     * @param addressID
     * @return 
     */
    // We are updating the orderInfo table this time around
    @WebMethod(operationName = "orderInfo")
    public int orderInfo(@WebParam(name = "table") String table, @WebParam(name = "orderDate") String orderDate, @WebParam(name = "mode") String mode, @WebParam(name = "pay") int pay, @WebParam(name = "addressID") int addressID) {
        x.getConnection();
        int orderID = x.executeUpdate(table,"INSERT INTO orderInfo VALUES (" + "'" + orderDate + "'" + "," + "'" + mode + "'" + "," + pay + "," + addressID+")");
        if (orderID> 0) {
            return orderID;
        }
        return 0;
    }

    /**
     * Web service operation
     * @param orderID
     * @param hashID
     * @param hashProdQuantity
     * @return 
     */
    // We are updating the orderDetails table
    @WebMethod(operationName = "orderDetails")
    public String orderDetails(@WebParam(name = "orderID") int orderID, @WebParam(name = "hashID") Object hashID, @WebParam(name = "hashProdQuantity") Object hashProdQuantity) {
        x.getConnection();
        int orderNum = x.executeUpdate("orderDetails", "INSERT INTO orderDetails VALUES (" + hashProdQuantity.toString() + "," + hashID.toString() + "," + orderID + ")");
        if (orderNum > 0) {
            return "Successful " + orderNum;
        }
        return "Failed";
    }

    /*
     * Web service operation
     */
    // Similar to the homepage method this one is returning a 2d ArrayList but the difference is the sql statement that is being executed
    @WebMethod(operationName = "products")
    public ArrayList<String> products() {
        ArrayList<String> products = new ArrayList<>();
        x.getConnection();
        ResultSet rs = x.resultQuery("SELECT ProductID ,ProductInfo.name, price, prodDesc, imageLocation, ProductCategory.name AS type " +
                            "FROM ProductInfo, ProductCategory " +
                            "WHERE ProductInfo.prodType = ProductCategory.prodType");
        
        try {
            while (rs.next()) {
                ArrayList<Object> product = new ArrayList<>();
                product.add(rs.getInt("ProductID"));
                product.add(rs.getString("name"));
                product.add(rs.getFloat("price"));
                product.add(rs.getString("ProdDesc"));
                product.add(rs.getString("imageLocation"));
                product.add(rs.getString("type"));
                products.add(product.toString());
            }
        return products;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // Getting information about the sales again another 2d ArrayList
    @WebMethod(operationName = "sales")
    public ArrayList<String> sales() {
        ArrayList<String> products = new ArrayList<>();
        x.getConnection();
        ResultSet rs = x.resultQuery("SELECT name, SUM(quantity) AS quantity, SUM(quantity * price) AS total " +
                                    "FROM OrderDetails ,ProductInfo " +
                                    "WHERE ProductInfo.productID = OrderDetails.productID " +
                                    "GROUP BY name");
        
        try {
            while (rs.next()) {
                ArrayList<Object> product = new ArrayList<>();
                product.add(rs.getString("name"));
                product.add(rs.getInt("quantity"));
                product.add(rs.getFloat("total"));
                products.add(product.toString());
            }
        return products;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     * @param table
     * @param name
     * @param price
     * @param desc
     * @param type
     * @param imageLoc
     * @return 
     */
    // We are inserting data to the productInfo table
    @WebMethod(operationName = "addProduct")
    public String addProduct(@WebParam(name = "table") String table, @WebParam(name = "name") String name, @WebParam(name = "price") double price, @WebParam(name= "desc") String desc, @WebParam(name = "imageLoc") String imageLoc, @WebParam(name = "type") int type) {
        x.getConnection();
        String name1 = "INSERT INTO productInfo VALUES ( '" +name+ "'" + "," + price +"," + "'" + desc + "'" + "," +  "'" + imageLoc +  "'" + "," + type + ")";
        x.executeUpdate(table, name1);
        return null;
    }
}

    


    
