package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public class Personal extends Persona {

    private String numeroIdentificacion;

    public Personal(String nombre, String numeroIdentificacion) {

        super(nombre);
        this.numeroIdentificacion = numeroIdentificacion;

    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "numeroIdentificacion='" + numeroIdentificacion + '\'' +
                '}';
    }
}
