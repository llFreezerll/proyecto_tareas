<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page session="true" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="./css/EstiloMenuLateral.css">
    <link rel="stylesheet" href="./css/Formularios.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <script src="js/main.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/MisEstilos.css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">





</head>

<%-- nabvar --%>

    <%
       response.setHeader("Pragma", "No-cache");
       response.setHeader("Cache-control", "No-cache,no-store,must-revalidate");
       response.setDateHeader("Expires",0);
    %>


    <div class="sidebar close">
        <div class="logo-details">
            <div class="Logo">
                <img src="./images/LogoAbacoSolo.png" height="50">
            </div>
            <div class="Logo_Nombre">
                <span class="logo_name">Abaco+</span>
            </div>
        </div>
        <ul class="nav-links">
            <li  <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if> >
                <div class="iocn-link">
                    <a href="RolController?accion=listarRoles">
                        <i class='bx bx-group'></i>
                        <span class="link_name">Roles</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow' ></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="RolController?accion=listarRoles">Roles</a></li>
                    <li><a href="RolController?accion=VistaAgregar">Agregar Roles</a></li>
                </ul>
            </li>
            <li  <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if>>
                <div class="iocn-link">
                    <a href="UsuarioController?accion=listar">
                        <i class='bx bx-user'></i>
                        <span class="link_name">Usuarios</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow' ></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="UsuarioController?accion=listar">Usuarios</a></li>
                    <li><a href="UsuarioController?accion=VistaAgregar">Agregar Usuarios</a></li>
                </ul>
            </li>
            <li <c:if test="${users.getrol().nombreRol!='Administrador' && users.getrol().nombreRol!='Profesor'}"> hidden </c:if>>
                <div class="iocn-link">
                    <a href="CursoController?accion=listar">
                        <i class='bx bx-book-bookmark'></i>
                        <span class="link_name">Cursos</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow' ></i>
                </div>

                <ul class="sub-menu">
                    <li><a class="link_name" href="CursoController?accion=listar">Cursos</a></li>
                    <li><a href="CursoController?accion=VistaAgregar" <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if>>Agregar Curso</a></li>
                </ul>
            </li>

            <li <c:if test="${users.getrol().nombreRol!='Administrador' && users.getrol().nombreRol!='Profesor'}"> hidden </c:if>>
                <a href="PadresController?accion=listar">
                    <i class='bx bx-glasses-alt'></i>
                    <span class="link_name">Padres</span>
                </a>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="PadresController?accion=listar">Padres</a></li>
                </ul>
            </li>

            <li <c:if test="${users.getrol().nombreRol!='Administrador' && users.getrol().nombreRol!='Profesor'}"> hidden </c:if>>
                <a href="ProfesorController?accion=listar">
                    <i class='bi bi-book'></i>
                    <span class="link_name">Profesores</span>
                </a>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="ProfesorController?accion=listar">Profesores</a></li>
                </ul>
            </li>

            <li <c:if test="${users.getrol().nombreRol!='Administrador' && users.getrol().nombreRol!='Profesor'}"> hidden </c:if>>
                <a href="EstudiantesController?accion=listar">
                    <i class='bx bxs-book-reader'></i>
                    <span class="link_name">Estudiantes</span>
                </a>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="EstudiantesController?accion=listar">Estudiantes</a></li>
                </ul>
            </li>


            <li>
                <div class="profile-details">
                    <div class="profile-content">
                        <!--<img src="image/profile.jpg" alt="profileImg">-->
                    </div>
                    <div class="name-job">
                        <div class="profile_name">Depende el ususarioo</div>
                        <div class="job">Rol</div>
                    </div>
                    <i class='bx bx-log-out' ></i>
                </div>
            </li>
        </ul>
    </div>


<div class="home-section">
<div class="home-content">
    <i class='bx bx-menu' ></i>
    <span class="text"> ${users.getNombre()} ${users.getApellido()} </span>
</div>





