<%@include file="Header2.jsp"%>

<div style="margin: 20px">
<h1>Roles</h1>

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
        <th>Nombre</th>
    </tr>

    <c:forEach var="rol" items="${Roles}">

    <tr>

        <td>${rol.getIdRol()}</td>
        <td>${rol.getNombreRol()}</td>


        <td>
            <a rol="button"
               class="btn btn-warning"
               href="RolController?accion=BuscarRol&id=${rol.getIdRol()}">
                <i class="bi bi-pencil"></i>
            </a>

            <a rol="button"
               class="btn btn-danger"
               onclick="borrar(event,${rol.getIdRol()},'Rol')">
                <i class="bi bi-trash"></i>
            </a>

        </td>



    </tr>

    </c:forEach>

    <tr class='noSearch hide'>

        <td colspan="5"></td>

    </tr>


</table>

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

</div>

<script src="js/main.js"></script>

<%@include file="Footer2.jsp"%>