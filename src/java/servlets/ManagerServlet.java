/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Cover;
import entity.Item;
import entity.ItemType;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import session.CoverFacade;
import session.ItemFacade;
import session.ItemTypeFacade;
import session.RoleFacade;
import session.UserFacade;

/**
 *
 * @author jvm
 */
@WebServlet(name = "ManagerServlet", urlPatterns = {
    "/addItem",
    "/createItem",
    "/editItemList",
    "/editItemForm",
    "/editItem"
})  
@MultipartConfig
public class ManagerServlet extends HttpServlet {
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private ItemTypeFacade itemTypeFacade;
    @EJB
    private ItemFacade itemFacade;
    @EJB
    private CoverFacade coverFacade;
    
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
        boolean isRole = userFacade.isRole(2, user);
        if(!isRole){
            request.setAttribute("info", user);
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {
            
            case "/addItem":
                List<ItemType> listItemTypes = itemTypeFacade.findAll();
                request.setAttribute("listItemTypes", listItemTypes);
                System.out.println(listItemTypes);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addItemForm")).forward(request, response);
                break;
                
            case "/createItem":
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                
                String uploadFolder = "\\UploadJPTVR19Clothes";
                List<Part> fileParts = request
                        .getParts()
                        .stream()
                        .filter(part -> "file".equals(part.getName()))
                        .collect(Collectors.toList());
                StringBuilder sb = new StringBuilder();
                for(Part filePart : fileParts){
                   sb.append(uploadFolder+File.separator + getFileName(filePart));
                   File file = new File(sb.toString());
                   file.mkdirs();
                   try(InputStream fileContent = filePart.getInputStream()){
                       Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                   }
                }
                String description = request.getParameter("description");
                Cover cover = new Cover(description,sb.toString());
                coverFacade.create(cover);
                request.setAttribute("info", "Файл загружен");
                request.getRequestDispatcher("/addBook").forward(request, response);
                
                ArrayList<String> confList = new ArrayList<String>();
                for (int i = 0; i < 8; i++){
                    String confName = "conf" + (i+1);
                    String conf = request.getParameter(confName);
                    System.out.println(conf);
                    if (conf != ""){
                        confList.add(conf);
                    }                
                }
                confList.removeAll(Arrays.asList(null,""));
                System.out.println(confList);
                
                String value = request.getParameter("itemId");
                
                Item item = new Item(name, price, quantity);
                item.setConf(confList);
                item.setCover(cover);
                System.out.println(item.toString());
                itemFacade.create(item);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;
                
            case "/editItemList":
                List<Item> listItem = itemFacade.findAll();
                request.setAttribute("listItem", listItem);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("editItemList")).forward(request, response);
                break;
            case "/editItemForm":
                String itemID = request.getParameter("itemID");
                item = itemFacade.find(Long.parseLong(itemID));
                
                request.setAttribute("item", item);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("editItemForm")).forward(request, response);
                break;
            case "/editItem":
                name = request.getParameter("name");
                price = Double.parseDouble(request.getParameter("price"));
                quantity = Integer.parseInt(request.getParameter("quantity"));
                itemID = request.getParameter("itemID");
                
                confList = new ArrayList<String>();
                for (int i = 0; i < 8; i++){
                    String confName = "conf" + (i+1);
                    String conf = request.getParameter(confName);
                    System.out.println(conf);
                    if (conf != ""){
                        confList.add(conf);
                    }                
                }
                
                confList.removeAll(Arrays.asList(null,""));
                System.out.println(confList);
                
                System.out.println("itemID: " + itemID);
                item = itemFacade.find(Long.parseLong(itemID)); 
                item.setName(name);
                item.setPrice(price);
                item.setQuantity(quantity);
                item.setConf(confList);
                itemFacade.edit(item);

                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;
        }

    }
    
    private String getFileName(Part part){
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
                return content
                        .substring(content.indexOf('=')+1)
                        .trim()
                        .replace("\"",""); 
            }
        }
        return null;
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
