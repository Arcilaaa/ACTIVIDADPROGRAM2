package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public class Propietario extends Persona{

    private String identificacion;
    private String telefono;
    private String direccion;

    public Propietario(String nombre, String identificacion, String telefono, String direccion) {

        super(nombre);
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;

    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }


}
