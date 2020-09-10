package web;

import datos.PacienteDaoJDBC;
import dominio.Paciente;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPaciente(request, response);
                    break;
                case "eliminar":
                    this.eliminarPaciente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paciente> pacientes = new PacienteDaoJDBC().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pacientes", pacientes);
        sesion.setAttribute("totalPacientes", pacientes.size());

        //Obtener fecha actual
        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat(" E dd.MM.yyyy");
        String fecha = ft.format(dNow);
        sesion.setAttribute("fecha", fecha);

        //Obtener las citas para hoy
        List<Paciente> citas = new PacienteDaoJDBC().citas();
        sesion.setAttribute("citasHoy", citas.size());

        //Enviar los datos
        //request.getRequestDispatcher("pacientes.jsp").forward(request, response);
        response.sendRedirect("pacientes.jsp");
    }

    private void editarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        Paciente paciente = new PacienteDaoJDBC().encontrar(new Paciente(idPaciente));
        request.setAttribute("paciente", paciente);
        System.out.println("paciente = " + paciente);
        String jspEditar = "/WEB-INF/paginas/paciente/editarPaciente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarPaciente(request, response);
                    break;
                case "modificar":
                    this.modificarPaciente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    public void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String cita = request.getParameter("cita");
        int edad = 0;
        String edadInt = request.getParameter("edad");
        if (edadInt != null && !"".equals(edadInt)) {
            edad = Integer.parseInt(edadInt);
        }

        //Creamos el objeto de Paciente(modelo)
        Paciente paciente = new Paciente(nombre, apellido, email, telefono, edad, cita);

        //insertamos el nuevo objeto en la bd
        int registrosModificados = new PacienteDaoJDBC().insertar(paciente);

        //redirigimos hacia la accion por default
        this.accionDefault(request, response);
    }

    public void modificarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario de editar paciente
        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        int edad = 0;
        String edadInt = request.getParameter("edad");
        if (edadInt != null && !"".equals(edadInt)) {
            edad = Integer.parseInt(edadInt);
        }
        String cita = request.getParameter("cita");

        //Creamos el objeto de Paciente(modelo)
        Paciente paciente = new Paciente(idPaciente, nombre, apellido, email, telefono, edad, cita);

        //insertamos el nuevo objeto en la bd
        int registrosModificados = new PacienteDaoJDBC().actualizar(paciente);

        //redirigimos hacia la accion por default
        this.accionDefault(request, response);
    }

    public void eliminarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario de editar paciente
        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

        //Creamos el objeto de Paciente(modelo)
        Paciente paciente = new Paciente(idPaciente);

        //insertamos el nuevo objeto en la bd
        int registrosModificados = new PacienteDaoJDBC().eliminar(paciente);

        //redirigimos hacia la accion por default
        this.accionDefault(request, response);
    }
}
