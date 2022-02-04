<%@include file="Header.jsp"%>


<body>

<form method="post" action="CursoController?accion=Editar">

  <input type="text" name="id" value="${Cur.idCurso}"/>


  <div>
    <label for="Curso" >Curso</label>
    <input type="text" name="Curso" id="Curso" value="${Cur.nombreCurso}">
  </div>

  <div>
    <label for="Grupo" >Nombre</label>
    <input type="text" name="Grupo" id="Grupo" value="${Cur.grupo}">
  </div>

  <button type="submit"> Editar </button>


</form>

</body>


<%@include file="Footer.jsp"%>