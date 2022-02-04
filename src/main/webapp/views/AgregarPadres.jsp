<%@include file="Header.jsp"%>


<body>

<form method="post" action="PadresController?accion=Agregar">

  <input type="text" name="idUsuario" value="${User.idUsuario}"/>
  <input type="text" name="idUsuario2"/>


  <div class="mb-3">
    <label for="Documento" class="form-label">Documento</label>
    <input type="text" name="Documento" id="Documento" class="form-control" value="${User.documento}">
  </div>

  <div class="mb-3">
    <label for="Nombre" class="form-label">Nombre</label>
    <input type="text" name="Nombre" id="Nombre" class="form-control" value="${User.nombre}">
  </div>

  <div class="mb-3">
    <label for="Apellido" class="form-label">Apellido</label>
    <input type="text" name="Apellido" id="Apellido" class="form-control" value="${User.apellido}">
  </div>

  <div class="mb-3">
    <label for="correo" class="form-label">Correo Electronico</label>
    <input type="text" name="correo" id="correo" class="form-control" value="${User.correElectronico}">
  </div>

  <div class="mb-3">
    <input type="checkbox" name="Creado" id="Creado" checked>
  </div>


  <button type="submit"> Crear Estudiante </button>
  <a href="PadresController?accion=listar"> Cancelar </a>

</form>

</body>


<%@include file="Footer.jsp"%>