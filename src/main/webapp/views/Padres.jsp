<%@include file="Header2.jsp"%>


<body>
<div style="margin: 20px">
<h1>Padres</h1>

  <div>
    <form style="
    width: max-content;
    padding: 0 0 20px 10px;
        ">
      <label for="myInput" class="form-label"></label>
      <input type="text" id="myInput" class="form-control" aria-describedby="passwordHelpBlock" onkeyup="myFunction()">
      <div id="passwordHelpBlock" class="form-text">
        Ingrese el documento del padre que desea buscar.
      </div>
    </form>
  </div>

<table class="table table-hover table-bordered" id="myTable">

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
      <td> </td>
        <td>
          <a rol="button"
             class="btn btn-warning"
             href="PadresController?accion=BuscarEditar&id=${U.getIdPadre()}">
            <i class="bi bi-pencil"></i>
          </a>

          <a rol="button"
             class="btn btn-danger"
             onclick="borrar(event,${U.getIdPadre()},'Padres')">
            <i class="bi bi-trash"></i>
          </a>

        </td>

       </c:if>
  </tr>
  </c:forEach>



</table>

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
