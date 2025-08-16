package co.edu.uniquindio.poo.actividad_veterinaria.Model;

public class Propietario extends Persona{

    private String nombre;
    private String identificacion;
    private String telefono;
    private String direccion;
    private Propietario[] listaPropietarios;
    private double cantidadPropietarios = 0;

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
    // Método que registra los propietarios
    public String registrarPropietario(Propietario propietario) {
        String mensaje = "";                            // variable para los mensajes
        int posDisponible = -1;                         //variable para ver si hay cupos para los propietarios

        posDisponible = buscarPosicionDisponible();     //metodo que busca si hay posiciones disponibles
        if (posDisponible == -1) {
            mensaje = "no hay cupos disponibles para propietarios";
        } else {                                       // y en caso de que existan posiciones disponibles agregue al propietario
            listaPropietarios[posDisponible] = propietario;
            mensaje = "Propietario agregado";
            cantidadPropietarios++;
        }
        return mensaje;
    }

    private int buscarPosicionDisponible() {                  //metodo que busca posiciones disponibles en una lista
        int posDisponible = -1;
        for (int i = 0; i < listaPropietarios.length; i++) {       //for que va en la lista buscando una posicion disponible
            Propietario propietarioAux = listaPropietarios[i];
            if (propietarioAux == null) {
                return i;                                          //si encuentra la posicion la retorna
            }

        }
        return posDisponible;                                   //si no encuentra la posicion disponible retorna el valor de pos disponible que nos dice que no hay esapcio
    }




    public Propietario buscarPropietario(String nombre) {  //metodo para buscar propietarios
        for(int i = 0 ; i < listaPropietarios.length ; i++){ //pasa por toda la lista de propietarios
            Propietario propietarioAux = listaPropietarios[i];  //se crea un propietario auxiliar para compararlo con los propietarios disponibles
            if(propietarioAux.getNombre().equals(nombre)){      // si se encuentra el propietario en la lista se retorna este
                return propietarioAux;
            }
        }
        return null;                                   //si no se encuentra el propietario en la lista se retorna el espacio vacio
    }


    public String actualizarPropietario(String nombre, String nuevaDireccion, String nuevoTelefono, String nuevaIdentificacion, String nuevoNombre) {  // metodo que actualizara la informacion del  propietario
        Propietario propietario = buscarPropietario(nombre);
        if (propietario != null) {
            propietario.setNombre(nuevoNombre);
            propietario.setTelefono(nuevoTelefono);    // si encuentra el propietario actualiza su informacion
            propietario.setDireccion(nuevaDireccion);
            propietario.setIdentificacion(nuevaIdentificacion);
            return "Propietario actualizado.";
        }
        return "Propietario no encontrado.";
    }


}
