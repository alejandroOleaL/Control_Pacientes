package datos;

import dominio.Paciente;
import java.sql.*;
import java.util.*;

public class PacienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_paciente, nombre, apellido, email, telefono, edad, cita "
            + " FROM pacientes";

    private static final String SQL_SELECT_CITAS = "SELECT cita "
            + " FROM pacientes WHERE DATE(cita)=CURDATE()";

    private static final String SQL_SELECT_BY_ID = "SELECT id_paciente, nombre, apellido, email, telefono, edad, cita "
            + " FROM pacientes WHERE id_paciente = ?";

    private static final String SQL_INSERT = "INSERT INTO pacientes(nombre, apellido, email, telefono, edad, cita) "
            + " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE pacientes "
            + " SET nombre=?, apellido=?, email=?, telefono=?, edad=?, cita=? WHERE id_paciente=?";

    private static final String SQL_DELETE = "DELETE FROM pacientes WHERE id_paciente=?";

    public List<Paciente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPaciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                String cita = rs.getString("cita");

                paciente = new Paciente(idPaciente, nombre, apellido, email, telefono, edad, cita);
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pacientes;
    }
    
        public List<Paciente> citas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CITAS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cita = rs.getString("cita");

                paciente = new Paciente(cita);
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pacientes;
    }

    public Paciente encontrar(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, paciente.getIdPaciente());
            rs = stmt.executeQuery();
            rs.next();
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            int edad = rs.getInt("edad");
            String cita = rs.getString("cita");

            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setEmail(email);
            paciente.setTelefono(telefono);
            paciente.setEdad(edad);
            paciente.setCita(cita);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return paciente;
    }

    public int insertar(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefono());
            stmt.setInt(5, paciente.getEdad());
            stmt.setString(6, paciente.getCita());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefono());
            stmt.setInt(5, paciente.getEdad());
            stmt.setString(6, paciente.getCita());
            stmt.setInt(7, paciente.getIdPaciente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, paciente.getIdPaciente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
