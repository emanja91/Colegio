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

public class EstudianteDao {

    // Declaración de variables globales para usarlas en EstudianteDao
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // creamos un nuevo metodo que nos permita listar todos los estudiantes registrados en la tabla Estudiantes de la base de datos
    public ArrayList<Estudiante> ListarTodosEstudiantes() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            conn = ConexionDao.ObtenerConexion();
            String sql = "SELECT * FROM estudiantes";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            // usamos un ciclo
            while (rs.next()) {
                Estudiante std = new Estudiante();
                std.setId(rs.getInt("idEstudiante"));
                std.setNombre(rs.getString("nombreEstudiante"));
                std.setApellido(rs.getString("apellidoEstudiante"));
                std.setTelefono(rs.getString("telefonoEstudiante"));
                std.setDireccion(rs.getString("DireccionEstudiante"));
                std.setCorreo(rs.getString("CorreoEstudiante"));
                std.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate().toString());
                std.setGenero(rs.getString("Genero"));
                estudiantes.add(std);
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
        return estudiantes;
    }
    // creamos un metodo que nos permita registrar la información del estudiante en la tabla estudiantes

    public int RegistrarNuevoEstudiante(Estudiante std) {
        int result = 0;
        try {
            conn = ConexionDao.ObtenerConexion();
            String sql = "INSERT INTO estudiantes(nombreEstudiante,apellidoEstudiante,telefonoEstudiante,DireccionEstudiante,CorreoEstudiante,FechaNacimiento,Genero)VALUES(?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, std.getNombre());
            stmt.setString(2, std.getApellido());
            stmt.setString(3, std.getTelefono());
            stmt.setString(4, std.getDireccion());
            stmt.setString(5, std.getCorreo());
            stmt.setString(6, std.getFechaNacimiento());
            stmt.setString(7, std.getGenero());
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

    public int EditarEstudiante(Estudiante std) {
        int result = 0;
        try {
            conn = ConexionDao.ObtenerConexion();
            // creamos una consulta para actualizar los datos del estudiante
            String sql = "UPDATE estudiantes SET nombreEstudiante =?, apellidoEstudiante=?,telefonoEstudiante=?,DireccionEstudiante=?,CorreoEstudiante=?,FechaNacimiento=?,Genero=? WHERE idEstudiante=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, std.getNombre());
            stmt.setString(2, std.getApellido());
            stmt.setString(3, std.getTelefono());
            stmt.setString(4, std.getDireccion());
            stmt.setString(5, std.getCorreo());
            stmt.setString(6, std.getFechaNacimiento());
            stmt.setString(7,std.getGenero());
            stmt.setInt(8, std.getId());
            // ejecutamos la consulta si se inserto correctamente nos retona un valor mayor a 0
            result = stmt.executeUpdate();
        } catch (Exception e) {
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
    // creamos un metodo que nos permita buscar la información de un estudiante por medio del Id 
    public Estudiante BuscarEstudiantePorId(int id){
        // lo inicializamos en vacio
        Estudiante std = null;
        try{
            conn = ConexionDao.ObtenerConexion();
            // realizamos la consulta sql y filtramos por medio del idEstudiante
            String sql = "SELECT * FROM estudiantes WHERE idEstudiante=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            //ejecutamos consulta 
            rs = stmt.executeQuery();
            // usamos una condicional para ayudarnos a recorrer
            if(rs.next()){
                std = new Estudiante();
                std.setId(rs.getInt("idEstudiante"));
                std.setNombre(rs.getString("nombreEstudiante"));
                std.setApellido(rs.getString("apellidoEstudiante"));
                std.setTelefono(rs.getString("telefonoEstudiante"));
                std.setDireccion(rs.getString("DireccionEstudiante"));
                std.setCorreo(rs.getString("CorreoEstudiante"));
                std.setFechaNacimiento(rs.getString("FechaNacimiento"));
                std.setGenero(rs.getString("Genero"));
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
        return std;
    }
    
 // creamos un nuevo metodo el cual nos va permitir eliminar un usuario del registro de base de datos
    public int EliminarRegistroEstudiante(int id){
        int result =0;
        try{
            conn = ConexionDao.ObtenerConexion();
            // creamos una consulta a la tabla estudiantes y filtramos por medio de Id
            String sql ="DELETE FROM estudiantes WHERE idEstudiante = ?";
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
