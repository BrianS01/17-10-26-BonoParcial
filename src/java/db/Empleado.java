/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

public class Empleado 
{
    private int cedula;
    private int nombre;
    private int lugarNacimiento;
    private int estatus;
    private int fechaIngreso;
    private int idSalario;
    private int idDepartamento;
    private int idContrato;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(int lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cedula=" + cedula + ", nombre=" + nombre + ", lugarNacimiento=" + lugarNacimiento + ", estatus=" + estatus + ", fechaIngreso=" + fechaIngreso + ", idSalario=" + idSalario + ", idDepartamento=" + idDepartamento + ", idContrato=" + idContrato + '}';
    }
}