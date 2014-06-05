/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito;

import beans.Producto;
import java.util.ArrayList;

/**
 *
 * @author FO-Mañana
 */
public class CarritoCompra {

    private int numeroElementos;
    private double total;
    private ArrayList<ProductoCarritoCompra> productosCarritoCompra;

    public CarritoCompra() {
    }
    public void añadirProducto(Producto producto, int cantidad) {
       for(int i=0;i<productosCarritoCompra.size();i++){
           if(productosCarritoCompra.get(i).getProducto().equals(producto)){
               actualiza(cantidad,producto.getId());
           }else{
           ProductoCarritoCompra productoCarritoCompra = new ProductoCarritoCompra(producto, cantidad);
            productosCarritoCompra.add(productoCarritoCompra);
           }
       } 
    }

    public double getSubTotal() {
        return 0;
    }

    public void limpia() {
    }

    public void actualiza(int cantidadInt, int productoIdInt) {
        for(int i=0;i<productosCarritoCompra.size();i++){
            if(productosCarritoCompra.get(i).getProducto().getId()==productoIdInt){
            productosCarritoCompra.get(i).incrementaCantidad();
            numeroElementos+=cantidadInt;
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


}
