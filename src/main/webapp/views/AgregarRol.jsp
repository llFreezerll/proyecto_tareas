<%@include file="Header2.jsp"%>



<body>


<div>
    <label for="Estado" >Estado</label>
    <input type="checkbox" name="Estado" id="Estado" checked hidden>
</div>


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
            <form method="post" action="RolController?accion=AgregarRol" >

                <input type="text" class="" name="id" value="${RolEditado.idRol}" hidden/>

                <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
                    <div class="card-header" style="color: #FFFFFF">
                        Agregar Rol
                    </div>
                    <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
                        <h5 class="card-title">Esta Agregando un Rol nuevo</h5>
                        <input type="text" class="card-text" id="nombre" name="nombre" aria-describedby="emailHelp" value="Nombre de rol">
                        <a style="padding: 3%">
                            <button type="submit" class="btn btn-primary"> Agregar rol </button></a>
                        <div>
                        <a class="btn btn-primary" href="RolController?accion=listarRoles"> Cancelar </a>
                        </div>

                    </div>

                </div>

            </form>

        </div>
    </div>
</div>

</body>



<%@include file="Footer2.jsp"%>