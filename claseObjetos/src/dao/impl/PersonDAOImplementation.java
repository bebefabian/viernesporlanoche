package dao.impl;

import dao.PersonDAO;
import model.Person;

import java.sql.*;

public class PersonDAOImplementation implements PersonDAO {
    String url = "jdbc:mysql://localhost:3306/estudiante";
    String username = "root";
    String password = "root";

    @Override
    public void create(Person person) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO persona (nombre, apellido, edad, cedula) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set values for the prepared statement
                statement.setString(1, person.nombre);
                statement.setString(2, person.apellido);
                statement.setInt(3, person.edad);
                statement.setString(4, person.cedula);

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person getByCedula(String cedula) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sqlQuery = "SELECT nombre, apellido, edad, cedula FROM persona WHERE cedula=?";
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
                statement.setString(1, cedula);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    String nombre = rs.getString(1);
                    String apellido = rs.getString(2);
                    int edad = rs.getInt(3);
                    //String cedula = rs.getString(4);
                    Person person = new Person();
                    //populate person
                    person.nombre = nombre;
                    person.apellido = apellido;
                    person.edad = edad;
                    person.cedula = cedula;
                    return person;
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Person person) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "update persona set nombre=?, apellido=?, edad=? where cedula =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set values for the prepared statement
            statement.setString(1, person.nombre);
            statement.setString(2, person.apellido);
            statement.setInt(3, person.edad);
            statement.setString(4, person.cedula);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String cedula) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "delete from persona where cedula=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set values for the prepared statement
            statement.setString(1, cedula);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
