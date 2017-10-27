/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SalarioDAO;
import db.Salario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SalarioCon extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private SalarioDAO dao;

    public SalarioCon()
    {
        super();
        dao = new SalarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String forward = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete"))
        {
            int userId = Integer.parseInt(request.getParameter("idSalario"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("salario", dao.getAllUsers());
        }
        else if (action.equalsIgnoreCase("edit"))
        {
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("idSalario"));
            Salario user = dao.getUserById(userId);
            request.setAttribute("user", user);
        }
        else if (action.equalsIgnoreCase("listUser"))
        {
            forward = LIST_USER;
            request.setAttribute("salario", dao.getAllUsers());
        }
        else
        {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Salario user = new Salario();
        String userid = request.getParameter("idSalario");
        
        if (userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setIdSalario(Integer.parseInt(userid));
            dao.updateUser(user);
        }

        user.setIdSalario(request.getIntHeader("idSalario"));
        user.setAuxilio(request.getIntHeader("auxilio"));
        user.setPrima(request.getIntHeader("prima"));
        user.setCesantias(request.getIntHeader("cesantias"));
        user.setInteres(request.getIntHeader("interes"));
        user.setVacasiones(request.getIntHeader("vacasiones"));
        user.setSalud(request.getIntHeader("salud"));
        user.setPension(request.getIntHeader("pension"));
        user.setIdParafiscales(request.getIntHeader("idParafiscales"));
        user.setSalario(request.getIntHeader("salario"));
        user.setPago(request.getIntHeader("pago"));
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("salario", dao.getAllUsers());
        view.forward(request, response);
    }
}