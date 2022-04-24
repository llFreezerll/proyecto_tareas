<%@include file="Header2.jsp"%>


<body>

<div class="limiter">
    <div class="container-login100 " style="
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
        <div class="wrap-login100">
            <form method="post" action="CursoController?accion=Agregar" >

                <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
                    <div class="card-header" style="color: #FFFFFF">
                        Agregar Curso
                    </div>
                    <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
                        <h5 class="card-title">Esta agregando un nuevo curso</h5>
                        <label for="Curso" class="form-label">Curso</label>
                        <input type="text" name="Curso" class="form-control" id="Curso">
                        <label for="Grupo" class="form-label">Grupo</label>
                        <input type="text" name="Grupo" class="form-control" id="Grupo">
                        <a style="padding: 3%">
                            <button type="submit" class="btn btn-primary"> Agregar curso </button></a>
                        <div>
                            <a class="btn btn-primary" href="CursoController?accion=listar"> Cancelar </a>
                        </div>

                    </div>

                </div>

            </form>

        </div>
    </div>
</div>


</body>


<%@include file="Footer2.jsp"%>