package com.gustosupremo.gustosupremo.dao;

import com.gustosupremo.gustosupremo.exceptions.Exceptions;
import com.gustosupremo.gustosupremo.models.Sucursal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalesDaoImplement implements SucursalesDao {

    //conexión a postgress
    private static final String url = "jdbc:postgresql://localhost:5432/GustoSupremo";
    private static final String user = "postgres";
    private static final String password = "root";

    //script para seleccionar 
    private static final String SELECT_ALL_SUCURSALES = "SELECT * FROM sucursales";
    private static final String INSERT_SUCURSALES = "INSERT INTO sucursales (codigo_sucursales, nombre, direccion, gerente_encargado) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SUCURSALES = "UPDATE sucursales SET nombre = ?, direccion = ?, gerente_encargado = ? WHERE codigo_sucursales = ?";
    private static final String DELETE_SUCURSALES = "DELETE FROM sucursales WHERE codigo_sucursales = ?";

    @Override
    public List<Sucursal> list() {
        List<Sucursal> sucursales = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SUCURSALES)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setCodigo_sucursales(resultSet.getInt("codigo_sucursales"));
                sucursal.setNombre(resultSet.getString("nombre"));
                sucursal.setDireccion(resultSet.getString("direccion"));
                sucursal.setGerente_encargado(resultSet.getString("gerente_encargado"));
                sucursales.add(sucursal);
            }
        } catch (SQLException e) {
            throw new Exceptions("Error in the take data", e);
        }
        return sucursales;
    }

    @Override
    public void addSucursal(Sucursal sucursal) {
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement statement = connection.prepareStatement(INSERT_SUCURSALES)) {
            statement.setInt(1, sucursal.getCodigo_sucursales());
            statement.setString(2, sucursal.getNombre());
            statement.setString(3, sucursal.getDireccion());
            statement.setString(4, sucursal.getGerente_encargado());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exceptions("Error in create data", e);
        }
    }

    @Override
    public void deleteSucursal(int codigo_sucursales) {
        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement stmt = conn.prepareStatement(DELETE_SUCURSALES)) {
            stmt.setInt(1, codigo_sucursales);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exceptions("Error in delete date", e);
        }
    }

    @Override
    public void updateSucursal(Sucursal sucursal, int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement statement = connection.prepareStatement(UPDATE_SUCURSALES)) {
            System.out.println("Ingresa el Codigo de la Sucursal a Editar: ");
            sucursal.setCodigo_sucursales(id);
            statement.setString(1, sucursal.getNombre());
            statement.setString(2, sucursal.getDireccion());
            statement.setString(3, sucursal.getGerente_encargado());
            statement.setInt(4, sucursal.getCodigo_sucursales());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Sucursal actualizada con éxito.");
            } else {
                System.out.println("No se encontró la sucursal con el código especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
