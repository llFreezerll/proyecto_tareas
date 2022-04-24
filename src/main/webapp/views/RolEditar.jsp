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
<form method="post" action="RolController?accion=EditarRol" >

  <input type="text" class="" name="id" value="${RolEditado.idRol}" hidden/>

  <div class="card text-center bg-secondary" style="width: 30rem;align-items: center;display: flex;">
    <div class="card-header" style="color: #FFFFFF">
      Editar Rol
    </div>
    <div class="card-body bg-light mb-3" style="width: 25rem;display: grid;">
      <h5 class="card-title">Esta editando el Rol ${RolEditado.nombreRol}</h5>
      <input type="text" class="card-text" id="nombre" name="nombre" aria-describedby="emailHelp" value="${RolEditado.nombreRol}">
      <a style="padding: 3%">
      <button type="submit" class="btn btn-primary"> Editar rol </button></a>
      <a>
      <button type="submit" class="btn btn-primary"> Cancelar </button></a>

    </div>

  </div>

</form>

</div>
</div>
</div>

</body>


<%@include file="Footer2.jsp"%>