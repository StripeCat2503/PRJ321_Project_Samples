
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class DispatchController extends HttpServlet {

    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGIN_PAGE = "login.html";
    private final String SEARCH_SERVLET = "SearchServlet";
    private final String DELETE_ACCOUNT_SERVLET = "DeleteAccountServlet";
    private final String UPDATE_ACCOUNT_SERVLET = "UpdateAccountServlet";
    private final String STARTUP_SERVLET = "StartupServlet";
    private final String ADD_BOOK_TO_CART_SERVLET = "AddBookToCartServlet";
    private final String VIEW_CART_PAGE = "viewcart.jsp";
    private final String LOG_OUT_SERVLET = "LogoutServlet";
    private final String REMOVE_CART_ITEM_SERVLET = "RemoveCartItemServlet";
    private final String CREATE_ACCOUNT_SERVLET = "CreateAccountServlet";
    
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
        PrintWriter out = response.getWriter();
        
        String button = request.getParameter("btnAction");
        String url = "";
        
        try{
            if(button == null){
                url = STARTUP_SERVLET;
            }         
            else if(button.equals("Login")){
                url = LOGIN_SERVLET;
            }
            else if(button.equals("Search")){
                url = SEARCH_SERVLET;
            }
            else if(button.equals("Delete")){
                url = DELETE_ACCOUNT_SERVLET;
            }
            else if(button.equals("Update")){
                url = UPDATE_ACCOUNT_SERVLET;
            }
            else if(button.equals("Add book to cart")){
                url = ADD_BOOK_TO_CART_SERVLET;
            }
            else if(button.equals("View cart")){
                url = VIEW_CART_PAGE;
            }
            else if(button.equals("Logout")){
                url = LOG_OUT_SERVLET;
            }
            else if(button.equals("Remove seleted books")){
                url = REMOVE_CART_ITEM_SERVLET;
            }
            else if(button.equals("Create new account")){
                url = CREATE_ACCOUNT_SERVLET;
            }
            
        }
        finally{          
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
