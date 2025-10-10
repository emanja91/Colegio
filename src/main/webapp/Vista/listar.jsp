<%-- 
    Document   : listar
    Created on : 2/10/2025, 1:49:37 p. m.
    Author     : manja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Educativo Distrital de Barranquilla</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/Public/css/fontawesome.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/Public/css/solid.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/Public/css/regular.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/Public/css/brands.min.css" rel="stylesheet">
        <style>
            body {
                background: #FFDEAD;
            }
            .custom-container {
                background: #fff;
                border-radius: 18px;
                box-shadow: 0 4px 24px rgba(0,0,0,0.10);
                margin: 40px auto;
                padding: 32px 28px 28px 28px;
                max-width: 995px;
            }
            .custom-title {
                font-weight: 700;
                color: #2d2d2d;
                margin-bottom: 18px;
            }
            
        </style>
    </head>
    <body>

        <div class="custom-container">
            <h2 class="custom-title text-center">Centro Educativo de Barranquilla | Gestión de Estudiantes</h2>
            <hr/>
            <div class="d-flex justify-content-end mb-3">
                <a href="EstudianteController?accion=nuevo" class="btn btn-success btn-sm"> <i class="fa-solid fa-address-book"></i> Nuevo Estudiante</a>
            </div>
            <jsp:include page="../componentes/Mensajes.jsp" />
            <table class ="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Nombre Completo</th>
                        <th>Telefono</th>
                        <th>Direccion</th>
                        <th>Correo Electronico</th>
                        <th>Fecha Nacimiento</th>
                        <th>Genero</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                  
                    
                    <c:forEach items="${estudiantes}" var="item" >
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.nombre} ${item.apellido}</td>
                            <td>${item.telefono}</td>
                            <td>${item.direccion}</td>
                            <td>${item.correo}</td>
                            <td>${item.fechaNacimiento}</td>
                            <td>${item.genero}</td>
                            <td>
                                <div class="d-flex gap-2">
                                    <a href="EstudianteController?accion=editar&id=${item.id}" class="btn btn-warning btn-sm">
                                        <i class="fa-solid fa-pencil"></i>
                                    </a>
                                    <a href="EstudianteController?accion=eliminar&id=${item.id}" class="btn btn-danger btn-sm">
                                        <i class="fa-solid fa-trash"></i> 
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                     <c:if test="${estudiantes.size()==0}">
                              <tr>
                                  <td colspan="7"> No hay Registros</td>
                              </tr>
                          </c:if>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/Public/js/fontawesome.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Public/js/solid.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Public/js/brands.min.js" type="text/javascript"></script>
    </body>
</html>
