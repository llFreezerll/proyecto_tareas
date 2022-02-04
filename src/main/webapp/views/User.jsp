<%@include file="Header.jsp"%>


<body>

<h1>Usuarios</h1>

<a href="UsuarioController?accion=reporteUsuario" target="_blank" class="btn btn-primary" role="button">Generar Reporte</a>

<table class="table table-hover table-bordered">

  <tr>
    <th>Id</th>
    <th>Documento</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Usuario</th>
    <th>Correo Electronico</th>
    <th>Rol</th>
    <th>Estado</th>
  </tr>

  <c:forEach var="U" items="${Users}">

  <tr>

    <td>${U.getIdUsuario()}</td>
    <td>${U.getDocumento()}</td>
    <td>${U.getNombre()}</td>
    <td>${U.getApellido()}</td>
    <td>${U.getUsuario()}</td>
    <td>${U.getCorreElectronico()}</td>
    <td>${U.getrol().nombreRol}</td>

    <c:if test="${U.getestado() == true}">
      <td><span class="badge bg-success active">Usuario Activo</span></td>
    </c:if>
    <c:if test="${U.getestado() == false}">
      <td><span class="badge bg-danger active">Usuario Inactivo</span></td>
    </c:if>

    <td>
      <c:if test="${U.getestado() == true}">
        <a rol="button"
           class="btn btn-danger btn-sm"
           onclick="cambiare(event,${U.getIdUsuario()},${U.getestado()},'Usuario')">
          Inactivar
        </a>
      </c:if>
      <c:if test="${U.getestado() == false}">
        <a rol="button"
           class="btn btn-success btn-sm"
           onclick="cambiare(event,${U.getIdUsuario()},${U.getestado()},'Usuario')">
          Activar
        </a>
      </c:if>
    </td>

    <td>
      <a rol="button"
         class="btn btn-warning"
         href="UsuarioController?accion=Buscar&id=${U.getIdUsuario()}">
        <i class="bi bi-pencil"></i>
      </a>

      <a rol="button"
         class="btn btn-danger"
         onclick="borrar(event,${U.getIdUsuario()},'Usuario')">
        <i class="bi bi-trash"></i>
      </a>

    </td>


<c:if test="${U.getPerfilCreado()==false}">

    <c:if test="${U.getrol().nombreRol=='Estudiante'}">
    <td>
      <a rol="Button" class="" href="EstudiantesController?accion=Buscar&id=${U.getIdUsuario()}">Crear Estudiante</a>
    </td>
    </c:if>
    <c:if test="${U.getrol().nombreRol=='Profesor'}">
      <td>
        <a rol="Button" class="" href="EstudiantesController?accion=Buscar&id=${U.getIdUsuario()}">Crear Profesor</a>
      </td>
    </c:if>
    <c:if test="${U.getrol().nombreRol=='Padres'}">
      <td>
        <a rol="Button" class="" href="PadresController?accion=Buscar&id=${U.getIdUsuario()}">Crear Padre</a>
      </td>
    </c:if>
</c:if>


    </td>

  </tr>

  </c:forEach>

</body>


<%@include file="Footer.jsp"%>