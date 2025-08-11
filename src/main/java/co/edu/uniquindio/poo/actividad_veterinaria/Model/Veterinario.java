package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public class Veterinario extends Persona{

    private String especialidad;
    private String numerodelicencia;
    private Veterinario[] listaVeterinarios;


    public Veterinario(String nombre, String especialidad, String numerodelicencia) {

        super(nombre);
        this.especialidad = especialidad;
        this.numerodelicencia = numerodelicencia;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumerodelicencia() {
        return numerodelicencia;
    }

    public void setNumerodelicencia(String numerodelicencia) {
        this.numerodelicencia = numerodelicencia;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "especialidad='" + especialidad + '\'' +
                ", numerodelicencia='" + numerodelicencia + '\'' +
                '}';
    }

    public String registrarVeterinario(Veterinario veterinario) {    //metodo que registra los veterinarios
        String mensaje = "";                                        // variable para los mensajes
        int posDisponible = -1;                                     // variable para ver las posiciones disponibles

        posDisponible = buscarPosicionDisponible();                  // metodo que revisa si hay posiciones disponibles
        if (posDisponible == -1) {
            mensaje = "no hay cupos disponibles para la atencion de la mascota";

        }else{
            listaVeterinarios[posDisponible] = veterinario;  // si hay posiciones disponibles se agrega el veterinario
            mensaje = "Veterinario agregado";
        }

        return mensaje;
    }

    public Veterinario buscarVeterinario(String nombre) {   //metodo para buscar veterinarios ya agregados
        for(int i = 0 ; i < listaVeterinarios.length ; i++){    //for que pasa por toda la lista de  veterianrios
            Veterinario veterinarioAux = listaVeterinarios[i];  //variable auxiliar que nos ayudara a comparar los veterinarios
            if(veterinarioAux.getNombre().equals(nombre)){    // if que compara si alguno de los veterinarios de la lista es igual al que buscamos
                return veterinarioAux;                        //si lo encuentra retorna el veterinario
            }
        }
        return null;                                        // si no esta retorna null
    }

    private int buscarPosicionDisponible() {    //metodo para revisar si hay posiciones disponibles en las listas
        int posDisponible = -1;                 //variable que se devuelve en caso de que no se encuentras posiciones dispobles

        for (int i = 0; i < listaVeterinarios.length; i++) {      //for que busca las posiciones disponiles en una lista
            Veterinario veterinarioAux = listaVeterinarios[i];    //variable que se rota por la lista buscando una posicion disponible
            if (veterinarioAux == null){                          // if que cuando encuentra un espacio libre en la lista lo retorna
                return i;
            }
        }

        return posDisponible;                                  //si no hay posiciones disponibles retorna la variable que teniamos que es un espacio lleno
    }
}
