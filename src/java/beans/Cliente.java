/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.List;

/**
 *
 * @author FO-Mañana
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private String tarjeta;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nombre, String email, String direccion, String telefono, String tarjeta) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
    }

    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public List<OrdenCliente> getOrdenClienteList() {
        return null;
    }

    public void setOrdenClienteList(List<OrdenCliente> ordenesCliente) {

    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    public boolean Equals(Object object) {
        return true;
    }
    
}