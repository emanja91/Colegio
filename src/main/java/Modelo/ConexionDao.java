/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author manja
 */
public class ConexionDao {
    
    // Declaramos variables para la conexion con la base de datos;
    public static final String url = "jdbc:mysql://localhost:3306/centrounviersitario";
    public static final String username = "root";
    public static final String pass = "Sena2025..";

    // creamos una función para conectarnos a la base de datos
    public static Connection ObtenerConexion() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            System.out.println("error"+e.getMessage());
        }
        // retornamos conn que es conexion para poder acceder al metodo conexión
        return conn;
    }
    public static void main(String[] args){
       try {
           Connection test = ConexionDao.ObtenerConexion();
           if(test!=null){
               System.out.println("Conexión probada correctamente desde main.");
           }else{
               System.out.println("No se pudo establecer la conexión.");
           }
       } catch (ClassNotFoundException ex) {
           System.getLogger(ConexionDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
    }
}
