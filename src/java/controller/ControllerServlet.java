/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Categoria;
import beans.Cliente;
import beans.OrdenCliente;
import beans.Producto;
import carrito.CarritoCompra;
import java.io.IOException;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.DatabaseManager;
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
    private Categoria categoriaTmp = null;

    @Override
    public void init() throws ServletException {
        super.init();
        String prefix = getServletContext().getRealPath("/");
        ///Users/confalonieri/Dropbox/Roberto/stucom/DAW/tools-projects/NetBeansProjects/Practica34/web
        LoggerManager.prefix = prefix;

        DatabaseManager.openConnection();

        createCategoriasBeans();

        DatabaseManager.closeConnection();

        getServletContext().setAttribute("categorias", categorias);

    }

    private ArrayList<Producto> crearProducto(String id) {

        ArrayList<Producto> productos = new ArrayList<Producto>();

        String productoSql = "SELECT * FROM producto WHERE idCategoria=" + id;

        //declaro los objetos Java para la query
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            //ejecutar query
            preparedStatement = DatabaseManager.conn.prepareStatement(productoSql);
            resultSet = preparedStatement.executeQuery();
            //processar query
            while (resultSet.next()) {
                int idProducto = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String imagen = resultSet.getString("imagen");
                String descripcion = resultSet.getString("descripcion");
                double precio = resultSet.getDouble("precio");

                Producto producto = new Producto(idProducto, nombre, precio, descripcion, imagen);
                LoggerManager.getLog().info("mete un producto en una categoria");
                productos.add(producto);
            }
            LoggerManager.getLog().info(categorias.size());

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {

            categorias = null;
            LoggerManager.getLog().error(ex.toString());
        } finally {
            return (productos);
        }

    }

    private Producto getProductoById(String id) {

        String productoSql = "SELECT * FROM producto WHERE id=" + id;

        //declaro los objetos Java para la query
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Producto producto = null;

        try {
            //ejecutar query
            preparedStatement = DatabaseManager.conn.prepareStatement(productoSql);
            resultSet = preparedStatement.executeQuery();
            //processar query
            while (resultSet.next()) {
                int idProducto = resultSet.getInt("id");
                String nombre = resultSet.getString("Nombre");
                String imagen = resultSet.getString("Imagen");
                String descripcion = resultSet.getString("Descripcion");
                double precio = resultSet.getDouble("Precio");

                producto = new Producto(idProducto, nombre, precio, descripcion, imagen);
                LoggerManager.getLog().info("mete un producto en una categoria");
            }
            //LoggerManager.getLog().info(producto.getId());

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            categorias = null;
            LoggerManager.getLog().error(ex.toString());
        } finally {
            LoggerManager.getLog().info("devuelve un producto del carrito" + producto.getId());
            return (producto);
        }

    }

    protected void createCategoriasBeans() {

        //  ArrayList<Producto> productos1;
        ///  ArrayList<Producto> productos2;
        //  ArrayList<Producto> productos3;
        //  ArrayList<Producto> productos4;
        categorias = new ArrayList<Categoria>();

        String categoriaSql = "SELECT * FROM categoria";

        //declaro los objetos Java para la query
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            //ejecutar query
            preparedStatement = DatabaseManager.conn.prepareStatement(categoriaSql);
            resultSet = preparedStatement.executeQuery();
            //processar query
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String imagen = resultSet.getString("imagen");
                Categoria categoria = new Categoria(id, nombre, imagen);

                LoggerManager.getLog().info("mete una categoria");
                categorias.add(categoria);
            }
            LoggerManager.getLog().info(categorias.size());

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {

            categorias = null;
            LoggerManager.getLog().error(ex.toString());
        }

        /* categorias.add(new Categoria(1, "Bicicletas", "carreras.jpg"));
         categorias.add(new Categoria(2, "Patines", "linea.jpg"));
         categorias.add(new Categoria(3, "Monopatines", "monopatin.jpg"));
         categorias.add(new Categoria(4, "Accesorios", "guantes.jpg"));

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
         productos4.add(new Producto(15, "Rueda", 15, "repuestos de colores", "rueda.JPG", 4));
         productos4.add(new Producto(16, "Protecciones", 40, "rodilleras y coderas", "protecciones.jpg", 4));
         categorias.get(3).setProductoList(productos4);*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManager.openConnection();
        String userPath = request.getServletPath();

        if (userPath.equals("/category")) {

            categoriaTmp = null;
            String categoriaId = request.getParameter("categoryId");
            if (categoriaId != null && !categoriaId.equals("")) {
                categoriaTmp = getCategoriaPorId(categoriaId);
                request.getSession().setAttribute("categoriaSeleccionada", categoriaTmp);
                request.getSession().setAttribute("listaProductos", crearProducto(categoriaId));
            } else {
                userPath = "/../../index";
            }

            //userPath = "/category";
        } else if (userPath.equals("/viewCart")) {
            userPath = "/cart";
        } else if (userPath.equals("/checkout")) {
            CarritoCompra car = (CarritoCompra) request.getSession().getAttribute("carritoCompra");
            car.calculaTotal(10);
            request.getSession().setAttribute("carritoCompra", car);
            userPath = "/checkout";
            String categoriaId = request.getParameter("categoryId");
        } else if (userPath.equals("/cleanCart")) {
            CarritoCompra car = (CarritoCompra) request.getSession().getAttribute("carritoCompra");
            car.limpia();
            request.getSession().setAttribute("carritoCompra", car);
            userPath = "/cart";
        } else {
            userPath = "../error";
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";
        request.setAttribute("view", url);
        request.getRequestDispatcher(url).forward(request, response);
        DatabaseManager.closeConnection();

    }

    public Categoria getCategoriaPorId(String categoriaId) {
        int idTmp = Integer.parseInt(categoriaId);

        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId() == idTmp) {
                categoriaTmp = categorias.get(i);
                return (categoriaTmp);
            }
        }
        return null;
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
        DatabaseManager.openConnection();

        HttpSession httpSession = request.getSession();
        CarritoCompra carritoCompra = (CarritoCompra) httpSession.getAttribute("carritoCompra");

        String userPath = request.getServletPath();

        if ("/addToCart".equals(userPath)) {
            if (carritoCompra == null) {
                carritoCompra = new CarritoCompra();
            }
            String productoId = request.getParameter("productoIdPost");

            Producto producto = getProductoById(productoId);
            int cantidadInt = 1;
            //int productoIdInt= Integer.parseInt(productoId);
            LoggerManager.getLog().info("iniciamos añadirproducto");
            carritoCompra.añadirProducto(producto, cantidadInt);

            httpSession.setAttribute("carritoCompra", carritoCompra);
            LoggerManager.getLog().info("volvemos a categoria despues de añadir un producto al carrito");
            userPath = "/category";
        } else if ("/updateCart".equals(userPath)) {

            int productoId = Integer.parseInt(request.getParameter("productId"));
            //int numProducto = request.getParameter("productoIdPost");
            int cantidad = Integer.parseInt(request.getParameter("quantity"));
            carritoCompra.actualiza(cantidad, productoId);
            httpSession.setAttribute("carritoCompra", carritoCompra);
            userPath = "/cart";
        } else if ("/purchase".equals(userPath)) {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String poblacion = request.getParameter("poblacion");
            String tarjeta = request.getParameter("tarjeta");
            Cliente cliente = new Cliente(dni, nombre, email, direccion, poblacion, telefono, tarjeta);
            if (cliente != null && carritoCompra != null) {
                gestionaOrden(cliente, carritoCompra);
            }
            httpSession.setAttribute("cliente", cliente);

            userPath = "/confirmation";
        } else {
            userPath = "../error";
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";
        request.setAttribute("view", url);
        request.getRequestDispatcher(url).forward(request, response);
        DatabaseManager.closeConnection();
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

    private void gestionaOrden(Cliente cliente, CarritoCompra carritoCompra) {
        try {
            DatabaseManager.openConnection();
            DatabaseManager.conn.setAutoCommit(false);
            int clienteId = añadeCliente(cliente);
            OrdenCliente ordenCliente = añadeOrden(clienteId, carritoCompra);
            añadeDetalleOrden(ordenCliente.getId(), carritoCompra);
            DatabaseManager.conn.commit();
            DatabaseManager.conn.setAutoCommit(true);
            
            // CarritoCompra carritoCompra = (CarritoCompra) httpSession.getAttribute("carritoCompra");
            // CarritoCompra carritoCompra = (CarritoCompra) httpSession.getAttribute("carritoCompra");
        } catch (SQLException ex) {
            try {
                DatabaseManager.conn.rollback();
            } catch (SQLException ex1) 
            {
                LoggerManager.getLog().info("Error: se realiza rollback en gestionaOrden" + ex1);
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
            LoggerManager.getLog().info("Error: al gestionaOrden" + ex);
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int añadeCliente(Cliente cliente) {
        int clienteId = 0;

        //insertamos el cliente en la tabla clientes con los campos dni, nombre, email, tlf, direccion, poblacion y tarjeta
         String addClienteSql = "INSERT into cliente (DNI, Nombre, email, telefono, direccion, poblacion, tarjeta) "+
                 "values ('"+cliente.getDni()+"','"+
                             cliente.getNombre()+"','"+
                             cliente.getEmail()+"','"+
                             cliente.getTelefono()+"','"+
                             cliente.getDireccion()+"','"+
                             cliente.getPoblacion()+"','"+
                             cliente.getTarjeta()+"')";

        //declaro los objetos Java para la query
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        String devuelveIdCliente ="SELECT id FROM cliente WHERE dni = '"+cliente.getDni()+"' AND  nombre ='"+cliente.getNombre()+"'"; 
        try {
            //ejecutar query
            preparedStatement = DatabaseManager.conn.prepareStatement(addClienteSql);
            preparedStatement.executeUpdate();
            
            LoggerManager.getLog().info("inserta cliente y devuelve id" + clienteId);

            preparedStatement = DatabaseManager.conn.prepareStatement(devuelveIdCliente);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                clienteId = resultSet.getInt("id");
            }
            
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            LoggerManager.getLog().error(ex.toString());
        }
        LoggerManager.getLog().info("inserta cliente y devuelve id" + clienteId);
        return clienteId;
        
    }

    private OrdenCliente añadeOrden(int clienteId, CarritoCompra carrito) {
        //tabla orden-cliente se inserta una orden con el id del cliente y con el total (subtotal+gatos) y demas campos los crea. 
        
        
        Random random = new Random();
        int numeroConfirmacion = random.nextInt(999999999);
        OrdenCliente ordenCliente = null;
        
         //insertamos el cliente en la tabla clientes con los campos dni, nombre, email, tlf, direccion, poblacion y tarjeta
         String addOrdenCliente = "INSERT into orden_cliente (total, NumeroConfirmacion, idCliente) "+
                 "values ("+carrito.getTotal()+","+numeroConfirmacion+","+clienteId+")";
        //declaro los objetos Java para la query
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        String devuelveOrdenCliente ="SELECT * FROM orden_cliente WHERE NumeroConfirmacion = "+numeroConfirmacion; 
        try {
            //ejecutar query
            preparedStatement = DatabaseManager.conn.prepareStatement(addOrdenCliente);
            preparedStatement.executeUpdate();
            
            preparedStatement = DatabaseManager.conn.prepareStatement(devuelveOrdenCliente);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                ordenCliente = new OrdenCliente(resultSet.getInt("id"),
                                                resultSet.getDouble("total"), 
                                                resultSet.getDate("fecha"), 
                                                resultSet.getInt("NumeroConfirmacion"), 
                                                resultSet.getInt("idCliente"));
            }
            
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            
            LoggerManager.getLog().error(ex.toString());
        }
        LoggerManager.getLog().info("inserta ordencliente y devuelve el objeto");     
        return ordenCliente;
    }

    private void añadeDetalleOrden(int ordenId, CarritoCompra carritoCompra) {
        //tabla detalle-orden. Insertamos la confirmacion de la orden.
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String addDetalleOrden;
        
        for(int i = 0; i< carritoCompra.getProductosCarritoCompra().size(); i++){
            try {
                addDetalleOrden = "INSERT into detalle_orden (idProducto, idOrden, cantidad, total) "+
                                  "values ("+carritoCompra.getProductosCarritoCompra().get(i).getProducto().getId()
                                    +","+ordenId
                                    +","+carritoCompra.getProductosCarritoCompra().get(i).getCantidad()
                                    +","+carritoCompra.getProductosCarritoCompra().get(i).getPrecioProductos()+")";
                //declaro los objetos Java para la query
                
                preparedStatement = DatabaseManager.conn.prepareStatement(addDetalleOrden);
                preparedStatement.executeUpdate();
                LoggerManager.getLog().info("inserta detalleOrden en la BBDD"+ordenId);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
     
    }
        
        
    

}
