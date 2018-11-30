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
import vo2.Results;

/**
 *
 * @author LabingI5
 */
public class DAOresultado implements CursoBaseDatos<Results> {

    /*
    int IDresultado;// INT NOT NULL auto_increment PRIMARY KEY , 
    int idEstudiante;// INT NOT NULL,
    String CAT;// varchar(30) NOT NULL,
    int ENO;// int not null,
    int POINTS;// int not null,
    int idexercises;//INT NOT NULL, */
    public Results find(int cedula) throws SQLException, URISyntaxException {
        Results resultado = null;
        String query = "Select * from Results Where IDresultado =" + cedula;
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0, pointS = 0, apellido = 0;
            String nombre = null;
            if (rs.next()) {
                resultado = new Results();
                id = rs.getInt("cedula");
                resultado.setIdEstudiante(id);
                nombre = rs.getString("nombre");
                resultado.setCAT(nombre);
                apellido = rs.getInt("ENO");
                resultado.setENO(apellido);
                pointS = rs.getInt("pointS");
                resultado.setPOINTS(pointS);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener persona");
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List findAll() throws SQLException {
        List<Results> personas = null;
        String query = "SELECT * FROM resultado";
        try {
            Connection connection = Conexion.getConnection();
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                int id = 0, pointS = 0, apellido = 0;
                String nombre = null;
                while (rs.next()) {
                    if (personas == null) {
                        personas = new ArrayList<Results>();
                    }

                    Results registro = new Results();
                    id = rs.getInt("sid");
                    registro.setIdEstudiante(id);
                    nombre = rs.getString("cat");
                    registro.setCAT(nombre);
                    apellido = rs.getInt("ENO");
                    registro.setENO(apellido);
                    pointS = rs.getInt("pointS");
                    registro.setPOINTS(pointS);
                }
                st.close();

            } catch (SQLException e) {
                System.out.println("Problemas al obtener la lista de Departamentos");
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOresultado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personas;
    }

    @Override
    public boolean insert(Results persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();

            ///INSERT   INTO resultado (idEstudiante,CAT,ENO,POINTS,idexercises) VALUES  (101,'H',1,10,1);
            String query = " insert into resultado (idEstudiante,CAT,ENO,POINTS,idexercises)"
                    + " values (?,?,?,?,?)";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);

                preparedStmt.setInt(1, persona.getIdEstudiante());
                preparedStmt.setString(2, persona.getCAT());
                preparedStmt.setInt(3, persona.getENO());
                preparedStmt.setInt(3, persona.getPOINTS());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOresultado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public boolean update(Results persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();
            //CAT,ENO,POINTS,idexercises
        String query
                = "update resultado set CAT = ?, ENO = ?, POINTS=? where IDresultado  = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, persona.getCAT());
            preparedStmt.setInt(2, persona.getENO());
            preparedStmt.setInt(3, persona.getPOINTS());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOresultado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    @Override
    public boolean delete(Results persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();

            String query = "delete from resultado where IDresultado  = ?";
            System.out.println(query + " " + persona.getIDresultado());
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, persona.getIDresultado());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOresultado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
