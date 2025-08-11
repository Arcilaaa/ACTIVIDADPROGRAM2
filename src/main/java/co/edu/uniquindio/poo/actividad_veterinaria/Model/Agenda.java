package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public class Agenda {

    private boolean disponibilidad;

    public Agenda(boolean disponibilidad) {

        this.disponibilidad = disponibilidad;

    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "disponibilidad=" + disponibilidad +
                '}';
    }
}
