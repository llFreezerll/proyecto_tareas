<%@include file="Header.jsp"%>


<body>

<h1>Padres</h1>

<table class="table table-hover table-bordered">

  <tr>
    <th>Id</th>
    <th>Documento padre</th>
    <th>Nombre Padre</th>
    <th>Apellido Padre</th>
    <th>Correo electronico</th>
    <th>Documento Estudiante</th>
    <th>Nombre Estudiante</th>
    <th>Apellido Estudiante</th>
    <th>Correo electronico Estudiante</th>
    <th>Curso</th>
    <th>Grupo</th>
  </tr>


  <c:forEach var="U" items="${PA}">
    <tr>

    <td>${U.getIdPadre()}</td>
    <td>${U.getUsers().documento}</td>
    <td>${U.getUsers().nombre}</td>
    <td>${U.getUsers().apellido}</td>
    <td>${U.getUsers().correElectronico}</td>
      <td>${U.getEstudiantes().getEstudiante().documento}</td>
      <td>${U.getEstudiantes().getEstudiante().nombre}</td>
      <td>${U.getEstudiantes().getEstudiante().apellido}</td>
      <td>${U.getEstudiantes().getEstudiante().correElectronico}</td>
      <td>${U.getEstudiantes().getCurso().nombreCurso}</td>
      <td>${U.getEstudiantes().getCurso().grupo}</td>

      <c:if test="${users.getrol().nombreRol=='Administrador'}">
        <td>
          <a rol="Button" class="" href="UsuarioController?accion=Buscar&id=${U.getIdUsuario()}"> Editar Rol</a>
        </td>
        <td>
          <a rol="Button" class="" href="UsuarioController?accion=Eliminar&id=${U.getIdUsuario()}"> Borrar Usuario</a>
        </td>


       </c:if>
  </tr>
  </c:forEach>



</table>
</body>


<%@include file="Footer.jsp"%>
