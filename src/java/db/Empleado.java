/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Juan Albarracin
 */
public class Empleado {
  int num_empleado;
  int cedula;
  String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  String lugarnacimiento;
  String Status;
  Date fechai;
  int id_sueldo;
  int id_departamento;
  int id_contrarto;

    @Override
    public String toString() {
        return "Empleado{" + "num_empleado=" + num_empleado + ", cedula=" + cedula + ", lugarnacimiento=" + lugarnacimiento + ", Status=" + Status + ", fechai=" + fechai + ", id_sueldo=" + id_sueldo + ", id_departamento=" + id_departamento + ", nombre=" + nombre+ ", id_contrarto=" + id_contrarto + '}';
    }

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public int getId_sueldo() {
        return id_sueldo;
    }

    public void setId_sueldo(int id_sueldo) {
        this.id_sueldo = id_sueldo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_contrarto() {
        return id_contrarto;
    }

    public void setId_contrarto(int id_contrarto) {
        this.id_contrarto = id_contrarto;
    }
  
  
  
}
