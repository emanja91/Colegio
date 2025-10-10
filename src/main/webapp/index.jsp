<%-- 
    Document   : index
    Created on : 2/10/2025, 1:39:04 p. m.
    Author     : manja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sistema Académico - SIA</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
        <style>
            body {
                background: linear-gradient(135deg, #74b9ff 0%, #0984e3 100%);
                min-height: 100vh;
                font-family: 'Arial', sans-serif;
            }

            .main-container {
                background: white;
                border-radius: 15px;
                box-shadow: 0 10px 30px rgba(0,0,0,0.2);
                margin: 30px auto;
                overflow: hidden;
                max-width: 900px;
            }

            .header {
                background: linear-gradient(135deg, #6c5ce7, #a29bfe);
                color: white;
                text-align: center;
                padding: 30px 20px;
            }

            .header h1 {
                font-size: 2.2rem;
                font-weight: bold;
                margin: 0;
            }

            .header p {
                margin: 10px 0 0 0;
                font-size: 1rem;
                opacity: 0.9;
            }

            .content {
                padding: 40px 30px;
            }

            .menu-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 20px;
                margin-bottom: 30px;
            }

            .menu-item {
                background: white;
                border: 2px solid #e9ecef;
                border-radius: 10px;
                padding: 25px;
                text-align: center;
                text-decoration: none;
                color: #333;
                transition: all 0.3s ease;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }

            .menu-item:hover {
                transform: translateY(-5px);
                box-shadow: 0 5px 20px rgba(0,0,0,0.15);
                text-decoration: none;
                color: #333;
                border-color: #74b9ff;
            }

            .menu-icon {
                font-size: 3rem;
                margin-bottom: 15px;
                display: block;
            }

            .icon-blue { color: #74b9ff; }
            .icon-green { color: #00b894; }
            .icon-orange { color: #fdcb6e; }
            .icon-red { color: #e84393; }
            .icon-purple { color: #6c5ce7; }

            .menu-title {
                font-size: 1.3rem;
                font-weight: bold;
                margin-bottom: 8px;
            }

            .menu-desc {
                font-size: 0.9rem;
                color: #666;
                line-height: 1.4;
            }

            .stats-box {
                background: #f8f9fa;
                border-radius: 10px;
                padding: 20px;
                text-align: center;
            }

            .stats-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(120px, 1fr));
                gap: 15px;
            }

            .stat-item {
                padding: 10px;
            }

            .stat-number {
                font-size: 1.8rem;
                font-weight: bold;
                color: #74b9ff;
                display: block;
            }

            .stat-label {
                font-size: 0.8rem;
                color: #666;
                margin-top: 5px;
            }

            @media (max-width: 768px) {
                .main-container {
                    margin: 20px;
                }
                
                .content {
                    padding: 30px 20px;
                }
                
                .menu-grid {
                    grid-template-columns: 1fr;
                }
                
                .header h1 {
                    font-size: 1.8rem;
                }
            }
        </style>
    </head>
    <body>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Información Academica SIA</title>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    </head>
    <body style="background: #9BCD9B;">
        <div class="container">
            <div class="main-container">
                <!-- Encabezado Simple -->
                <div class="header">
                    <h1>
                        <i class="fas fa-graduation-cap"></i>
                        Sistema Académico
                    </h1>
                    <p>Centro Educativo - Gestión Escolar</p>
                </div>

                <!-- Contenido Principal -->
                <div class="content">
                    <div class="menu-grid">
                        <!-- Estudiantes -->
                        <a href="EstudianteController?accion=listar" class="menu-item" target="_blank">
                            <i class="fas fa-users menu-icon icon-blue"></i>
                            <div class="menu-title">Estudiantes</div>
                            <div class="menu-desc">Ver y gestionar estudiantes</div>
                        </a>

                        <!-- Materias -->
                        <a href="MateriaController?accion=listar" class="menu-item" target="_blank">
                            <i class="fas fa-book menu-icon icon-green"></i>
                            <div class="menu-title">Materias</div>
                            <div class="menu-desc">Administrar materias</div>
                        </a>

                        <!-- Docentes -->
                        <a href="DocenteController?accion=listar" class="menu-item" target="_blank">
                            <i class="fas fa-chalkboard-teacher menu-icon icon-orange"></i>
                            <div class="menu-title">Docentes</div>
                            <div class="menu-desc">Gestión de profesores</div>
                        </a>

                        <!-- Notas -->
                        <a href="#" class="menu-item">
                            <i class="fas fa-chart-line menu-icon icon-red"></i>
                            <div class="menu-title">Notas</div>
                            <div class="menu-desc">Calificaciones y reportes</div>
                        </a>

                        <!-- Programas -->
                        <a href="ProgramaController?accion=listar" class="menu-item" target="_blank">
                            <i class="fas fa-graduation-cap menu-icon icon-purple"></i>
                            <div class="menu-title">Programas</div>
                            <div class="menu-desc">Planes de estudio</div>
                        </a>
                    </div>

                    <!-- Estadísticas Simples -->
                    <div class="stats-box">
                        <h5 style="margin-bottom: 20px; color: #333;">
                            <i class="fas fa-chart-bar"></i>
                            Resumen del Sistema
                        </h5>
                        <div class="stats-grid">
                            <div class="stat-item">
                                <span class="stat-number">350</span>
                                <div class="stat-label">Estudiantes</div>
                            </div>
                            <div class="stat-item">
                                <span class="stat-number">25</span>
                                <div class="stat-label">Docentes</div>
                            </div>
                            <div class="stat-item">
                                <span class="stat-number">15</span>
                                <div class="stat-label">Materias</div>
                            </div>
                            <div class="stat-item">
                                <span class="stat-number">5</span>
                                <div class="stat-label">Programas</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Scripts simples -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
         <script>
            // Efectos simples para estudiantes
            document.addEventListener('DOMContentLoaded', function() {
                
                // Animación suave al cargar
                const container = document.querySelector('.main-container');
                container.style.opacity = '0';
                container.style.transform = 'translateY(20px)';
                
                setTimeout(() => {
                    container.style.transition = 'all 0.8s ease';
                    container.style.opacity = '1';
                    container.style.transform = 'translateY(0)';
                }, 200);

                // Contador simple para estadísticas
                const numbers = document.querySelectorAll('.stat-number');
                numbers.forEach(number => {
                    const target = parseInt(number.textContent);
                    let current = 0;
                    const increment = target / 30;
                    
                    const timer = setInterval(() => {
                        current += increment;
                        if (current >= target) {
                            number.textContent = target;
                            clearInterval(timer);
                        } else {
                            number.textContent = Math.floor(current);
                        }
                    }, 50);
                });
            });

            // Efecto hover simple
            document.querySelectorAll('.menu-item').forEach(item => {
                item.addEventListener('mouseenter', function() {
                    this.style.transform = 'translateY(-3px)';
                });
                
                item.addEventListener('mouseleave', function() {
                    this.style.transform = 'translateY(0)';
                });
            });
        </script>
       
    </body>
</html>
