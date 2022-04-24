<%@include file="Header2.jsp"%>


<body>
<div style="margin: 20px">
    <h1>Profesores</h1>

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
            <th>Documento</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo Electronico</th>
            <th>Curso</th>
            <th>Grupo</th>
        </tr>

        <c:forEach var="P" items="${Profesor}">

        <tr>

            <td>${P.getIdProfesor()}</td>
            <td>${P.getProfesor().documento}</td>
            <td>${P.getProfesor().nombre}</td>
            <td>${P.getProfesor().apellido}</td>
            <td>${P.getProfesor().correElectronico}</td>
            <td>${P.getCursoAsignado().nombreCurso}</td>
            <td>${P.getCursoAsignado().grupo}</td>
            <c:if test="${users.getrol().nombreRol=='Administrador'}">
                <td>

                    <a rol="button"
                       class="btn btn-warning"
                       href="ProfesorController?accion=BuscarEditar&id=${P.getIdProfesor()}">
                        <i class="bi bi-pencil"></i>
                    </a>

                    <a rol="button"
                       class="btn btn-danger"
                       onclick="borrar(event,${P.getIdProfesor()},'Profesor')">
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