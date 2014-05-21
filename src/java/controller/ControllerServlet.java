/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.LoggerManager;

/**
 *
 * @author Administrador
 */
public class ControllerServlet extends HttpServlet {

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
    public void init() throws ServletException {
        super.init();
        String prefix = getServletContext().getRealPath("/");
        ///Users/confalonieri/Dropbox/Roberto/stucom/DAW/tools-projects/NetBeansProjects/Practica34/web
        LoggerManager.prefix = prefix;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        if ("/category".equals(userPath)) {
            userPath = "/category";
        } else if ("/viewCart".equals(userPath)) {
            userPath = "/cart";
        } else if ("/checkout".equals(userPath)) {
            userPath = "/checkout";
        }else if ("/cleanCart".equals(userPath)) {
            userPath = "/cart";
        }else{
            userPath = "../error";
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";
        request.setAttribute("view", url);
        request.getRequestDispatcher(url).forward(request, response);
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
        
        String userPath = request.getServletPath();
        
         if ("/addToCart".equals(userPath)) {
            userPath = "/category";
        } else if ("/updateCart".equals(userPath)) {
            userPath = "/cart";
        } else if ("/purchase".equals(userPath)) {
            userPath = "/confirmation";
        }else{
            userPath = "../error";
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";
        request.setAttribute("view", url);
        request.getRequestDispatcher(url).forward(request, response);
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
