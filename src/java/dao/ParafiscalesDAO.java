/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.DbUtil;
import db.Parafiscales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParafiscalesDAO
{
    private Connection connection;

    public ParafiscalesDAO()
    {
        connection = DbUtil.getConnection();
    }

    public void addUser(Parafiscales user)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into parafiscales(idParafiscales,sena,icbf,cajaCompensacion) values (?, ?, ?, ? )");
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

    public void updateUser(Parafiscales user)
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

    public List<Parafiscales> getAllUsers()
    {
        List<Parafiscales> users = new ArrayList<Parafiscales>();
        
        try
        {
            System.out.println("Llegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from parafiscales");
            
            while (rs.next())
            {
                Parafiscales user = new Parafiscales();
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

    public Parafiscales getUserById(int userId)
    {
        Parafiscales user = new Parafiscales();
        
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