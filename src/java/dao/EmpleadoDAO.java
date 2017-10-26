/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.dao;

import com.daniel.model.Empleado;

import conexion.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**

* 
public class EmpleadoDAO {
      private Connection connection;
      public EmpleadoDAO()
    {
        connection = DbUtil.getConnection();
    }
      
      public List<Empleado> getAllempleados()
    {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try
        {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from empleado");
            while (rs.next())
            {
                Empleado empleado = new Empleado();
                empleado.setCedula(rs.getInt("cedula"));
                //empleado.setNum_empleado(rs.getInt("numeroemp"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setLugarnacimiento(rs.getString("lugarNacimiento"));
               empleado.setStatus(rs.getString("estatus"));
                empleado.setFechai(rs.getDate("fechaIngreso"));
                // empleado.setId_contrarto(rs.getInt("idContrato"));
                  //empleado.setId_departamento(rs.getInt("idDepartamento"));
                   //empleado.setId_sueldo(rs.getInt("idSueldo"));
                empleados.add(empleado);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return empleados;
    }

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
