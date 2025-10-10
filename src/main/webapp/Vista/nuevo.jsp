<%-- 
    Document   : nuevo
    Created on : 2/10/2025, 2:46:04 p. m.
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
    </head>
    <body style="background:#FFDEAD; ">
        <div class="container" >
            <div class="card mt-4">

                <div class="card-body">
                    <h2 class="mt-3">${estudiantes.id==0 ? "Nuevo":"Editar"} Estudiantes</h2>
                    <hr/>
                    <form action="EstudianteController" method="post">
                        <div class="mb-3">
                            <label>Nombre</label>
                            <input type="text" id="nombre" name="nombre" value="${estudiantes.nombre}"  class="form-control" placeholder="Digite el nombre estudiante" required="">
                        </div>
                        <div class="mb-3">
                            <label>Apellido</label>
                            <input type="text" id="apellido" name="apellido" value="${estudiantes.apellido}"  class="form-control" placeholder="Digite el apellido del estudiante" required="">
                        </div>
                        <div class="mb-3">
                            <label>Telefono</label>
                            <input type="text" id="telefono" name="telefono" value="${estudiantes.telefono}" class="form-control" placeholder="Digite el numero telefono" required="">
                        </div>
                        <div class="mb-3">
                            <label>Direccion</label>
                            <input type="text" id="direccion" name="direccion" value="${estudiantes.direccion}" class="form-control" placeholder="Digite la direccion " required="">
                        </div>
                        <div class="mb-3">
                            <label>Correo Electronico</label>
                            <input type="text" id="corre" name="correo" value="${estudiantes.correo}" class="form-control" placeholder="Digite el correo electronico" required="">
                        </div>
                        <div class="mb-3">
                            <label>Fecha Nacimiento</label>
                            <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="${estudiantes.fechaNacimiento}" class="form-control"  required="">
                        </div>
                        <div class="mb-3">
                            <label>Genero</label>
                            <select id ="genero" name="genero" required aria-label="Seleccionar genero" class="form-control">
                                <option value="Femenino">Femenino</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Otro">Otro</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <input type="hidden" name="id" value="${estudiantes != null ? estudiantes.id : 0}">
                            <input type="hidden" name ="accion" value="guardar">
                            <button class="btn btn-primary btn-block">
                                <i class="fa-solid fa-floppy-disk"></i> Guardar
                            </button>
                            <a href="EstudianteController?accion=listar" class="btn btn-danger">
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
