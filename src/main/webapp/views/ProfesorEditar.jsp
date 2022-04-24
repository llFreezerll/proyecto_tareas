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

    <form method="post" action="ProfesorController?accion=Editar" >

        <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
            <div class="card-header" style="color: #FFFFFF">
                Editar Profesor
            </div>
            <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
                <h5 class="card-title">Esta Editanto al Profesor ${User.nombre} ${User.apellido}</h5>

                <input name="idProfesor"  id="idProfesor" value="${Padre.idProfesor}" hidden>

                <label class="card-text" >Documento: ${User.documento} </label>

                <label class="card-text" >Nombre: ${User.nombre}</label>

                <label class="card-text" >Apellido: ${User.apellido}</label>

                <label for="CodigoCurso" class="card-text" >Codigo de Curso: </label>
                <input class="card-text" type="text" name="CodigoCurso" id="CodigoCurso" value="${Padre.FKCurso}">

                <a style="padding: 3%">
                    <button type="submit" class="btn btn-primary"> Editar Usuario </button></a>
                <div>
                    <a class="btn btn-primary" href="ProfesorController?accion=listar"> Cancelar </a>
                </div>

            </div>

        </div>

    </form>
</div>


<%@include file="Footer2.jsp"%>
