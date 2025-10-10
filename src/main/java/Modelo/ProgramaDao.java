/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author manja
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProgramaDao {

    // Declaración de variables globales para usarlas en EstudianteDao
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // creamos un nuevo metodo que nos permita listar todos los estudiantes registrados en la tabla Estudiantes de la base de datos
    public ArrayList<Programa> ListarTodosProgramas() {
        ArrayList<Programa> programa = new ArrayList<>();
        try {
            conn = ConexionDao.ObtenerConexion();
            String sql = "SELECT * FROM programas";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            // usamos un ciclo
            while (rs.next()) {
                Programa pg = new Programa();
                pg.setId_programa(rs.getInt("id_progrma"));
                pg.setNombre(rs.getString("nombre"));
                pg.setDescripcion(rs.getString("descripcion"));
                programa.add(pg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return programa;
    }
}
