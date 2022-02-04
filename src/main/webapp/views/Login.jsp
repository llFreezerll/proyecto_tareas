<%--
  Created by IntelliJ IDEA.
  User: Carlos
  Date: 16/11/2021
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Abaco</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/MisEstilos.css">
  </head>

  <body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

  <div class="estilo" align="center" style="margin-top: 30px">

    <div class="card border-success mb-3 " style="max-width: 18rem;">
      <div class="card-header">Login</div>
      <div class="card-body text-success">

        <div style="width: 80%;">
          <form class="form-floating" method="post" action="UsuarioController?accion=Login">
            <div class="row g-3">
              <div class="col">
                <label for="User" >Usuario</label>
                <input class="form-control" type="text" name="User" id="User">
              </div>
              <div class="col">
                <label for="Pass" >Contraseña</label>
                <input class="form-control" type="Password" name="Pass" id="Pass">
              </div>

              <button type="submit" class="btn btn-success"> Iniciar Sesion </button>
              <a class="btn btn-warning" href="./index.jsp"> Cancelar </a>

            </div>
          </form>
      </div>
        <div class="card-footer bg-transparent border-success">
          <p>
            <%
              if(request.getParameter("msn")!=null){
                out.println(request.getParameter("msn"));
              }
            %>
          </p>
        </div>
    </div>

  </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

  </body>
</html>
