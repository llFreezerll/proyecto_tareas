<%@include file="Header2.jsp"%>


<body>
<div style="margin: 20px">
<h1>Estudiantes</h1>

<table class="table table-hover table-bordered">

  <tr>
    <th>Id</th>
    <th>Documento</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Correo Electronico</th>
    <th>Curso</th>
    <th>Grupo</th>
  </tr>

  <c:forEach var="E" items="${Estudiantes}">

  <tr>

    <td>${E.getIdEstudiante()}</td>
    <td>${E.getEstudiante().documento}</td>
    <td>${E.getEstudiante().nombre}</td>
    <td>${E.getEstudiante().apellido}</td>
    <td>${E.getEstudiante().correElectronico}</td>
    <td>${E.getCurso().nombreCurso}</td>
    <td>${E.getCurso().grupo}</td>
    <c:if test="${users.getrol().nombreRol=='Administrador'}">
    <td>
      <a rol="Button" class="" href="EstudiantesController?accion=Buscar&id=${E.getIdEstudiante()}"> Editar Rol</a>
    </td>
    <td>
      <a rol="Button" class="" href="EstudiantesController?accion=Eliminar&id=${E.getIdEstudiante()}"> Borrar Usuario</a>
    </td>
    </c:if>


  </tr>

  </c:forEach>

</div>

</body>


<%@include file="Footer2.jsp"%>
