<%@include file="Header2.jsp"%>

<body>
  <!-- LISTAR USUARIOS -->
<div class="" style="margin: 20px">
  <h1>Usuarios</h1>


  <a href="UsuarioController?accion=reporteUsuario" target="_blank" class="btn btn-primary" role="button">Generar Reporte</a>

  <div>
    <form style="
    width: max-content;
    padding: 0 0 20px 10px;
        ">
      <label for="myInput" class="form-label"></label>
      <input type="text" id="myInput" class="form-control" aria-describedby="passwordHelpBlock" onkeyup="myFunction()">
      <div id="passwordHelpBlock" class="form-text">
        Ingrese el documento del usuario que desea buscar.
      </div>
    </form>
  </div>

  <table class="table table-hover table-bordered" style="margin: 10px" id="myTable">

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
            <a rol="Button" class="" href="ProfesorController?accion=Buscar&id=${U.getIdUsuario()}">Crear Profesor</a>
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




<%@include file="Footer2.jsp"%>