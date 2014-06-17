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
    private double gastosSpedicion;
    private ArrayList<ProductoCarritoCompra> productosCarritoCompra = new ArrayList<ProductoCarritoCompra>();
    private double subTotal = 0;

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
            subTotal += producto.getPrecio();
            LoggerManager.getLog().info(subTotal);
        } else {
            for (int i = 0; i < productosCarritoCompra.size(); i++) {
                LoggerManager.getLog().info("entra en for");
                if (productosCarritoCompra.size() > 0) {
                    if (productosCarritoCompra.get(i).getProducto().getId() == producto.getId()) {
                        LoggerManager.getLog().info("actualiza la cantidad de productos +1");
                        actualiza(cantidad, producto.getId());
                        productoEncontrado = true;

                       subTotal += producto.getPrecio();
                       LoggerManager.getLog().info(subTotal);
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
                subTotal += producto.getPrecio();
                LoggerManager.getLog().info(subTotal);
            }
        }
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void limpia() {
        for (int i = productosCarritoCompra.size() - 1; i >=0; i--) {
            productosCarritoCompra.remove(i);
        }
        numeroElementos = 0; 
        subTotal = 0;
    }

    public void actualiza(int cantidadInt, int productoIdInt) {
    
        int cantidadAnterior;
        LoggerManager.getLog().info("actualiza cantidad productos");
        for (int i = 0; i < productosCarritoCompra.size(); i++) {
            if (productosCarritoCompra.get(i).getProducto().getId() == productoIdInt) {
                cantidadAnterior = productosCarritoCompra.get(i).getCantidad();
                subTotal = subTotal + productosCarritoCompra.get(i).getProducto().getPrecio() * cantidadInt
                         - productosCarritoCompra.get(i).getProducto().getPrecio() * cantidadAnterior;
                productosCarritoCompra.get(i).incrementaCantidad(cantidadInt);
                numeroElementos = numeroElementos + cantidadInt - cantidadAnterior;
                if (cantidadInt <= 0)
                {
                    productosCarritoCompra.remove(i);
                }
            }
            /*else{
             Producto producto = getProductoById(productoIdInt);
             añadirProducto(producto, cantidadInt);
             }*/
        }
    }

    public double getGastosSpedicion() {
        return gastosSpedicion;
    }

    public void setGastosSpedicion(double gastosSpedicion) {
        this.gastosSpedicion = gastosSpedicion;
    }
    
    
    public void calculaTotal(double gastos) {
        total = subTotal + gastos;
        gastosSpedicion = gastos;
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
