package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public class Veterinario extends Persona {

    private String especialidad;
    private String numerodelicencia;
    private double cantidadVeterinarios = 0;
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

    public String registrarVeterinario(Veterinario veterinario) {
        String mensaje = "";                            // variable para los mensajes
        int posDisponible = -1;                         //variable para ver si hay cupos para los veterinarios

        posDisponible = buscarPosicionDisponible();     //metodo que busca si hay posiciones disponibles
        if (posDisponible == -1) {
            mensaje = "no hay cupos disponibles para veterinarios";
        } else {                                       // y en caso de que existan posiciones disponibles agregue al veterinario
            listaVeterinarios[posDisponible] = veterinario;
            mensaje = "Veterinario agregado";
            cantidadVeterinarios++;
        }
        return mensaje;
    }

    public Veterinario buscarVeterinario(String nombre) {  //metodo para buscar veterinarios
        for (int i = 0; i < listaVeterinarios.length; i++) { //pasa por toda la lista de veterinarios
            Veterinario veterinarioAux = listaVeterinarios[i];  //se crea un veterinario auxiliar para compararlo con los veterinarios disponibles
            if (veterinarioAux.getNombre().equals(nombre)) {      // si se encuentra el veterinario en la lista se retorna este
                return veterinarioAux;
            }
        }
        return null;                                   //si no se encuentra el veterinario en la lista se retorna el espacio vacio
    }

    private int buscarPosicionDisponible() {    //metodo que nos ayuda a encontrar posiciones disponibles en una lista
        int posDisponible = -1;
        for (int i = 0; i < listaVeterinarios.length; i++) {     //for que pasa por la lista de veterinarios
            Veterinario veterinarioAux = listaVeterinarios[i];   // una variable auxiliar que nos ayuda a verificar si hay posiciones disponibles
            if(veterinarioAux == null){
                                                                 // si hay posiciones disponibles retorna el espacio
                return i;
            }
        }
        return posDisponible;                                    // si no hay posiciones retorna el valor dado a la variable que indica que no hay espacio

    }


    public String actualizarVeterinario(String nombre, String nuevaEspecialidad) {  // metodo que actualizara la informacion del veterinario
        Veterinario veterinario = buscarVeterinario(nombre);
        if (veterinario != null) {
            veterinario.setEspecialidad(nuevaEspecialidad);     // si encuentra el veterinario actualiza su especialidad
            return "Veterinario actualizado.";
        }
        return "Veterinario no encontrado.";
    }


    public String eliminarVeterinario(String nombre) {
                                                                    //metodo el cual elimina el veterinario que deseemos
        for (int i = 0; i < cantidadVeterinarios; i++) {
            if (listaVeterinarios[i].getNombre().equals(nombre)) {          // Mueve todas las personas después una posición atrás
                for (int j = i; j < cantidadVeterinarios - 1; j++) {        // y de esta manera quita la persona deseada sin dejar espacios
                    listaVeterinarios[j] = listaVeterinarios[j + 1];
                }
                cantidadVeterinarios--;                                   // se descuenta 1 persona a la cantidad que se tenia
                return "Veterinario eliminada.";
            }
        }
        return "Veterinario no encontrada.";
    }
}
}
