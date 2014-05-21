/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.Date;

/**
 *
 * @author FO-Mañana
 */
public class OrdenCliente {
    
    private int id;
    private double total;
    private Date fecha;
    private int numeroConfirmacion;

    public OrdenCliente() {
    }

    public OrdenCliente(int id) {
        this.id = id;
    }

    public OrdenCliente(int id, double total, Date fecha, int numeroConfirmacion) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.numeroConfirmacion = numeroConfirmacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroConfirmacion() {
        return numeroConfirmacion;
    }

    public void setNumeroConfirmacion(int numeroConfirmacion) {
        this.numeroConfirmacion = numeroConfirmacion;
    }
    
    public int getClienteId() {
        return 0;
    }

    public void setClienteId(int clienteId) {

    }
    
}
