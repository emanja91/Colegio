/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Modelo.ProgramaDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author manja
 */
public class ProgramaController extends HttpServlet {
    private final ProgramaDao programaDao = new ProgramaDao();
    private final String ListarProgramas = "/Vista/Programas/listar_programas.jsp";
    private final String NuevoPrograma = "/Vista/Programas/nuevo.jsp";
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
        
        String action = request.getParameter("accion");
        switch (action) {
            case "listar":
                ListarTodosLosProgramas(request, response);
                break;
            case "nuevo":
                NuevoPrograma(request, response);
                break;
            case "guardar":
                Guardar(request, response);
                break;
            case "editar":
                Editar(request, response);
                break;
            case "eliminar":
                Eliminar(request, response);
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

    private void ListarTodosLosProgramas(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        request.setAttribute("programas", programaDao.ListarTodosProgramas());
        request.getRequestDispatcher(ListarProgramas).forward(request, response);
    }

    private void NuevoPrograma(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    }

    private void Guardar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    }

    private void Editar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    }

}
