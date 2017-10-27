/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.DbUtil;
import db.Salario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into salario(idSalario, auxilio, prima, cesantias, interes, vacasiones, salud, pension, idParafiscales, salario, pago) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, user.getIdSalario());
            preparedStatement.setInt(2, user.getAuxilio());
            preparedStatement.setInt(3, user.getPrima());
            preparedStatement.setInt(4, user.getCesantias());
            preparedStatement.setInt(5, user.getInteres());
            preparedStatement.setInt(6, user.getVacasiones());
            preparedStatement.setInt(7, user.getSalud());
            preparedStatement.setInt(8, user.getPension());
            preparedStatement.setInt(9, user.getIdParafiscales());
            preparedStatement.setInt(10, user.getSalario());
            preparedStatement.setInt(11, user.getPago());
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from salario where idSalario=?");
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
            PreparedStatement preparedStatement = connection.prepareStatement("update salario set idSalario=?, auxilio=?, prima=?, cesantias=?, interes=?, vacasiones=?, salud=?, pension=?, idParafiscales=?, salario=?, pago=?" + "where idParafiscales=?");
            // Parameters start with 1
            preparedStatement.setInt(1, user.getIdSalario());
            preparedStatement.setInt(2, user.getAuxilio());
            preparedStatement.setInt(3, user.getPrima());
            preparedStatement.setInt(4, user.getCesantias());
            preparedStatement.setInt(5, user.getInteres());
            preparedStatement.setInt(6, user.getVacasiones());
            preparedStatement.setInt(7, user.getSalud());
            preparedStatement.setInt(8, user.getPension());
            preparedStatement.setInt(9, user.getIdParafiscales());
            preparedStatement.setInt(10, user.getSalario());
            preparedStatement.setInt(11, user.getPago());
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
            ResultSet rs = statement.executeQuery("select * from salario");
            
            while (rs.next())
            {
                Salario user = new Salario();
                user.setIdSalario(rs.getInt("idSalario"));
                user.setAuxilio(rs.getInt("auxilio"));
                user.setPrima(rs.getInt("prima"));
                user.setCesantias(rs.getInt("cesantias"));
                user.setInteres(rs.getInt("interes"));
                user.setVacasiones(rs.getInt("vacasiones"));
                user.setSalud(rs.getInt("salud"));
                user.setPension(rs.getInt("pension"));
                user.setIdParafiscales(rs.getInt("idParafiscales"));
                user.setSalario(rs.getInt("salario"));
                user.setPago(rs.getInt("pago"));
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
                user.setIdSalario(rs.getInt("idSalario"));
                user.setAuxilio(rs.getInt("auxilio"));
                user.setPrima(rs.getInt("prima"));
                user.setCesantias(rs.getInt("cesantias"));
                user.setInteres(rs.getInt("interes"));
                user.setVacasiones(rs.getInt("vacasiones"));
                user.setSalud(rs.getInt("salud"));
                user.setPension(rs.getInt("pension"));
                user.setIdParafiscales(rs.getInt("idParafiscales"));
                user.setSalario(rs.getInt("salario"));
                user.setPago(rs.getInt("pago"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}