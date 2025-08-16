package co.edu.uniquindio.poo.actividad_veterinaria.Model;

import java.util.ArrayList;

public class Mascota {

    private String nombre;
    private String especie;
    private String raza;
    private byte edad;
    private double cantidadMascotas = 0;
    private ArrayList<Veterinario> listaVeterinarios;
    private Mascota[] listaMascotas;

    public Mascota(String nombre, String especie, String raza, byte edad) {

        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public ArrayList<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }

    public void setListaVeterinarios(ArrayList<Veterinario> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", listaVeterinarios=" + listaVeterinarios +
                '}';
    }
    public String registrarMascota(Mascota mascota) {    // metodo que registra las mascotas
        String mensaje = "";                            // variable para los mensajes
        int posDisponible = -1;                          //variable para ver si hay cupos para las mascotas

        posDisponible = buscarPosicionDisponible();            //metodo que busca si hay posiciones disponibles
        if (posDisponible == -1) {
            mensaje = "no hay cupos disponibles para la atencion de la mascota";

        }else{                                                   // y en caso de que existan posiciones disponibles agregue a la mascota
            listaMascotas[posDisponible] = mascota;
            mensaje = "Mascota agregada";
            cantidadMascotas++;
        }

        return mensaje;
    }

    public Mascota buscarMascota(String nombre) {  //metodo para buscar mascotas
        for(int i = 0 ; i < listaMascotas.length ; i++){ //pasa por toda la lista de mascotas
            Mascota mascotaAux = listaMascotas[i];  //se crea una mascota auxiliar para comprarla con las mascotas disponibles
            if(mascotaAux.getNombre().equals(nombre)){  // si se encuentra la mascota en la lista se retorna esta
                return mascotaAux;
            }
        }
        return null;                                   //si no se encuentra la mascota en la lista se retorna el espacio vacio
    }

    private int buscarPosicionDisponible() {   //metodo para revisar si hay posiciones disponibles en las listas
        int posDisponible = -1;           //variable que se devuelve en caso de que no se encuentras posiciones dispobles

        for (int i = 0; i < listaMascotas.length; i++) {  //for que busca las posiciones disponiles en una lista
            Mascota mascotaAux = listaMascotas[i];  //variable que se rota por la lista buscando una posicion disponible
            if (mascotaAux == null){                // if que cuando encuentra un espacio libre en la lista lo retorna
                return i;
            }
        }

        return posDisponible;                      //si no hay posiciones disponibles retorna la variable que teniamos que es un espacio lleno
    }

    public String actualizarMascota (String nuevoNombre , String nuevaEspecie,byte nuevaEdad, String nuevaRaza) {  // metodo que actualizara la informacion de la mascota
    Mascota mascota = mascota.buscarMascota(nombre);    //metodo que busca la mascota que intentamos actualizar su informacion
    if (mascota != null) {
        mascota.setNombre(nuevoNombre);
        mascota.setEspecie(nuevaEspecie);               // si encuentra la mascota realiza todos los cambios de la informacion de esta
        mascota.setRaza(nuevaRaza);                     // y notifica que la informacion de la mascota fue actualizada
        mascota.setEdad(nuevaEdad);
        return "Mascota actualizada.";
    }
    return "Mascota no encontrada.";                    // si no esta la mascota notifica que no la encontro
}
    public String eliminarMascota(String nombre) {          //metodo el cual elimina la mascota que deseemos
        for (int i = 0; i < cantidadMascotas; i++) {
            if (listaMascotas[i].getNombre().equals(nombre)) {          // Mueve todas las mascotas después una posición atrás
                for (int j = i; j < cantidadMascotas - 1; j++) {        // y de esta manera quita la mascota deseada sin dejar espacios
                    listaMascotas[j] = listaMascotas[j + 1];
                }
                cantidadMascotas--;                                   // se descuenta 1 mascota a la cantidad que se tenia
                return "Mascota eliminada.";
            }
        }
        return "Mascota no encontrada.";
    }

}
