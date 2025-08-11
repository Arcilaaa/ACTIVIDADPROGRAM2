package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public enum Especie {

    PERRO(0), GATO(1), SERPIENTE(2), AVE(3);

    private final int numero;

    Especie(int numero) {
        this.numero = numero;
    }
}
