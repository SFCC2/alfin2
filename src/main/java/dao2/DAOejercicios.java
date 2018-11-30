/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import vo2.Excercise;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LabingI5
 */
public class DAOejercicios implements CursoBaseDatos<Excercise> {

    public Excercise find(int cedula) throws SQLException, URISyntaxException {
        Excercise resultado = null;
        String query = "Select * from exercises Where idexercises  =" + cedula;
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0, total;
            String nombre = null, apellido = null, topic = null;
            if (rs.next()) {
                resultado = new Excercise();
                id = rs.getInt("cedula");
                resultado.setIdExcercise(id);
                nombre = rs.getString("cat");
                resultado.setCAT(nombre);
                apellido = rs.getString("end");
                resultado.setEND(apellido);
                topic = rs.getString("topic");
                resultado.setEND(apellido);
                apellido = rs.getString("end");
                resultado.setEND(apellido);
                total = rs.getInt("total");
                resultado.setMAXTP(total);
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
        List<Excercise> personas = null;
        String query = "SELECT * FROM exercises";
        try {
            Connection connection = Conexion.getConnection();
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                int id = 0, total;
                String nombre = null, apellido = null, topic = null;
                while (rs.next()) {
                    if (personas == null) {
                        personas = new ArrayList<Excercise>();
                    }

                    Excercise registro = new Excercise();
                    id = rs.getInt("cedula");
                    registro.setIdExcercise(id);
                    nombre = rs.getString("cat");
                    registro.setCAT(nombre);
                    apellido = rs.getString("end");
                    registro.setEND(apellido);
                    topic = rs.getString("topic");
                    registro.setTOPIC(apellido);
                    total = rs.getInt("total");
                    registro.setMAXTP(total);
                    personas.add(registro);
                }
                st.close();

            } catch (SQLException e) {
                System.out.println("Problemas al obtener la lista de Departamentos");
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOejercicios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personas;
    }

    @Override
    public boolean insert(Excercise persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();

            //INSERT   INTO exercises (CAT,ENO,TOPIC,MAXPT) VALUES  ('H',1,'Rel.Alg',10);
            String query = " insert into exercises (CAT,ENO,TOPIC,MAXPT)" + " values (?,?,?,?)";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, persona.getIdExcercise());
                preparedStmt.setString(2, persona.getCAT());
                preparedStmt.setString(3, persona.getEND());
                preparedStmt.setString(4, persona.getTOPIC());
                preparedStmt.setInt(5, persona.getMAXTP());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOejercicios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public boolean update(Excercise persona) throws SQLException {
        boolean result = false;
        try {
            Connection connection = Conexion.getConnection();

            String query
                    = "update exercises set nombre = ?, apellido = ? where cedula = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);

                preparedStmt.setString(1, persona.getCAT());
                preparedStmt.setString(2, persona.getEND());
                preparedStmt.setString(3, persona.getTOPIC());
                preparedStmt.setInt(4, persona.getMAXTP());

                if (preparedStmt.executeUpdate() > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOejercicios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public boolean delete(Excercise persona) throws SQLException {
        boolean result = false;
        Connection connection;
        try {
            connection = Conexion.getConnection();

            //idexercises INT NOT  NULL auto_increment   PRIMARY KEY,     CAT varchar(1) not null,    ENO int not null,
//TOPIC varchar(30) NOT NULL,    MAXPT INT NOT NULL
            String query = "delete from exercises where idexercises = ?";
            System.out.println(query + " " + persona.getIdExcercise());
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, persona.getIdExcercise());
                result = preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOejercicios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
