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
public class Contrato {
    int id_contrato;
    String tipo;
    String turno;

    @Override
    public String toString() {
        return "Contrato{" + "id_contrato=" + id_contrato + ", tipo=" + tipo + ", turno=" + turno + '}';
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
