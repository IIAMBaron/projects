package com.mycompany.clientpizza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EDUV4813733
 */
@WebServlet(urlPatterns = {"/shoppingcart"})
public class shoppingCartServlet extends HttpServlet {
    productHash x = new productHash();
    static ArrayList<Object> food = new ArrayList<>();
    static ArrayList<Object> foodNames = new ArrayList<>();
    static ArrayList<Object> foodPrices = new ArrayList<>();
    Map<String, Integer> quantityOfProducts = new HashMap<>();
    Map<Integer, String> productIDs = new HashMap<>();
  
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
            HttpSession session =  request.getSession();
            
            // Checks if the productHash bean instance has an empty array meaning there is no items in the shopping cart
            if (x.getProductQuantity().isEmpty()) {
                RequestDispatcher forward = request.getRequestDispatcher("/emptyCart.jsp");
                forward.forward(request, response);
                return;
            }
            
            Object name = session.getAttribute("prodName1");
            Object price = session.getAttribute("prodPrice1");
            
            if (session.getAttribute("quantity").toString().equals("[]")) {
            RequestDispatcher rd = request.getRequestDispatcher("/emptyCart.jsp");
            rd.forward(request, response);
            }

            /*
            This is why we got the name and the price attributes its to see if the user didn't jump from a page that
            doesn't have the correct values
            */
            if (name == null || price == null) {
                RequestDispatcher forward = request.getRequestDispatcher("/emptyCart.jsp");
                forward.forward(request, response);
            }
            else {
                
                RequestDispatcher forward = request.getRequestDispatcher("/viewCart.jsp");
                forward.forward(request, response);
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
        
        // We are adding the quantity amount of the selected item to a map
        food.add(request.getParameter("quantity"));
        
        HttpSession session =  request.getSession();
        
        
        String prodName = session.getAttribute("prodName1").toString();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int id = Integer.parseInt(session.getAttribute("prodID1").toString());

        // This is checking if there is already a product of that name in the shopping cart
        // So what I am trying to do is stack products that are the same
        if (!quantityOfProducts.containsKey(prodName)) {
            x.putIDs(id, prodName);
            x.putProdQuantity(prodName, quantity);
            quantityOfProducts.put(prodName,quantity );
            productIDs.put(id, prodName);
            
        }
        else {
            int y = quantityOfProducts.get(prodName) + quantity;
            x.plusProdQuantity(prodName, quantity);
            quantityOfProducts.put(prodName, quantityOfProducts.get(prodName)+quantity );
        }
        
        // We are then going to add those items as a session so that it can be used somewhere else
        foodNames.add(session.getAttribute("prodName1"));
        foodPrices.add(session.getAttribute("prodPrice1"));
        session.setAttribute("prodName", foodNames);
        session.setAttribute("prodPrice", foodPrices);
        session.setAttribute("quantity", food);
        session.setAttribute("quantityOfProducts", quantityOfProducts);
        session.setAttribute("productIDs", productIDs);
        
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
