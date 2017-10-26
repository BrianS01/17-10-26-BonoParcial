/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.model;

/**
 *
 * @author Juan Albarracin
 */
public class Departamento {
    int id_departamento;
    String nombre_departamento;
    String puesto;

    @Override
    public String toString() {
        return "Departamento{" + "id_departamento=" + id_departamento + ", nombre_departamento=" + nombre_departamento + ", puesto=" + puesto + '}';
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
