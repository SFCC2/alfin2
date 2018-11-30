package dao2;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
/**
 *
 * @author Sulay Cupitra Cupitra
 * @Asginatura. BASE DE DATOS
 * @Actividad: Examen final
 * 
 */

public class Conexion {

    private static Connection CONEXION = null;
    
   
    public static Connection getConnection() throws SQLException, URISyntaxException {

        URI dbUri = new URI(System.getenv("postgres://dowcxjdhstluic:c383ce0145971f2a5db93a8c4108fec0d61ca1aa8c717178ddd4e9cdb0aaa299@ec2-54-235-156-60.compute-1.amazonaws.com:5432/dbcb06acdb57pd"));
        String username = dbUri.getUserInfo().split("dowcxjdhstluic")[0];
        String password = dbUri.getUserInfo().split("c383ce0145971f2a5db93a8c4108fec0d61ca1aa8c717178ddd4e9cdb0aaa299")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        if (CONEXION == null) {
            try {
                
                
                CONEXION = DriverManager.getConnection(dbUrl, username, password);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }

        }
        
        try {
                CONEXION = DriverManager.getConnection(dbUrl);
                // aqui se contecta
            } catch (SQLException e) {
                throw new SQLException(e);

            }

        return CONEXION;
    }
    

    public static void closeConnection() throws SQLException {
        try {
            if (CONEXION != null) {
                CONEXION.close();
                CONEXION = null;
            }

        } catch (SQLException e) {
            //Integracion Log4J
            throw new SQLException(e);
        }

    }

}
