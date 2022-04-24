<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/MisEstilos.css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">


    <title>Abaco</title>
</head>

<div class="bg-top navbar-light">
    <div class="container">
        <div class="row no-gutters d-flex align-items-center align-items-stretch">
            <div class="col-md-4 d-flex align-items-center py-4">
                <a class="navbar-brand" href="./index.jsp"><img src="./images/LogoAbaco.png" width="180px" height="120%"></a>
            </div>
            <div class="col-lg-8 d-block">
                <div class="row d-flex">
                    <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
                        <div class="icon d-flex justify-content-center align-items-center"><span class="icon-paper-plane" style="color: #5d50c6"></span></div>
                        <div class="text">
                            <span>Email</span>
                            <span>abacomas123@gmail.com</span>
                        </div>
                    </div>
                    <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
                        <div class="icon d-flex justify-content-center align-items-center"><span class="icon-phone2" style="color: #5d50c6"></span></div>
                        <div class="text">
                            <span>Telefono</span>
                            <span>Llamanos:</span>
                            <span>+57 322 809 3984</span>
                        </div>
                    </div>
                    <%
                        response.setHeader("Pragma", "No-cache");
                        response.setHeader("Cache-control", "No-cache,no-store,must-revalidate");
                        response.setDateHeader("Expires",0);
                        if (session.getAttribute("users")!=null){
                    %>
                    <div class="col-md topper d-flex align-items-center justify-content-end">
                        <p class="mb-0" style="background-color: #6bb42f">
                            <a href="UsuarioController?accion=Logout" class="btn py-2 px-3 btn-primary d-flex align-items-center justify-content-center" style="color: #FFFFFF">
                                <span>Cerrar Sesion</span>
                            </a>
                        </p>
                    </div>
                    <%
                        }else {
                    %>
                    <div class="col-md topper d-flex align-items-center justify-content-end">
                        <p class="mb-0" style="background-color: #6bb42f">
                            <a href="UsuarioController?accion=VistaLogin" class="btn py-2 px-3 btn-primary d-flex align-items-center justify-content-center" style="color: #FFFFFF">
                                <span>Inicia sesión</span>
                            </a>
                        </p>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg" id="ftco-navbar" style="background-color: #440765">
    <div class="container d-flex align-items-center px-4">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>
        <form action="#" class="searchform order-lg-last">
            <div class="form-group d-flex">
                <input type="text" class="form-control pl-3" placeholder="Search">
                <button type="submit" placeholder="" class="form-control search"><span class="ion-ios-search"></span></button>
            </div>
        </form>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a href="./index.jsp" class="nav-link pl-0" style="color: #FFFFFF">Inicio</a></li>
                <li class="nav-item"><a href="#Modulos" class="nav-link" style="color: #FFFFFF">Módulos </a></li>
                <li class="nav-item"><a href="#Beneficios" class="nav-link" style="color: #FFFFFF">Beneficios</a></li>
                <li class="nav-item"><a href="#section-counter" class="nav-link" style="color: #FFFFFF">Abaco+</a></li>
                <li class="nav-item"><a href="#Contactanos" class="nav-link" style="color: #FFFFFF">Contacto</a></li>
            </ul>
        </div>
    </div>
</nav>