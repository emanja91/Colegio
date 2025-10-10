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

public class MateriaDao {

    //Declaración de variable globales para usarlas en MateriaDao
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    //vamos a crear un metodo que nos permita listar las materias
    public ArrayList<Materia> ListarTodasLasMaterias() {
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            conn = ConexionDao.ObtenerConexion();
            String sql = "SELECT * FROM materia";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            // usamos un ciclo para recorrer y poder mostrar la información de cada una de las materias 
            while (rs.next()) {
                Materia mt = new Materia();
                mt.setId_materia(rs.getInt("id_materia"));
                mt.setNombre(rs.getString("nombre"));
                mt.setCreditos(rs.getInt("creditos"));
                mt.setId_programa(rs.getInt("id_programa"));
                mt.setId_docente(rs.getInt("id_docente"));
                materias.add(mt);
            }
        } catch (Exception e) {

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
        return materias;

    }
    // creamos un metodo para registrar la información de las materias

}
