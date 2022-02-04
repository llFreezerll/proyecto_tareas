<%@include file="Header.jsp"%>


<body>

<form method="post" action="RolController?accion=EditarRol">

  <input type="text" class="" name="id" value="${RolEditado.idRol}"/>

  <div>
    <label for="nombre" >Nombre del Rol</label>
    <input type="text" name="nombre" id="nombre" value="${RolEditado.nombreRol}"/>
  </div>

  <button type="submit"> Agregar </button>


</form>

</body>


<%@include file="Footer.jsp"%>