<%@include file="Header2.jsp"%>


<body>
<div style="margin: 20px">
<div class="estilo" align="center" style="margin-top: 30px">
  <div class="card border-success mb-3" style="max-width: 18rem;">
    <div class="card-header"><center> Agregar Estudiante </center></div>
    <div style="width: 80%;" >
      <center>

        <form method="post" action="EstudiantesController?accion=Agregar">

          <input type="text" name="idUsuario" value="${User.idUsuario}" hidden/>
            <div style="padding-left: 60px">
              <div>
                <label class="form-label" >Nombre: ${User.nombre}</label>
              </div>

              <div>
                <label class="form-label" >Apellido: ${User.apellido}</label>
              </div>

              <div>
                <label class="form-label" >Correo: ${User.correElectronico}</label>
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
            </div>

          <div hidden>
            <input type="checkbox" name="Creado" id="Creado" checked>
          </div>

          <div style="padding-top: 10px; padding-left: 55px">
            <button type="submit" class="btn btn-success"> Crear Estudiante </button>
            <a href="EstudiantesController?accion=listar" class="btn btn-warning"> Cancelar </a>
          </div>

        </form>


      </center>
    </div>
  </div>
</div>
</div>
</body>


<%@include file="Footer2.jsp"%>
