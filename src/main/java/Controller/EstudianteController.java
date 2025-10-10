/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Modelo.Estudiante;
import Modelo.EstudianteDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author manja
 */
public class EstudianteController extends HttpServlet {

    private final EstudianteDao estudianteDao = new EstudianteDao();
    private final String ListarEstudiantes = "/Vista/listar.jsp";
    private final String NuevosEstudiantes = "/Vista/nuevo.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Usamos un switch para definir las acciones realizar
        String action = request.getParameter("accion");
        switch (action) {
            case "listar":
                ListarTodosLosEstudiantes(request, response);
                break;
            case "nuevo":
                NuevoEstudiante(request,response);
                break;
            case "guardar":
                Guardar(request,response);
                break;
            case "editar":
                Editar(request,response);
                break;
            case "eliminar":
                Eliminar(request,response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida: " + action);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void ListarTodosLosEstudiantes(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setAttribute("estudiantes", estudianteDao.ListarTodosEstudiantes());
        request.getRequestDispatcher(ListarEstudiantes).forward(request, response);
    }

    private void NuevoEstudiante(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setAttribute("estudiantes", new Estudiante());
        request.getRequestDispatcher(NuevosEstudiantes).forward(request, response);
    }

    private void Guardar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Estudiante std = new Estudiante();
        /* validamos por el id si actualizar o va realizar una operación de nuevo registro de estudiante en la tabla estudiantes de la base de datos datos universidad*/
        std.setId(Integer.parseInt(request.getParameter("id")));
        std.setNombre(request.getParameter("nombre"));
        std.setApellido(request.getParameter("apellido"));
        std.setTelefono(request.getParameter("telefono"));
        std.setDireccion(request.getParameter("direccion"));
        std.setCorreo(request.getParameter("correo"));
        std.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        std.setGenero(request.getParameter("genero"));
        // declaramos una variable local de tipo entero
        int result;
        // realizamos una validación en lo cual si el Id == 0 entonces registrados a un nuevo estudiante
        if(std.getId() ==0){
            result = estudianteDao.RegistrarNuevoEstudiante(std);
        }else{
            // en caso contrario si el Id es diferentes de 0 quiere decir que voy a editar la información de un estudiante.
            result = estudianteDao.EditarEstudiante(std);
        }
        if(result >0){
            request.getSession().setAttribute("success", "se han guardado los datos satisfactoriamente :)");
            response.sendRedirect("EstudianteController?accion=listar");
        }else{
            request.setAttribute("estudiantes", std);
            request.getSession().setAttribute("error", "No se pudo guardar nuevo registro");
            request.getRequestDispatcher(NuevosEstudiantes).forward(request, response);
        }
        
    }

    private void Editar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        // para poder editar cualquier registro de estudiante debemos con su identificador unico osea su Id
        int id = Integer.parseInt(request.getParameter("id"));
        Estudiante std = estudianteDao.BuscarEstudiantePorId(id);
        
        // creamos una validación
        if(std !=null){
            request.setAttribute("estudiantes", std);
            request.getRequestDispatcher(NuevosEstudiantes).forward(request, response);
        }else{
            request.getSession().setAttribute("error", "No se encuentra el estudiante con ID" + id);
            response.sendRedirect("EstudianteController?accion=listar");
        }
    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        // eliminar estudiante del registro de la tabla estudiante
        int id = Integer.parseInt(request.getParameter("id"));
        int result = estudianteDao.EliminarRegistroEstudiante(id);
        // validamos a traves de una condicional
        if(result > 0){
            request.getSession().setAttribute("success", "El registro del estudiante ha sido " + " " + id+ " eliminado");
        }else{
            request.getSession().setAttribute("error", "No se pudo eliminar el registro del estudiante");
        }
        response.sendRedirect("EstudianteController?accion=listar");
    }

}
