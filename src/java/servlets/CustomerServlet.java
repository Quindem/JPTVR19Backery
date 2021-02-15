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
        user = userFacade.find(user.getId());
        boolean isRole = userFacade.isRole(3, user);
        if(!isRole){
            request.setAttribute("info", user);
            
            user = userFacade.find(user.getId());
            request.setAttribute("user", user);
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {
            
            case "/addMoneyForm":
                user = (User) session.getAttribute("user");
                user = userFacade.find(user.getId());
                
                request.setAttribute("user", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addMoneyForm")).forward(request, response);
                break;
            case "/addMoney":
                String userID = request.getParameter("userID");
                Double money = Double.parseDouble(request.getParameter("money"));
                user = userFacade.find(Long.parseLong(userID));
                
                user.setMoney(user.getMoney() + money);
                userFacade.edit(user);
                
                user = userFacade.find(user.getId());
                request.setAttribute("user", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
            case "/buyItemForm":  
                String itemID = request.getParameter("itemID");
                Item item = itemFacade.find(Long.parseLong(itemID));
                
                String optionName = "option" + item.getId();
                String conf = request.getParameter(optionName);

                int confIndex = item.getConf().indexOf(conf);
                
                user = (User) session.getAttribute("user");
                
                request.setAttribute("user", user);
                request.setAttribute("item", item);
                request.setAttribute("conf", conf);
                request.setAttribute("confIndex", confIndex);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("buyItemForm")).forward(request, response);
                break;
            case "/buyItem":
                itemID = request.getParameter("itemID");
                confIndex = Integer.parseInt(request.getParameter("confIndex"));
                user = (User) session.getAttribute("user");
                user = userFacade.find(user.getId());
                
                item = itemFacade.find(Long.parseLong(itemID));
                
                if(user.getMoney() - item.getPrice() < 0){
                    System.out.println(user.getMoney() - item.getPrice());
                    request.setAttribute("info", "Недостаточно средств на счёте");
                    
                    user = userFacade.find(user.getId());
                    request.setAttribute("user", user);
                    request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                    break;
                }
                if(item.getQuantity() <= 0){
                    request.setAttribute("info", "Данного предмета нет в наличии");
                    
                    user = userFacade.find(user.getId());
                    request.setAttribute("user", user);
                    request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                    break;
                }
                
                user.setMoney(user.getMoney() - item.getPrice());
                item.setQuantity(item.getQuantity()-1);
                
                userFacade.edit(user);
                itemFacade.edit(item);
                
                request.setAttribute("info", "Товар " + item.getName() + " был куплен");
                
                user = userFacade.find(user.getId());
                request.setAttribute("user", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
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
