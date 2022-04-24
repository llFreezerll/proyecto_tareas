<%@include file="Header2.jsp"%>


<body>


<div style="
     width: 100%;
     min-height: 50vh;
     display: -webkit-box;
     display: -webkit-flex;
     display: -moz-box;
     display: -ms-flexbox;
     display: flex;
     flex-wrap: wrap;
     justify-content: center;
     align-items: center;
     padding: 15px;">

  <form method="post" action="UsuarioController?accion=Editar" >

    <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
      <div class="card-header" style="color: #FFFFFF">
        Editar Usuario
      </div>
      <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
        <h5 class="card-title">Esta Editanto el Usuario ${User.nombre} ${User.apellido}</h5>

        <input type="text" name="idUsuario" value="${User.idUsuario}" hidden/>

        <label for="Documento" class="card-text" >Documento</label>
        <input class="card-text" type="text" name="Documento" id="Documento" value="${User.documento}">

        <label for="Nombre" class="card-text" >Nombre</label>
        <input class="card-text" type="text" name="Nombre" id="Nombre" value="${User.nombre}">

        <label for="Apellido" class="card-text" >Apellido</label>
        <input class="card-text" type="text" name="Apellido" id="Apellido" value="${User.apellido}">

        <label for="Usuario" class="card-text" >Usuario</label>
        <input class="card-text" type="text" name="Usuario" id="Usuario" value="${User.usuario}">

        <label for="CorreoElectronico" class="card-text" >Correo electronico</label>
        <input class="card-text" type="text" name="CorreoElectronico" id="CorreoElectronico" value="${User.correElectronico}">

          <label>Rol</label>
          <select class="" name="RolUsu">
            <option>Seleccione Usuario</option>
            <c:forEach var="rol" items="${Roles}">
              <option value="${rol.idRol}"
                      <c:if test="${rol.idRol==User.rol.idRol}">
                        selected </c:if>
              >${rol.nombreRol}</option>
            </c:forEach>
          </select>

        <div hidden>
          <label for="Estado" >Estado</label>
          <input type="checkbox" name="Estado" id="Estado" checked>
        </div>

        <a style="padding: 3%">
          <button type="submit" class="btn btn-primary"> Editar Usuario </button></a>
        <div>
          <a class="btn btn-primary" href="UsuarioController?accion=listar"> Cancelar </a>
        </div>

      </div>

    </div>

  </form>
</div>


<%@include file="Footer2.jsp"%>
