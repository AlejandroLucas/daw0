/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito;

import beans.Producto;
import java.util.ArrayList;
import managers.LoggerManager;

/**
 *
 * @author FO-Mañana
 */
public class CarritoCompra {

    private int numeroElementos;
    private double total;
    private ArrayList<ProductoCarritoCompra> productosCarritoCompra = new ArrayList<ProductoCarritoCompra>();
    private double SubTotal;

    public CarritoCompra() {
    }

    public void añadirProducto(Producto producto, int cantidad) {
        boolean productoEncontrado = false;
        LoggerManager.getLog().info("...");
        LoggerManager.getLog().info("tamaño del carrito " + productosCarritoCompra.size());
        if (productosCarritoCompra.isEmpty()) {
            LoggerManager.getLog().info("crea lista carrito");
            ProductoCarritoCompra productoCarritoCompra = new ProductoCarritoCompra(producto, cantidad);
            productosCarritoCompra.add(productoCarritoCompra);
            numeroElementos++;
            SubTotal += producto.getPrecio();
        } else {
            for (int i = 0; i < productosCarritoCompra.size(); i++) {
                LoggerManager.getLog().info("entra en for");
                if (productosCarritoCompra.size() > 0) {
                    if (productosCarritoCompra.get(i).getProducto().getId() == producto.getId()) {
                        LoggerManager.getLog().info("actualiza la cantidad de productos +1");
                        actualiza(cantidad, producto.getId());
                        productoEncontrado = true;

                        SubTotal += producto.getPrecio();
                    }
                } /*else {
                 LoggerManager.getLog().info("crea en producto en el carrito no existe");
                 ProductoCarritoCompra productoCarritoCompra = new ProductoCarritoCompra(producto, cantidad);
                 productosCarritoCompra.add(productoCarritoCompra);
                 numeroElementos++;
                 }*/

            }
            if (!productoEncontrado) {

                LoggerManager.getLog().info("crea en producto en el carrito<0");
                ProductoCarritoCompra productoCarritoCompra = new ProductoCarritoCompra(producto, cantidad);
                productosCarritoCompra.add(productoCarritoCompra);
                numeroElementos++;

                SubTotal += producto.getPrecio();

            }
        }
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void limpia() {
    }

    public void actualiza(int cantidadInt, int productoIdInt) {
        LoggerManager.getLog().info("actualiza cantidad productos");
        for (int i = 0; i < productosCarritoCompra.size(); i++) {
            if (productosCarritoCompra.get(i).getProducto().getId() == productoIdInt) {
                productosCarritoCompra.get(i).incrementaCantidad();
                numeroElementos += cantidadInt;
            }
            /*else{
             Producto producto = getProductoById(productoIdInt);
             añadirProducto(producto, cantidadInt);
             }*/
        }
    }

    public void CalculaTotal(String gastosSpedicion) {
    }

    public double getTotal() {
        return total;
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }

    public ArrayList<ProductoCarritoCompra> getProductosCarritoCompra() {
        return productosCarritoCompra;
    }

    public void setProductosCarritoCompra(ArrayList<ProductoCarritoCompra> productosCarritoCompra) {
        this.productosCarritoCompra = productosCarritoCompra;
    }

}
