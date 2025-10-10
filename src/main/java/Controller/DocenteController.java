/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Modelo.Docente;
import Modelo.DocenteDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author manja
 */
public class DocenteController extends HttpServlet {
    private final DocenteDao docenteDao = new DocenteDao();
    // url 
    private final String ListarDocentes = "/Vista/Docentes/listar.jsp";
    private final String NuevosDocentes = "/Vista/Docentes/nuevo.jsp";
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
                ListarTodosLosDocentes(request, response);
                break;
            case "nuevo":
                NuevoDocente(request,response);
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

    private void ListarTodosLosDocentes(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setAttribute("docentes", docenteDao.ListarTodosDocentes());
        request.getRequestDispatcher(ListarDocentes).forward(request, response);
    }

    private void NuevoDocente(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException { 
         request.setAttribute("docentes", new Docente());
         request.getRequestDispatcher(NuevosDocentes).forward(request, response);
    }

    private void Guardar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Docente dc = new Docente();
        dc.setId(Integer.parseInt(request.getParameter("id")));
        dc.setNombre(request.getParameter("nombre"));
        dc.setApellido(request.getParameter("apellido"));
        dc.setCorreo(request.getParameter("correo"));
        dc.setDocumento(request.getParameter("documento"));
        dc.setGenero(request.getParameter("genero"));
        dc.setEspecialidad(request.getParameter("especialidad"));
        // variable local de tipo entero
        int result;
        // realizamos una validación en la cual si esl Id == 0 entonces registramos a nuevo docente
        if(dc.getId()==0){
            // en caso contrario si el Id es diferentes de 0 quiere decir que voy a editar la información del docente
            result = docenteDao.RegistrarNuevoDocente(dc);
        }else{
            result = docenteDao.EditarDocente(dc);
        }
        if(result>0){
            request.getSession().setAttribute("success", "Se ha guardado un nuevo registro docente :)");
            response.sendRedirect("DocenteController?accion=listar");
        }else{
            request.setAttribute("docentes", dc);
            request.getSession().setAttribute("error", "No se pudo Guarda nuevo registro :( ");
            request.getRequestDispatcher(NuevosDocentes).forward(request, response);
        }
        
    }

    private void Editar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        // para editar cualquier registro de estudiante debemos tener su Id osea su identificador
        int id = Integer.parseInt(request.getParameter("id"));
        Docente dc = docenteDao.BuscarDocentePorId(id);
        // creamos una validación mediante una condicional
        if(dc !=null){
            request.setAttribute("docentes", dc);
            request.getRequestDispatcher(NuevosDocentes).forward(request, response);
        }else{
            request.getSession().setAttribute("error", "No se encuentra el docente con ID" + id);
            response.sendRedirect("DocenteController?accion=listar");
        }
    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        // eliminar estudiante del registro de la tabla estudiante
        int id = Integer.parseInt(request.getParameter("id"));
        int result = docenteDao.EliminarRegistroDocente(id);
        // validamos a traves de una condicional
        if(result > 0){
            request.getSession().setAttribute("success", "El registro del docente con Id  " + " " + id+ " eliminado");
        }else{
            request.getSession().setAttribute("error", "No se pudo eliminar el registro del docente :(");
        }
        response.sendRedirect("DocenteController?accion=listar");
    }

}
