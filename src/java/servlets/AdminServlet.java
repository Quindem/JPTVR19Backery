/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.History;
import entity.ItemType;
import entity.Role;
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
import session.HistoryFacade;
import session.ItemTypeFacade;
import session.RoleFacade;
import session.UserFacade;

/**
 *
 * @author jvm
 */
@WebServlet(name = "AdminServlet", urlPatterns = {
    "/listUser",
    "/addItemTypeForm",
    "/addItemType",
    "/editUserForm",
    "/editUser",
    "/showUserHistory"
})  
public class AdminServlet extends HttpServlet {
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private ItemTypeFacade itemTypeFacade;
    @EJB
    private HistoryFacade historyFacade;
    
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
        boolean isRole = userFacade.isRole(1, user);
        if(!isRole){
            request.setAttribute("info", "У вас нет права использовать этот ресурс!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {
            
            case "/listUser":
                List<User> listUser = userFacade.findAll();
                List<Role> listRole = roleFacade.findAll();
                request.setAttribute("listUser", listUser);
                request.setAttribute("listRole", listRole);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("listUser")).forward(request, response);
                break;
                
            case "/addItemTypeForm": 
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addItemTypeForm")).forward(request, response);
                break;
                
            case "/addItemType":
                String name = request.getParameter("name");
                System.out.println("NAME: " +  name);
                ItemType itemType = new ItemType(name);
                System.out.println(itemType.toString());
                itemTypeFacade.create(itemType);
                
                user = userFacade.find(user.getId());
                request.setAttribute("user", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;
                
            case "/editUserForm":
                String id = request.getParameter("userID");
                System.out.println(id);
                user = userFacade.find(Long.parseLong(id));
                System.out.println(user);
                
                listRole = roleFacade.findAll();
                request.setAttribute("listRole", listRole);
                request.setAttribute("user", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("editUserForm")).forward(request, response);
                break;
                
            case "/editUser":               
                id = request.getParameter("userID");
                name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String roleID = request.getParameter("role");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String money = request.getParameter("money");
                
                user = userFacade.find(Long.parseLong(id));
                user.setName(name);
                user.setSurname(surname);
                user.setRoleID(roleFacade.find(Long.parseLong(roleID)).getId());
                user.setPhone(phone);
                user.setEmail(email);
                user.setMoney(Double.parseDouble(money));
                userFacade.edit(user);
                
                user = userFacade.find(user.getId());
                request.setAttribute("user", user);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;
                
            case "/showUserHistory":
                List<History> listHistoryMB = historyFacade.findAll();
                id = request.getParameter("userID");
                
                ArrayList<History> listHistory = new ArrayList<History>();
                for (History history : listHistoryMB){
                    if(history.getUser().getId() == Long.parseLong(id)){
                        listHistory.add(history);
                    }
                }
                System.out.println(listHistory);
                
                request.setAttribute("listHistory", listHistory);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("showUserHistory")).forward(request, response);
                break;
                
            /*
            case "/adminForm":
                request.setAttribute("activeAdminPanel", "true");
                List<Role> listRoles = roleFacade.findAll();
                request.setAttribute("listRoles", listRoles);
                Map<User,String> usersMap = new HashMap<>();
                List<User> listUsers = userFacade.findAll();
                for(User u : listUsers){
                    usersMap.put(u, userRolesFacade.getTopRoleForUser(u));
                }
                request.setAttribute("usersMap", usersMap);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("adminPanel")).forward(request, response);
                break;
            case "/setRole":
                String userId = request.getParameter("userId");
                String roleId = request.getParameter("roleId");
                if("".equals(userId) || userId == null
                        || "".equals(roleId) || roleId == null){
                    request.setAttribute("userId", userId);
                    request.setAttribute("roleId", roleId);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/adminForm").forward(request, response);
                    break;
                }
                user = userFacade.find(Long.parseLong(userId));
                Role role = roleFacade.find(Long.parseLong(roleId));
                UserRoles userRoles = new UserRoles(user, role);
                if(!"admin".equals(user.getLogin())){
                    userRolesFacade.setNewRole(userRoles);
                    request.setAttribute("info", "Роль изменена");
                }else{
                    request.setAttribute("userId", userId);
                    request.setAttribute("roleId", roleId);
                    request.setAttribute("info", "Изменить роль невозможно");
                }
                request.getRequestDispatcher("/adminForm").forward(request, response);
                break;
                */
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
