/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Customer;
import entity.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CustomerFacade;
import session.ItemFacade;


/**
 *
 * @author Melnikov
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/addCustomer",
    "/createCustomer",
    "/editCustomerForm",
    "/editCustomer",
    "/listCustomer",
    "/index",
    "/addItem",
    "/createItem"
})
public class MyServlet extends HttpServlet {
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private ItemFacade itemFacade;
    
    private List<Customer> listCustomer;
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
        request.setCharacterEncoding("UTF-8");
        
        String path = request.getServletPath();
        switch (path) {
            case "/index":
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/addCustomer":
                request.getRequestDispatcher("/WEB-INF/addCustomerForm.jsp").forward(request, response);
                break;
            case "/createCustomer":
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                Customer customer = new Customer(name, surname, phone, email);
                customerFacade.create(customer);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/editCustomerForm":
                listCustomer = customerFacade.findAll();
                request.setAttribute("listCustomer", listCustomer);
                request.getRequestDispatcher("/WEB-INF/editCustomerForm.jsp").forward(request, response);
                break;
            case "/editCustomer":
                String id = request.getParameter("customer");
                name = request.getParameter("name");
                surname = request.getParameter("surname");
                phone = request.getParameter("phone");
                email = request.getParameter("email");
                
                customer = customerFacade.find(Long.parseLong(id));
                customer.setName(name);
                customer.setSurname(surname);
                customer.setPhone(phone);
                customer.setEmail(email);
                customerFacade.edit(customer);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listCustomer":
                List<Customer> listCustomers = customerFacade.findAll();
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher("/WEB-INF/listCustomer.jsp").forward(request, response);
                break;
            case "/addItem":
                request.getRequestDispatcher("/WEB-INF/addItemForm.jsp").forward(request, response);
                break;
            case "/createItem":
                name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                Item item = new Item(name, price, quantity);
                itemFacade.create(item);
                break;
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
