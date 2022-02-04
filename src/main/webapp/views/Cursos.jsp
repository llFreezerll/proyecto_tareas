<%@include file="Header.jsp"%>


<body>

<h1>Cursos</h1>

<table class="table table-hover table-bordered">

  <tr>
    <th>Id</th>
    <th>Curso</th>
    <th>Grupo</th>
  </tr>

  <c:forEach var="C" items="${Cursos}">

  <tr>

    <td>${C.getIdCurso()}</td>
    <td>${C.getNombreCurso()}</td>
    <td>${C.getGrupo()}</td>

    <c:if test="${users.getrol().nombreRol=='Administrador'}">
    <td>
      <a rol="Button" class="" href="CursoController?accion=Buscar&id=${C.getIdCurso()}"> Editar Curso</a>
    </td>
    <td>
      <a rol="Button" class="" href="CursoController?accion=Eliminar&id=${C.getIdCurso()}"> Borrar Curso</a>
    </td>
    </c:if>


  </tr>

  </c:forEach>

</body>


<%@include file="Footer.jsp"%>