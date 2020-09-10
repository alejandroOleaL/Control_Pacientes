<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="pacientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Pacientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre:</th>
                                <th>Edad:</th>
                                <th>Cita:</th>
                                <th>Editar:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="paciente" items="${pacientes}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${paciente.nombre} ${paciente.apellido}</td>
                                    <td>${paciente.edad}</td>
                                    <td>${paciente.cita}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idPaciente=${paciente.idPaciente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-user-edit"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!--Tarjetas para los totales-->
            <div class="col-md-3">
                <div class="card text-center bg-warning text-white mb-3">
                    <div class="card-body">
                        <h3>Pacientes con cita hoy:</h3>
                        <h4 class="display-4">
                            <i class="fas fa-user-friends"></i> ${citasHoy}
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Pacientes:</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalPacientes}
                        </h4>
                    </div>
                </div>

            </div>
            <!--FinTarjetas para los totales-->

        </div>
    </div>
</section>

<!--Agregar Paciente Modal-->
<jsp:include page="/WEB-INF/paginas/paciente/agregarPaciente.jsp"/>
