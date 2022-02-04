<%@include file="Header.jsp"%>


<body>

<form method="post" action="RolController?accion=AgregarRol">
    <div>
        <label for="nombre" >Nombre del Rol</label>
        <input type="text" name="nombre" id="nombre">
    </div>

    <button type="submit"> Agregar </button>
    <a href="RolController?accion=listarRoles"> Cancelar </a>


</form>

</body>


<%@include file="Footer.jsp"%>