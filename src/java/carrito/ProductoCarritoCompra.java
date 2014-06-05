/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carrito;

import beans.Producto;

/**
 *
 * @author FO-Mañana
 */
class ProductoCarritoCompra {
    private int cantidad;
    private Producto producto;
         
    public ProductoCarritoCompra(){};
    public ProductoCarritoCompra(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void incrementaCantidad(){
        this.cantidad+=1;
    }
    public void decrementaCantidad(){};
    
    public double getPrecioProductos(){
        double precioProducto=producto.getPrecio();
        double precioProductos=precioProducto*cantidad;
        return precioProductos;
    }
}
