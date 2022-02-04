<%@include file="Header.jsp"%>


<body>

<div class="estilo" align="center" style="margin-top: 30px">
  <div class="card border-success mb-3" style="max-width: 18rem;">
      <div class="card-header"><center> Agregar Curso </center></div>
        <div style="width: 80%;" >
          <center>
              <form class="form-floating" method="post" action="CursoController?accion=Agregar">
                <div class="row g-3" style="padding-left: 60px;">
                    <div class="col">
                        <label for="Curso" class="form-label">Curso</label>
                        <input type="text" name="Curso" class="form-control" id="Curso">
                    </div>
                  <div class="col" style="padding-bottom: 7px;">
                    <label for="Grupo" class="form-label">Grupo</label>
                    <input type="text" name="Grupo" class="form-control" id="Grupo">
                  </div>
                </div>
                <div style="padding-left: 55px; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success"> Agregar </button>
                    <a href="RolController?accion=listarRoles" class="btn btn-warning"> Cancelar </a>
                </div>
            </form>
          </center>
        </div>
  </div>
</div>


</body>


<%@include file="Footer.jsp"%>