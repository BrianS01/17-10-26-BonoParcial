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
public class Salario
{
    private int idSalario;
    private int auxilio;
    private int prima;
    private int cesantias;
    private int interes;
    private int vacasiones;
    private int salud;
    private int pension;
    private int idParafiscales;
    private int salario;
    private int pago;

    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    public int getAuxilio() {
        return auxilio;
    }

    public void setAuxilio(int auxilio) {
        this.auxilio = auxilio;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
        this.prima = prima;
    }

    public int getCesantias() {
        return cesantias;
    }

    public void setCesantias(int cesantias) {
        this.cesantias = cesantias;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getVacasiones() {
        return vacasiones;
    }

    public void setVacasiones(int vacasiones) {
        this.vacasiones = vacasiones;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getPension() {
        return pension;
    }

    public void setPension(int pension) {
        this.pension = pension;
    }

    public int getIdParafiscales() {
        return idParafiscales;
    }

    public void setIdParafiscales(int idParafiscales) {
        this.idParafiscales = idParafiscales;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    @Override
    public String toString()
    {
        return "Salario{" + "idSalario=" + idSalario + ", auxilio=" + auxilio + ", prima=" + prima + ", cesantias=" + cesantias + ", interes=" + interes + ", vacasiones=" + vacasiones + ", salud=" + salud + ", pension=" + pension + ", idParafiscales=" + idParafiscales + ", salario=" + salario + ", pago=" + pago + '}';
    }
}