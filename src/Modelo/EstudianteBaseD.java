package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EstudianteBaseD extends Conexion {

    public void guardarEstudiante(Estudiante guardarEstudiante) {
        conexion = conectar();
        try {
            //INSERT INTO para guardar info en la base de datos
            comando = conexion.prepareStatement("INSERT INTO ESTUDIANTE VALUES(null,?,?,?,?) ");
            comando.setString(1, guardarEstudiante.getCedula());
            comando.setString(2, guardarEstudiante.getNombre());
            comando.setString(3, guardarEstudiante.getApellido());
            comando.setFloat(4, guardarEstudiante.getNota());
            comando.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos del estudiante guardado correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar" + ex.toString());

        }
    }

    public DefaultTableModel mejorEstudiante(String cedula) {
        DefaultTableModel tablas = new DefaultTableModel();
        ResultSet rs;
        try {
            conexion = conectar();
            comando = conexion.prepareStatement("SELECT * FROM ESTUDIANTE ORDER BY NOTA DESC LIMIT 25");

            rs = comando.executeQuery();
            tablas.addColumn("IDESTUDIANTE");
            tablas.addColumn("CEDULA");
            tablas.addColumn("NOMBRE");
            tablas.addColumn("APELLIDOS");
            tablas.addColumn("NOTA");
            tablas.setRowCount(25);
            int fila = 0;
            while (rs.next()) {
                tablas.setValueAt(rs.getString(1), fila, 0);
                tablas.setValueAt(rs.getString(2), fila, 1);
                tablas.setValueAt(rs.getString(3), fila, 2);
                tablas.setValueAt(rs.getString(4), fila, 3);
                tablas.setValueAt(rs.getString(5), fila, 4);
                fila = fila + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablas;
    }

    public DefaultTableModel mejor(String cedula) {
        DefaultTableModel tablas = new DefaultTableModel();
        ResultSet rs;
        try {
            conexion = conectar();
            comando = conexion.prepareStatement("SELECT * FROM estudiante ORDER BY nota DESC LIMIT 1;");

            rs = comando.executeQuery();
            tablas.addColumn("IDESTUDIANTE");
            tablas.addColumn("CEDULA");
            tablas.addColumn("NOMBRE");
            tablas.addColumn("APELLIDOS");
            tablas.addColumn("NOTA");
            tablas.setRowCount(1);
            int fila = 0;
            while (rs.next()) {
                tablas.setValueAt(rs.getString(1), fila, 0);
                tablas.setValueAt(rs.getString(2), fila, 1);
                tablas.setValueAt(rs.getString(3), fila, 2);
                tablas.setValueAt(rs.getString(4), fila, 3);
                tablas.setValueAt(rs.getString(5), fila, 4);
                fila = fila + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablas;
    }

    public DefaultTableModel peor(String cedula) {
        DefaultTableModel tablas = new DefaultTableModel();
        ResultSet rs;
        try {
            conexion = conectar();
            comando = conexion.prepareStatement("SELECT * FROM estudiante ORDER BY nota asc LIMIT 1;");

            rs = comando.executeQuery();
            tablas.addColumn("IDESTUDIANTE");
            tablas.addColumn("CEDULA");
            tablas.addColumn("NOMBRE");
            tablas.addColumn("APELLIDOS");
            tablas.addColumn("NOTA");
            tablas.setRowCount(1);
            int fila = 0;
            while (rs.next()) {
                tablas.setValueAt(rs.getString(1), fila, 0);
                tablas.setValueAt(rs.getString(2), fila, 1);
                tablas.setValueAt(rs.getString(3), fila, 2);
                tablas.setValueAt(rs.getString(4), fila, 3);
                tablas.setValueAt(rs.getString(5), fila, 4);
                fila = fila + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablas;
    }


}
