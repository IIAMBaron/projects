package com.mycompany.clientpizza;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.time.LocalDate;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import pizzalore.DatabaseWebService_Service;

/**
 *
 * @author EDUV4813733
 */
@WebServlet(name = "checkOutServlet", urlPatterns = {"/checkout"})
public class checkOutServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PizzaStore/DatabaseWebService.wsdl")
    private DatabaseWebService_Service service;
    
    conversion con = new conversion();
    int orderID = 0;
    int quantity = 0;
    LocalDate orderDate;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try { 
            // Retrieving which mode the customer has selected
            String mode = request.getParameter("checkout");
            pizzalore.DatabaseWebService port = service.getDatabaseWebServicePort();
            
            // Checking if the mode selected is delivery
            if (mode.equals("delivery")) {
                // Getting all the attributes that was established from the input the user gave for delivery mode
                String streetNum = request.getParameter("streetNum");
                String streetName = request.getParameter("suburb");
                String suburb = request.getParameter("streetName");
                String city = request.getParameter("city");
                
                // insertion of variables into the web service method that will add these details into the system
                int addID = port.address("AddressInfo", streetNum, streetName, suburb, city);

                orderDate = LocalDate.now(); 
                
                int pay = 1000;
                int addressID = addID;
                orderID = port.orderInfo("orderInfo", orderDate.toString(), mode, pay, addressID);

            } else if (mode.equals("collection")) {
                orderDate = LocalDate.now(); 
                int pay = 0;
                int addressID = 1;
                orderID = port.orderInfo("orderInfo", orderDate.toString(), mode, pay, addressID);
            }
            // Getting the location of the log folder within the application
            String absoluteFilePath = getServletContext().getRealPath("resources/log");
            FileWriter fw = new FileWriter(absoluteFilePath+"/orders.txt", true);
            
            // Getting the information from the productHashBean of the items quantity and IDs in the shopping cart
            Map<String,Integer> productQuantity =productHash.productQuantity;
            Map<Integer, String> productIDs = productHash.productIDs;

            // doing a loop through all the available IDs in the shopping cart
            for (int id : productIDs.keySet()) {
                    // We are obtaining the value of the id and writing it to a text file called orders.txt
                    quantity = productQuantity.get(productIDs.get(id));
                    fw.write(orderID +", "+  orderDate.toString() + ", "+ id + ", "+ quantity + ", "+ mode);
                    fw.write(System.lineSeparator());
                    
                    // Inserting the data collected into a web service method that will add the information into a table
                    String result = port.orderDetails(orderID, id, quantity);
                    out.println("Result OrderDetails = "+result);

            }
            fw.close();
            
            session.setAttribute("orderID", orderID);
            
            session.setAttribute("clear", true);
            shoppingCartServlet.food.clear();
            shoppingCartServlet.foodNames.clear();
            shoppingCartServlet.foodPrices.clear();
            
            RequestDispatcher forward = request.getRequestDispatcher("/checkOut.jsp");
            forward.forward(request, response);
            
            
        } catch (IOException | ServletException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
