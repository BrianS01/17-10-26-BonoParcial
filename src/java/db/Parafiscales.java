/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author BRIAN
 */
public class Parafiscales
{
    private int idParafiscales;
    private int sena;
    private int icbf;
    private int cajaCompensacion;
    
    public int getIdParafiscales() {
        return idParafiscales;
    }

    public void setIdParafiscales(int idParafiscales) {
        this.idParafiscales = idParafiscales;
    }

    public int getSena() {
        return sena;
    }

    public void setSena(int sena) {
        this.sena = sena;
    }

    public int getIcbf() {
        return icbf;
    }

    public void setIcbf(int icbf) {
        this.icbf = icbf;
    }

    public int getCajaCompensacion() {
        return cajaCompensacion;
    }

    public void setCajaCompensacion(int cajaCompensacion) {
        this.cajaCompensacion = cajaCompensacion;
    }

    @Override
    public String toString() {
        return "Parafiscales{" + "idParafiscales=" + idParafiscales + ", sena=" + sena + ", icbf=" + icbf + ", cajaCompensacion=" + cajaCompensacion + '}';
    }
}