<%@include file="Header.jsp"%>


<h1>Roles</h1>

<table class="table table-hover table-bordered">

    <tr>
        <th>Id</th>
        <th>Nombre</th>
    </tr>

    <c:forEach var="rol" items="${Roles}">

    <tr>

        <td>${rol.getIdRol()}</td>
        <td>${rol.getNombreRol()}</td>

        <td>
            <a rol="Button" class="" href="RolController?accion=BuscarRol&id=${rol.getIdRol()}"> Editar Rol</a>
        </td>
        <td>
            <a rol="Button" class="" href="RolController?accion=EliminarRol&id=${rol.getIdRol()}"> Borrar Rol</a>
        </td>


    </tr>

    </c:forEach>



<%@include file="Footer.jsp"%>