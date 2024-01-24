package com.mycompany.clientpizza;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import pizzalore.DatabaseWebService_Service;

/**
 *
 * @author EDUV4813733
 */ 
@MultipartConfig
@WebServlet(name = "addProducts", urlPatterns = {"/admin/add"})
public class addProducts extends HttpServlet {
    String prodName;
    String prodDesc;
    double prodPrice;
    int prodType;
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PizzaStore/DatabaseWebService.wsdl")
    private DatabaseWebService_Service service;

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
        // We are getting the path of the images folder so that we can move images uploaded into this folder
        String absoluteFilePath = getServletContext().getRealPath("resources\\images");

        // Next we are retrieving the file name of the uploaded image
        Part fileName = request.getPart("image");
        String imageLoc = "resources\\images\\" + fileName.getSubmittedFileName();
        
        // Moving uploaded file to the designated folder in this case it is the images folder
        try (OutputStream output = new FileOutputStream(new File(absoluteFilePath+ "\\"+ fileName.getSubmittedFileName()))) {
            InputStream input = fileName.getInputStream();
            int read;
                    final byte[] bytes = new byte[1024];
                    while ((read = input.read(bytes)) != -1) {
                        output.write(bytes, 0, read);
                    }
            // We are calling the web service method and inserting the values instantiated into it
            pizzalore.DatabaseWebService port = service.getDatabaseWebServicePort();
            String table = "ProductInfo";
            String name = prodName;
            double price = prodPrice;
            int type = prodType;
            String desc = prodDesc;
            
            // The web service method will add all the items into the database into the appropriate tables
            port.addProduct(table, name, price, desc, imageLoc, type);
            
            try (PrintWriter out = response.getWriter()) {
            
            out.println("<a href=\"/ClientPizza/\">See changes</a><br>");
            out.println("<a href=\"/ClientPizza/admin/panel\">Back to Admin Panel</a>");
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
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
        prodName = request.getParameter("name");
        prodDesc = request.getParameter("desc");
        prodPrice = Double.parseDouble(request.getParameter("price"));
        prodType = Integer.parseInt(request.getParameter("type"));
        
        RequestDispatcher rd = request.getRequestDispatcher("/adminImage.jsp");
        rd.forward(request, response);
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
