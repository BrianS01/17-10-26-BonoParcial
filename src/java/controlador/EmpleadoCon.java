/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.controller;

import com.daniel.dao.DaoEmpleado;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Albarracin
 */
public class EmpleadoController extends HttpServlet {
    
    
    
     private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Empleado.jsp";
    private static String LIST_USER = "/Listempleado.jsp";
    private DaoEmpleado dao;
    
    public EmpleadoController()
    {
        super();
        dao = new DaoEmpleado();
    }
    
    
    
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String forward = "";
        String action = request.getParameter("action");
    
    if (action.equalsIgnoreCase("listUser"))
        {
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllempleados());
        }
    else
        {
          //  forward = INSERT_OR_EDIT;
        }
    
     RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    
    
    }

    
    
    

}
