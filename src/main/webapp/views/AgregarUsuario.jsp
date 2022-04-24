<%@include file="Header2.jsp"%>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>


<body>



<div style="
     width: 100%;
     min-height: 50vh;
     display: -webkit-box;
     display: -webkit-flex;
     display: -moz-box;
     display: -ms-flexbox;
     display: flex;
     flex-wrap: wrap;
     justify-content: center;
     align-items: center;
     padding: 15px;">

  <form method="post" action="UsuarioController?accion=Agregar" >

    <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
      <div class="card-header" style="color: #FFFFFF">
        Agregar Usuario
      </div>
      <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
        <h5 class="card-title">Esta Agregando un nuevo Usuario</h5>

        <label for="Documento" class="card-text" >Documento</label>
        <input class="card-text" type="text" name="Documento" id="Documento">

        <label for="Nombre" class="card-text" >Nombre</label>
        <input class="card-text" type="text" name="Nombre" id="Nombre">

        <label for="Apellido" class="card-text" >Apellido</label>
        <input class="card-text" type="text" name="Apellido" id="Apellido">

        <label for="Usuario" class="card-text" >Usuario</label>
        <input class="card-text" type="text" name="Usuario" id="Usuario">

        <label for="Contrasena" class="card-text" >Contraseña</label>
        <input class="card-text" type="text" name="Contrasena" id="Contrasena">

        <label for="CorreoElectronico" class="card-text" >Correo electronico</label>
        <input class="card-text" type="text" name="CorreoElectronico" id="CorreoElectronico">

        <label>Rol</label>
        <select class="" name="RolUsu">
          <option>Seleccione Usuario</option>
          <c:forEach var="rol" items="${Roles}">
            <option value="${rol.idRol}">${rol.nombreRol}</option>
          </c:forEach>
        </select>

        <div hidden>
          <input hidden type="checkbox" name="Perfil" id="Perfil" value="false">
          <div>
            <label for="Estado" >Estado</label>
            <input type="checkbox" name="Estado" id="Estado" value="true" checked>
          </div>
        </div>

        <a style="padding: 3%">
          <button type="submit" class="btn btn-primary"> Agregar Usuario </button></a>
        <div>
          <a class="btn btn-primary" href="UsuarioController?accion=listar"> Cancelar </a>
        </div>

      </div>

    </div>

  </form>
</div>

</body>


<%@include file="Footer2.jsp"%>
