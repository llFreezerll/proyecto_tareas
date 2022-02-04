<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/MisEstilos.css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    <title>Abaco</title>
</head>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "No-cache,no-store,must-revalidate");
    response.setDateHeader("Expires",0);
    if (session.getAttribute("users")!=null){
%>


<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <div class="container-fluid">
        <a class="navbar-brand" href="./index.jsp" ><img src="./images/LogoAbaco.png" width="100px" height="60%"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" aria-current="page" href="./index.jsp">Home</a>
                <a  <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if>  class="nav-link" href="RolController?accion=listarRoles" aria-current="page"> Roles </a>
                <a  <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if> class="nav-link"  href="RolController?accion=VistaAgregar" aria-current="page"> Agregar Roles </a>
                <a  <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if> class="nav-link"  href="UsuarioController?accion=listar" aria-current="page"> Usuario </a>
                <a  <c:if test="${users.getrol().nombreRol!='Administrador'}"> hidden </c:if> class="nav-link"  href="UsuarioController?accion=VistaAgregar" aria-current="page"> Agregar Usuarios </a>
                <a  <c:if test="${users.getrol().nombreRol !='Administrador'}"> hidden </c:if> class="nav-link" href="CursoController?accion=VistaAgregar" aria-current="page"> Agregar Curso </a>
                <c:if test="${users.getrol().nombreRol =='Administrador' || users.getrol().nombreRol =='Profesor'}">

                    <a class="nav-link" href="EstudiantesController?accion=listar" aria-current="page"> Estudiantes </a>
                    <a class="nav-link" href="PadresController?accion=listar" aria-current="page"> Padres </a>
                    <a class="nav-link" href="CursoController?accion=listar" aria-current="page"> Cursos</a>

                </c:if>
                <a class="nav-link" href="UsuarioController?accion=Logout" aria-current="page"> Cerrar Sesion </a>
            </div>
        </div>
    </div>
</nav>

<%
       }else {
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <div class="container-fluid">
        <a class="navbar-brand" href="./index.jsp" ><img src="./images/LogoAbaco.png" width="100px" height="60%"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup2" aria-controls="navbarNavAltMarkup2" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup2">
            <div class="navbar-nav">
                <a class="nav-link active" href="UsuarioController?accion=VistaLogin" aria-current="page"> Iniciar sesion </a>
            </div>
        </div>
    </div>
</nav>


<% } %>


