package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public enum Especialidad {

    PERRO(0), GATO(1), SERPIENTE(2), AVE(3);

    private final int codigo;

    Especialidad(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;

    }
}

