
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.User;
import entity.Item;
import entity.ItemType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.UserFacade;
import session.ItemFacade;
import session.ItemTypeFacade;


/**
 *
 * @author Melnikov
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/index"
})
public class MyServlet extends HttpServlet {
    @EJB
    private UserFacade userFacade;
    @EJB
    private ItemFacade itemFacade;
    @EJB
    private ItemTypeFacade itemTypeFacade;

    
    private List<User> listCustomer;
    private List<Item> listItem;
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
            
            
            case "/listCustomer":
                List<User> listCustomers = userFacade.findAll();
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher("/WEB-INF/listCustomer.jsp").forward(request, response);
                break;
            
            case "/addItemType":
                String name = request.getParameter("name");
                System.out.println("NAME: " +  name);
                ItemType itemType = new ItemType(name);
                System.out.println(itemType.toString());
                itemTypeFacade.create(itemType);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/addItem":
                List<ItemType> listItemTypes = itemTypeFacade.findAll();
                request.setAttribute("listItemTypes", listItemTypes);
                System.out.println(listItemTypes);
                request.getRequestDispatcher("/WEB-INF/addItemForm.jsp").forward(request, response);
                break;
            case "/createItem":
                name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                
                String value = request.getParameter("itemId");;
                itemType = itemTypeFacade.find(Long.parseLong(value)); 
                
                Item item = new Item(name, price, itemType.getId() ,quantity);
                System.out.println(item.toString());
                itemFacade.create(item);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/editItemForm":
                listItem = itemFacade.findAll();
                request.setAttribute("listItem", listItem);
                request.getRequestDispatcher("/WEB-INF/editItemForm.jsp").forward(request, response);
                break;
            case "/choiceItem":
                value = request.getParameter("itemId");
                item = itemFacade.find(Long.parseLong(value));               
                request.setAttribute("listItem", listItem);    
                request.setAttribute("item", item);
                request.getRequestDispatcher("/WEB-INF/editItemForm.jsp").forward(request, response);
                break;
            case "/editItem":
                String id = request.getParameter("itemID");
                name = request.getParameter("name");
                price = Double.parseDouble(request.getParameter("price"));
                quantity = Integer.parseInt(request.getParameter("quantity"));
                
                item = itemFacade.find(Long.parseLong(id)); 
                item.setName(name);
                item.setPrice(price);
                item.setQuantity(quantity);
                itemFacade.edit(item);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listItem":
                listItem = itemFacade.findAll();
                request.setAttribute("listItem", listItem);
                request.getRequestDispatcher("/WEB-INF/listItem.jsp").forward(request, response);
                break;
            case "/addMoneyForm":
                listCustomer = userFacade.findAll();
                request.setAttribute("listCustomer", listCustomer);
                request.getRequestDispatcher("/WEB-INF/addMoneyForm.jsp").forward(request, response);
                break;
            case "/customerChoice":
                value = request.getParameter("customerID");
                User user = userFacade.find(Long.parseLong(value));
                request.setAttribute("listCustomer", listCustomer);
                request.setAttribute("customer", user);
                request.getRequestDispatcher("/WEB-INF/addMoneyForm.jsp").forward(request, response);
            case "/addMoney":
                 id = request.getParameter("customerID");
                Double money = Double.parseDouble(request.getParameter("money"));
                user = userFacade.find(Long.parseLong(id));
                
                user.setMoney(user.getMoney() + money);
                userFacade.edit(user);
                
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            case "/buyItemForm":
                listCustomer = userFacade.findAll();
                listItem = itemFacade.findAll();
                request.setAttribute("listCustomer", listCustomer);
                request.setAttribute("listItem", listItem);
                request.getRequestDispatcher("/WEB-INF/buyItemForm.jsp").forward(request, response);
                break;
            case "/buyItem":
                String customerID = request.getParameter("customerID");
                String itemID = request.getParameter("itemID");
                user = userFacade.find(Long.parseLong(customerID));
                item = itemFacade.find(Long.parseLong(itemID));
                if (user.getMoney() - item.getPrice() > 0){
                    item.setQuantity(item.getQuantity() - 1);
                    user.setMoney(user.getMoney() - item.getPrice());
                    userFacade.edit(user);
                    itemFacade.edit(item);
                    request.setAttribute("info", "Куплент товар: " + item.toString());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    request.setAttribute("info", "Недостаточно денег");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
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
