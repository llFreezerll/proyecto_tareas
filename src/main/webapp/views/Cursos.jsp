<%@include file="Header2.jsp"%>


<body>
<div style="margin: 20px">
<h1>Cursos</h1>

  <div>
    <form style="
    width: max-content;
    padding: 0 0 20px 10px;
        ">
      <label for="myInput" class="form-label"></label>
      <input type="text" id="myInput" class="form-control" aria-describedby="passwordHelpBlock" onkeyup="myFunction()">
      <div id="passwordHelpBlock" class="form-text">
        Ingrese el Rol que desea buscar.
      </div>
    </form>
  </div>

<table class="table table-hover table-bordered" id="myTable">

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
      <td>
        <a rol="button"
           class="btn btn-warning"
           href="CursoController?accion=Buscar&id=${C.getIdCurso()}">
          <i class="bi bi-pencil"></i>
        </a>

        <a rol="button"
           class="btn btn-danger"
           onclick="borrar(event,${C.getIdCurso()},'Curso')">
          <i class="bi bi-trash"></i>
        </a>

      </td>
    </c:if>


  </tr>

  </c:forEach>
</div>

<script>
  function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[1];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }
</script>
</body>


<%@include file="Footer2.jsp"%>