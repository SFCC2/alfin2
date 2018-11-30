/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import dao2.*;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo2.Estudiante;

/**
 *
 * @author LabingI5
 */
public class DAOestudiante implements CursoBaseDatos<Estudiante> {

    public Estudiante find(int cedula) throws SQLException, URISyntaxException {
        Estudiante resultado = null;
        String query = "Select * from estudiante Where idEstudiante  =" + cedula;
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String nombre = null, apellido = null, correo = null;
            if (rs.next()) {
                resultado = new Estudiante();
                id = rs.getInt("codigo");
                resultado.setIdEstudiante(id);
                nombre = rs.getString("nombre");
                resultado.setNombre(nombre);
                apellido = rs.getString("apellido");
                resultado.setApellido(apellido);

                correo = rs.getString("correo");
                resultado.setApellido(correo);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener Estudiante");
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List findAll() throws SQLException {
        List<Estudiante> personas = null;
        String query = "SELECT * FROM estudiante";
        try {
            Connection connection = Conexion.getConnection();
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                int id = 0;
                String nombre = null, apellido = null, correo = null;
                while (rs.next()) {
                    if (personas == null) {
                        personas = new ArrayList<Estudiante>();
                    }

                    Estudiante registro = new Estudiante();
                    id = rs.getInt("codigo");
                    registro.setIdEstudiante(id);
                    nombre = rs.getString("nombre");
                    registro.setNombre(nombre);
                    apellido = rs.getString("apellido");
                    registro.setApellido(apellido);
                    correo = rs.getString("correo");
                    registro.setApellido(correo);
                    personas.add(registro);
                }
                st.close();

            } catch (SQLException e) {
                System.out.println("Problemas al obtener la lista de Departamentos");
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personas;
    }

    @Override
    public boolean insert(Estudiante persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();
            //INSERT INTO estudiante VALUES(101,'Ann','Smith','Ans@yahoo.es');
            String query = " insert into estudiante " + " values (?,?,?,?)";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, persona.getIdEstudiante());
                preparedStmt.setString(2, persona.getNombre());
                preparedStmt.setString(3, persona.getApellido());
                preparedStmt.setString(4, persona.getCorreo());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public boolean update(Estudiante persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();
            //INSERT INTO estudiante VALUES(101,'Ann','Smith','Ans@yahoo.es');
            //idEstudiante INT NOT NULL  PRIMARY KEY, nombre varchar(30) NOT NULL,    apellido varchar(30) NOT NULL,    correo varchar(30)
            String query
                    = "update estudiante set nombre = ?, apellido = ? where cedula = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, persona.getNombre());
                preparedStmt.setString(2, persona.getApellido());
                preparedStmt.setString(3, persona.getCorreo());
                if (preparedStmt.executeUpdate() > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public boolean delete(Estudiante persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();
            String query = "delete from estudiante where idEstudiante  = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, persona.getIdEstudiante());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
