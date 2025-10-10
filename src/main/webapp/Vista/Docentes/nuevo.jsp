<%-- 
    Document   : nuevo
    Created on : 3/10/2025, 10:35:50 a. m.
    Author     : manja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body style="background:#FFDEAD; ">
        <div class="container" >
            <div class="card mt-4">

                <div class="card-body">
                    <h2 class="mt-3">${docentes.id==0 ? "Nuevo":"Editar"} Docente</h2>
                    <hr/>
                    <form action="DocenteController" method="post">
                        <div class="mb-3">
                            <label>Nombre</label>
                            <input type="text" id="nombre" name="nombre" value="${docentes.nombre}"  class="form-control" placeholder="Digite el nombre estudiante" required="">
                        </div>
                        <div class="mb-3">
                            <label>Apellido</label>
                            <input type="text" id="apellido" name="apellido" value="${docentes.apellido}"  class="form-control" placeholder="Digite el apellido del estudiante" required="">
                        </div>
                        <div class="mb-3">
                            <label>Correo Electronico</label>
                            <input type="text" id="correo" name="correo" value="${docentes.correo}" class="form-control" placeholder="Digite el correo electronico" required="">
                        </div>
                        <div class="mb-3">
                            <label>Documento</label>
                            <input type="text" id="documento" name="documento" value="${docentes.documento}" class="form-control" placeholder="Digite el numero de documento" required="">
                        </div>
                        <div class="mb-3">
                            <label>Genero</label>
                            <select id ="genero" name="genero" required aria-label="Seleccionar genero" class="form-control" value="${docentes.genero}">
                                <option value="Femenino">Femenino</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Otro">Otro</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label>Especialidad</label>
                            <input type="text" id="especialidad" name="especialidad" value="${docentes.especialidad}" class="form-control" placeholder="Digite el correo electronico" required="">
                        </div>

                        <div class="mb-3">
                            <input type="hidden" name="id" value="${docentes != null ? docentes.id : 0}">
                            <input type="hidden" name ="accion" value="guardar">
                            <button class="btn btn-primary btn-block">
                                <i class="fa-solid fa-floppy-disk"></i> Guardar
                            </button>
                            <a href="DocenteController?accion=listar" class="btn btn-danger">
                                <i class="fa-solid fa-arrow-left"></i> Volver atras
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/Public/js/fontawesome.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Public/js/solid.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Public/js/brands.min.js" type="text/javascript"></script>
    </body>
</html>
