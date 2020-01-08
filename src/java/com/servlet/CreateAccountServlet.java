/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.account.AccountDAO;
import com.account.AccountRegistrationErrors;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String ERROR_PAGE = "registerAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

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

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String lastname = request.getParameter("txtLastname");

        AccountRegistrationErrors errors = new AccountRegistrationErrors();
        boolean foundErr = false;

        String url = ERROR_PAGE;

        try {
            // check user errors
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                errors.setUsernameLengthError("Username must contain 6 - 20 chars");
                foundErr = true;
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                errors.setPasswordLengthError("Password must contain 6 - 20 chars");
                foundErr = true;
            } else if (!confirm.trim().equals(password.trim())) {
                errors.setConfirmNotMatchError("Confirm does not match password!");
                foundErr = true;
            }
            if (lastname.trim().length() < 2 || lastname.trim().length() > 30) {
                errors.setLastnameLengthError("Last name must contain 2 - 30 chars");
                foundErr = true;
            }

            if (foundErr) {
                request.setAttribute("errors", errors);             
            } else {
                AccountDAO dao = new AccountDAO();
                boolean result = dao.createAccount(username, password, lastname, false);
                if (result) {
                    url = LOGIN_PAGE;
                }
            }

        } catch (SQLException ex) {
            log("CreateAccountServlet _ SQLException " + ex.getMessage());
            if (ex.getMessage().contains("duplicate")) {
                errors.setDuplicatedUsernameError(username + " have already taken!");
                request.setAttribute("errors", errors);
            }
        } catch (NamingException ex) {
          log("CreateAccountServlet _ NamingException " + ex.getMessage());
        } finally {
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
