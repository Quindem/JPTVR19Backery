/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Item;
import entity.ItemType;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ItemFacade;
import session.ItemTypeFacade;
import session.RoleFacade;
import session.UserFacade;

/**
 *
 * @author jvm
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {
    "/addMoneyForm",
    "/customerChoice",
    "/addMoney",
    "/buyItemForm",
    "/buyItem"
})  
public class CustomerServlet extends HttpServlet {
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private ItemTypeFacade itemTypeFacade;
    @EJB
    private ItemFacade itemFacade;
    
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
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        boolean isRole = userFacade.isRole(3, user);
        if(!isRole){
            request.setAttribute("info", user);
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {
            
            case "/addMoneyForm":
                List<User> listUser = userFacade.findAll();
                request.setAttribute("listCustomer", listUser);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addMoneyForm")).forward(request, response);
                break;
            case "/customerChoice":
                String value = request.getParameter("customerID");
                user = userFacade.find(Long.parseLong(value));
                listUser = userFacade.findAll();
                request.setAttribute("listCustomer", listUser);
                request.setAttribute("customer", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addMoneyForm")).forward(request, response);
            case "/addMoney":
                String id = request.getParameter("customerID");
                Double money = Double.parseDouble(request.getParameter("money"));
                user = userFacade.find(Long.parseLong(id));
                
                user.setMoney(user.getMoney() + money);
                userFacade.edit(user);
                
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
            case "/buyItemForm":
                listUser = userFacade.findAll();
                List<Item> listItem = itemFacade.findAll();
                request.setAttribute("listCustomer", listUser);
                request.setAttribute("listItem", listItem);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("buyItemForm")).forward(request, response);
                break;
            case "/buyItem":
                String customerID = request.getParameter("customerID");
                String itemID = request.getParameter("itemID");
                user = userFacade.find(Long.parseLong(customerID));
                Item item = itemFacade.find(Long.parseLong(itemID));
                if (user.getMoney() - item.getPrice() > 0 && item.getQuantity() > 0){
                    item.setQuantity(item.getQuantity() - 1);
                    user.setMoney(user.getMoney() - item.getPrice());
                    userFacade.edit(user);
                    itemFacade.edit(item);
                    request.setAttribute("info", "Куплент товар: " + item.toString());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    request.setAttribute("info", "Недостаточно денег");
                    request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                }
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
