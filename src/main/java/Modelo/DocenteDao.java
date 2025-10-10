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

public class DocenteDao {
    // Declaración de variables globales para usarlas en EstudianteDao

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // creamos un nuevo metodo que nos permita listar todos los estudiantes registrados en la tabla Estudiantes de la base de datos
    public ArrayList<Docente> ListarTodosDocentes() {
        ArrayList<Docente> docentes = new ArrayList<>();
        try {
            conn = ConexionDao.ObtenerConexion();
            String sql = "SELECT * FROM docente";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            // usamos un ciclo
            while (rs.next()) {
                Docente dc = new Docente();
                dc.setId(rs.getInt("id_docente"));
                dc.setNombre(rs.getString("nombre"));
                dc.setApellido(rs.getString("apellido"));
                dc.setCorreo(rs.getString("correo"));
                dc.setDocumento(rs.getString("documento"));
                dc.setGenero(rs.getString("genero"));
                dc.setEspecialidad(rs.getString("especialidad"));
                docentes.add(dc);
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
        return docentes;
    }

    /*utilizamos la reutilización de código por ejemplo el codigo elaborado en EstudianteDao nos puede servir en DocenteDao*/
    // creamos un metodo para registrar la información del docente en la tabla docente
    public int RegistrarNuevoDocente(Docente dc) {
        int result = 0;
        try {
            conn = ConexionDao.ObtenerConexion();
            String sql = "INSERT INTO docente(nombre,apellido,correo,documento,genero,especialidad)VALUES(?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dc.getNombre());
            stmt.setString(2, dc.getApellido());
            stmt.setString(3, dc.getCorreo());
            stmt.setString(4, dc.getDocumento());
            stmt.setString(5, dc.getGenero());
            stmt.setString(6, dc.getEspecialidad());
            result = stmt.executeUpdate(); // si se inserto correctamente nos retorna un valor mayor a 0
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    // creamos un nuevo metodo que nos va poder permitir editar la información del estudiante

    public int EditarDocente(Docente dc) {
        int result = 0;
        try {
            conn = ConexionDao.ObtenerConexion();
            // creamos una consulta para actualizar los datos del estudiante
            String sql = "UPDATE docente SET nombre =?, apellido=?,correo=?,documento=?,genero=?,especialidad=? WHERE id_docente=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dc.getNombre());
            stmt.setString(2, dc.getApellido());
            stmt.setString(3, dc.getCorreo());
            stmt.setString(4, dc.getDocumento());
            stmt.setString(5, dc.getGenero());
            stmt.setString(6, dc.getEspecialidad());
            stmt.setInt(7, dc.getId());
            // ejecutamos la consulta si se inserto correctamente nos retona un valor mayor a 0
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    // creamos un metodo que nos permita buscar la información de un docente por medio del Id 
    public Docente BuscarDocentePorId(int id){
        // lo inicializamos en vacio
        Docente dc = null;
        try{
            conn = ConexionDao.ObtenerConexion();
            // realizamos la consulta sql y filtramos por medio del idEstudiante
            String sql = "SELECT * FROM docente WHERE id_docente=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            //ejecutamos consulta 
            rs = stmt.executeQuery();
            // usamos una condicional para ayudarnos a recorrer
            if(rs.next()){
                dc = new Docente();
                dc.setId(rs.getInt("id_docente"));
                dc.setNombre(rs.getString("nombre"));
                dc.setApellido(rs.getString("apellido"));
                dc.setCorreo(rs.getString("correo"));
                dc.setDocumento(rs.getString("documento"));
                dc.setGenero(rs.getString("genero"));
                dc.setEspecialidad(rs.getString("especialidad"));
            }
            
        }catch(Exception e ){
             e.printStackTrace();
        }finally{
            try{
                if(conn !=null){
                    conn.close();
                }
                if(rs !=null){
                    rs.close();
                }
                if(stmt !=null){
                    stmt.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return dc;
    }
    // creamos metodo para eliminar un registro de la tabla docente
      public int EliminarRegistroDocente(int id){
        int result =0;
        try{
            conn = ConexionDao.ObtenerConexion();
            // creamos una consulta a la tabla estudiantes y filtramos por medio de Id
            String sql ="DELETE FROM docente WHERE id_docente = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            result = stmt.executeUpdate();
        }catch(Exception e){
             e.printStackTrace();
        }finally{
            try{
                if(conn !=null){
                    conn.close();
                }
                
                if(stmt !=null){
                    stmt.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
         return result;
    }
}
