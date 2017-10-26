/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Salario;
import conexion.DbUtil;

public class SalarioDAO
{
    private Connection connection;

    public SalarioDAO()
    {
        connection = DbUtil.getConnection();
    }

    public void addUser(Salario user)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into parafiscales(sena,icbf,cajaCompensacion) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setInt(1, user.getIdParafiscales());
            preparedStatement.setInt(2, user.getIcbf());
            preparedStatement.setInt(3, user.getCajaCompensacion());
            preparedStatement.setInt(4, user.getSena());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUser(int idParafiscales)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from parafiscales where idParafiscales=?");
            // Parameters start with 1
            preparedStatement.setInt(1, idParafiscales);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateUser(Salario user)
    {
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement("update parafiscales set sena=?, icbf=?, cajaCompensacion=?" + "where idParafiscales=?");
            // Parameters start with 1
            preparedStatement.setInt(1, user.getIdParafiscales());
            preparedStatement.setInt(2, user.getIcbf());
            preparedStatement.setInt(3, user.getCajaCompensacion());
            preparedStatement.setInt(4, user.getSena());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Salario> getAllUsers()
    {
        List<Salario> users = new ArrayList<Salario>();
        try
        {
            System.out.println("Llegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from parafiscales");
            while (rs.next())
            {
                Salario user = new Salario();
                user.setIdParafiscales(rs.getInt("idParafiscales"));
                user.setSena(rs.getInt("sena"));
                user.setIcbf(rs.getInt("icbf"));
                user.setCajaCompensacion(rs.getInt("cajaCompensacion"));
                users.add(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }

    public Salario getUserById(int userId)
    {
        Salario user = new Salario();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from parafiscales where idParafiscales=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                user.setIdParafiscales(rs.getInt("idParafiscales"));
                user.setSena(rs.getInt("sena"));
                user.setIcbf(rs.getInt("icbf"));
                user.setCajaCompensacion(rs.getInt("cajaCompensacion"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}