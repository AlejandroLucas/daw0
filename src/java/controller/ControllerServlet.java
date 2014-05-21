/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Categoria;
import beans.Producto;
import java.io.IOException;
import java.util.ArrayList;

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
    
    //ArrayList<Categoria> categorias;
    
    public ArrayList<Categoria> categorias;
    
    @Override
    public void init() throws ServletException {
        super.init();
        String prefix = getServletContext().getRealPath("/");
        ///Users/confalonieri/Dropbox/Roberto/stucom/DAW/tools-projects/NetBeansProjects/Practica34/web
        LoggerManager.prefix = prefix;
        
        
        createCategoriasBeans();
        
        getServletContext().setAttribute("categorias",categorias);
        

    }
    
    protected void createCategoriasBeans() {
        
        ArrayList<Producto> productos1;
        ArrayList<Producto> productos2;
        ArrayList<Producto> productos3;
        ArrayList<Producto> productos4;
        
        categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria(1, "Bicicletas", ""));
        categorias.add(new Categoria(2, "Patines", ""));
        categorias.add(new Categoria(3, "Monopatines", ""));
        categorias.add(new Categoria(4, "Accesorios", ""));
        
        productos1 = new ArrayList<Producto>();
        productos1.add(new Producto(1, "Carreras", 300, "bicicleta de carreras amateur", "carreras.jpg", 1));
        productos1.add(new Producto(2, "Paseo", 150, "bicicleta parea pasear", "paseo.jpg", 1));
        productos1.add(new Producto(3, "Mountain", 600, "bicicleta todoterreno para deporte extremo", "mountain.jpg", 1));
        productos1.add(new Producto(4, "BMX", 360, "bicicleta para cross", "BMX.jpg", 1));
        categorias.get(0).setProductoList(productos1);

        productos2 = new ArrayList<Producto>();
        productos2.add(new Producto(5, "Línea", 150, "patinaje deportivo", "linea.jpg", 2));
        productos2.add(new Producto(6, "Hielo", 300, "para patinaje sobre hielo", "hielo.jpg", 2));
        productos2.add(new Producto(7, "Paralelo", 80, "4 ruedas paralelas", "paralelo.jpg", 2));
        productos2.add(new Producto(8, "Infantil", 40, "para niños", "infantil.jpg", 2));
        categorias.get(1).setProductoList(productos2);

        productos3 = new ArrayList<Producto>();
        productos3.add(new Producto(9, "Monopatín", 80, "monopatín clásico", "monopatin.jpg", 3));
        productos3.add(new Producto(10, "Patinete", 70, "para desplazamiento urbano", "patinete.jpg", 3));
        productos3.add(new Producto(11, "LongBoard", 125, "grandes dimensiones", "longboard.jpg", 3));
        productos3.add(new Producto(12, "Articulados", 400, "articulado ligero", "articulado.jpg", 3));
        categorias.get(2).setProductoList(productos3);
        
        productos4 = new ArrayList<Producto>();
        productos4.add(new Producto(13, "Casco", 15, "Obligatorio legalmente", "casco.jpg", 4));
        productos4.add(new Producto(14, "Guantes", 20, "Para las manos", "guantes.jpg", 4));
        productos4.add(new Producto(15, "Rueda", 15, "repuestos de colores", "rueda.jpg", 4));
        productos4.add(new Producto(16, "Protecciones", 40, "rodilleras y coderas", "protecciones.jpg", 4));
        categorias.get(3).setProductoList(productos4);
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
