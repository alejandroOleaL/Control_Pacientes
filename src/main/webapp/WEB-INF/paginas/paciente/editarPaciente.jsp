<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/76891679ca.js" crossorigin="anonymous"></script>
        <title>Editar Paciente</title>
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idPaciente=${paciente.idPaciente}"
              method="POST" class="was-validated">

            <!--Botones de Navegacion-->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Paciente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${paciente.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" name="apellido" required value="${paciente.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">email</label>
                                        <input type="email" class="form-control" name="email" required value="${paciente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="tel" class="form-control" name="telefono" required value="${paciente.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="edad">Edad</label>
                                        <input type="number" class="form-control" name="edad" required value="${paciente.edad}">
                                    </div>
                                    <div class="form-group">
                                        <label for="cita">Cita</label>
                                        <input type="datetime-local" class="form-control" name="cita" required value="${paciente.cita}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-success btn-block">
                            Modificar  <i class="fas fa-save"></i>
                        </button>
                    </div>
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idPaciente=${paciente.idPaciente}"
                           class="btn btn-danger btn-block">
                            Eliminar  <i class="fas fa-trash"></i> 
                        </a>
                    </div>
                </div>
            </div>
        </section>                   

        <!--Pie Pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>      

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    </body>
</html>