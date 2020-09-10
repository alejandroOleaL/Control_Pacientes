package dominio;

public class Paciente {
    
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int edad;
    private String cita;

    public Paciente() {
    }

    public Paciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(String cita) {
        this.cita = cita;
    }

    public Paciente(String nombre, String apellido, String email, String telefono, int edad, String cita) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.cita = cita;
    }

    public Paciente(int idPaciente, String nombre, String apellido, String email, String telefono, int edad, String cita) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.cita = cita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "paciente{" + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", edad=" + edad + '}';
    }
    
    
}
