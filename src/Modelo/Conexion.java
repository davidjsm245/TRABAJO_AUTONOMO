package Modelo;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author taeko
 */
public class Conexion {
    // Atributos para la clase Conexión.
    protected Connection conexion;
    protected PreparedStatement comando;
    private String host="localhost";
    private String puerto="3306";
    private String bdd="ESTUDIANTE_EDD";
    private String usuario="tes_gamer12";
    private String clave="12.18.2022.2003.02.14";
    
// Método conectar
    protected Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + bdd, usuario, clave);
            //JOptionPane.showMessageDialog(null, "CONECTADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION " + e.getMessage());
            conexion = null;
        }
        return conexion;
    }

// Método cerrar conexión
    protected void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión");
        }
    }

}
