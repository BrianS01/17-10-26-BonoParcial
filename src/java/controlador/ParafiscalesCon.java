/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ParafiscalesDAO;
import db.Parafiscales;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParafiscalesCon extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private ParafiscalesDAO dao;

    public ParafiscalesCon()
    {
        super();
        dao = new ParafiscalesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String forward = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete"))
        {
            int userId = Integer.parseInt(request.getParameter("idParafiscales"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("parafiscales", dao.getAllUsers());
        }
        else if (action.equalsIgnoreCase("edit"))
        {
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("idParafiscales"));
            Parafiscales user = dao.getUserById(userId);
            request.setAttribute("user", user);
        }
        else if (action.equalsIgnoreCase("listUser"))
        {
            forward = LIST_USER;
            request.setAttribute("parafiscales", dao.getAllUsers());
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
        Parafiscales user = new Parafiscales();
        String userid = request.getParameter("idParafiscales");
        
        if (userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setIdParafiscales(Integer.parseInt(userid));
            dao.updateUser(user);
        }

        user.setSena(request.getIntHeader("sena"));
        user.setIcbf(request.getIntHeader("icbf"));
        user.setCajaCompensacion(request.getIntHeader("cajaCompensacion"));
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("parafiscales", dao.getAllUsers());
        view.forward(request, response);
    }
}
