<%@include file="Header.jsp"%>


<body>

<form method="post" action="UsuarioController?accion=Agregar">

  <div>
    <label for="Documento" >Documento</label>
    <input type="text" name="Documento" id="Documento">
  </div>

  <div>
    <label for="Nombre" >Nombre</label>
    <input type="text" name="Nombre" id="Nombre">
  </div>

  <div>
    <label for="Apellido" >Apellido</label>
    <input type="text" name="Apellido" id="Apellido">
  </div>

  <div>
    <label for="Usuario" >Usuario</label>
    <input type="text" name="Usuario" id="Usuario">
  </div>

  <div>
    <label for="Contrasena" >Contraseña</label>
    <input type="text" name="Contrasena" id="Contrasena">
  </div>

  <div>
    <label for="CorreoElectronico" >Correo Electronico</label>
    <input type="text" name="CorreoElectronico" id="CorreoElectronico">
  </div>

  <div>
    <label>Rol</label>
        <select class="" name="RolUsu">
          <option>Seleccione Usuario</option>
            <c:forEach var="rol" items="${Roles}">
            <option value="${rol.idRol}">${rol.nombreRol}</option>
            </c:forEach>
        </select>
  </div>

  <div>
    <label for="Estado" >Estado</label>
    <input type="checkbox" name="Estado" id="Estado" checked>
  </div>

  <div>
    <input hidden type="checkbox" name="Perfil" id="Perfil" value="false">
  </div>
  <button type="submit"> Agregar </button>
  <a href="UsuarioController?accion=listar" > Cancelar </a>


</form>

</body>


<%@include file="Footer.jsp"%>
