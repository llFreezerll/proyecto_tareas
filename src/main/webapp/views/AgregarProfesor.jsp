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

  <form method="post" action="ProfesorController?accion=Agregar" >

    <input type="text" name="idUsuario" value="${User.idUsuario}" hidden/>


    <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
      <div class="card-header" style="color: #FFFFFF">
        Agregar Profesor
      </div>
      <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
        <h5 class="card-title">Esta Agregando un nuevo Profesor</h5>

        <label class="card-text" >Documento: ${User.documento}</label>

        <label class="card-text" >Nombre: ${User.nombre}</label>

        <label class="card-text" >Apellido: ${User.apellido}</label>

        <label class="card-text" >Correo electronico: ${User.correElectronico}</label>

        <div hidden>
          <input type="checkbox" name="Creado" id="Creado" checked>
        </div>

        <div>
          <label class="form-label">Curso</label>
          <select class="form-control" name="RolUsu">
            <option>Seleccione Curso</option>
            <c:forEach var="Cur" items="${Curso}">
              <option value="${Cur.idCurso}">${Cur.nombreCurso} ${Cur.grupo} </option>
            </c:forEach>
          </select>
        </div>

        <a style="padding: 3%">
          <button type="submit" class="btn btn-primary"> Agregar Profesor </button></a>
        <div>
          <a class="btn btn-primary" href="UsuarioController?accion=listar"> Cancelar </a>
        </div>

      </div>

    </div>

  </form>
</div>


</body>


<%@include file="Footer2.jsp"%>
