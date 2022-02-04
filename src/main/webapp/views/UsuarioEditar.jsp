<%@include file="Header.jsp"%>


<body>

<form method="post" action="UsuarioController?accion=Editar">

  <input type="text" name="idUsuario" value="${User.idUsuario}"/>


  <div>
    <label for="Documento" >Documento</label>
    <input type="text" name="Documento" id="Documento" value="${User.documento}">
  </div>

  <div>
    <label for="Nombre" >Nombre</label>
    <input type="text" name="Nombre" id="Nombre" value="${User.nombre}">
  </div>

  <div>
    <label for="Apellido" >Apellido</label>
    <input type="text" name="Apellido" id="Apellido" value="${User.apellido}">
  </div>

  <div>
    <label for="Usuario" >Usuario</label>
    <input type="text" name="Usuario" id="Usuario" value="${User.usuario}">
  </div>

  <div>
    <label for="Contrasena" >Contraseña</label>
    <input type="text" name="Contrasena" id="Contrasena" value="${User.contrasena}">
  </div>

  <div>
    <label for="CorreoElectronico" >Correo Electronico</label>
    <input type="text" name="CorreoElectronico" id="CorreoElectronico" value="${User.correElectronico}">
  </div>

  <div>
    <label>Rol</label>
    <select class="" name="RolUsu">
      <option>Seleccione Usuario</option>
      <c:forEach var="rol" items="${Roles}">
        <option value="${rol.idRol}"
        <c:if test="${rol.idRol==User.rol.idRol}">
          selected </c:if>
        >${rol.nombreRol}</option>
      </c:forEach>
    </select>
  </div>

  <div>
    <label for="Estado" >Estado</label>
    <input type="checkbox" name="Estado" id="Estado">
  </div>

  <button type="submit"> Editar </button>


</form>

</body>


<%@include file="Footer.jsp"%>
