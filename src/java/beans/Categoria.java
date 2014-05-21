/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FO-Mañana
 */
public class Categoria {
    
    private int id;
    private String nombre;
    private String imagen;
    ArrayList<Producto> productos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria() {
    }

    public Categoria(int id) {
        this.id = id;
    }

    public Categoria(int id, String nombre, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }
    
    public List<Producto> getProductoList()
    {
        return null;
    }
    
    public List<Producto> getProductoList(int parseInt)
    {
        return null;
    }
    
    public void setProductoList(List<Producto> productoList)
    {
        productos = (ArrayList<Producto>) productoList;
    }
    
}
