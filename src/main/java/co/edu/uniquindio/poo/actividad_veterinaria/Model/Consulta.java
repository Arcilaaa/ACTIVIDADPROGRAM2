package co.edu.uniquindio.poo.actividad_veterinaria.Model;

import java.util.ArrayList;

public class Consulta {

    private String fecha;
    private String hora;
    private String mascotaasig;
    private String veterinarioasig;
    private String motivo;
    private String diagnositco;
    private String tratamiento;
    private Consulta[] listaConsultas;
    private double cantidadConsultas = 0;

    public Consulta(String fecha, String hora, String mascotaasig, String veterinarioasig, String motivo, String diagnositco, String tratamiento) {

        this.fecha = fecha;
        this.hora = hora;
        this.mascotaasig = mascotaasig;
        this.veterinarioasig = veterinarioasig;
        this.motivo = motivo;
        this.diagnositco = diagnositco;
        this.tratamiento = tratamiento;


    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMascotaasig() {
        return mascotaasig;
    }

    public void setMascotaasig(String mascotaasig) {
        this.mascotaasig = mascotaasig;
    }

    public String getVeterinarioasig() {
        return veterinarioasig;
    }

    public void setVeterinarioasig(String veterinarioasig) {
        this.veterinarioasig = veterinarioasig;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnositco() {
        return diagnositco;
    }

    public void setDiagnositco(String diagnositco) {
        this.diagnositco = diagnositco;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", mascotaasig='" + mascotaasig + '\'' +
                ", veterinarioasig='" + veterinarioasig + '\'' +
                ", motivo='" + motivo + '\'' +
                ", diagnositco='" + diagnositco + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                '}';
    }

        public String registrarConsulta(String fecha, String hora, String mascotaAsig, String veterinarioAsig,
                                        String motivo, String diagnostico, String tratamiento) {
            String mensaje = "";                            // Variable para los mensajes
            int posDisponible = -1;                         // Variable para ver si hay cupos para nuevas consultas

            posDisponible = buscarPosicionDisponible();
            if (posDisponible == -1) {
                mensaje = "No hay cupos disponibles para agendar más consultas";
            } else {
                // Crea la consulta y la guarda en la posición disponible
                Consulta nuevaConsulta = new Consulta(fecha, hora, mascotaAsig, veterinarioAsig, motivo, diagnostico, tratamiento);
                listaConsultas[posDisponible] = nuevaConsulta;
                mensaje = "Consulta agendada correctamente";
                cantidadConsultas++;
            }
            return mensaje;
        }

        private int buscarPosicionDisponible() {
            int posDisponible = -1;
            for (int i = 0; i < listaConsultas.length; i++) {
                if (listaConsultas[i] == null) {          // Si encuentra un espacio vacío, retorna su posición
                    return i;
                }
            }
            return posDisponible;                         // Si no hay espacios, retorna -1
        }

        public Consulta buscarConsulta(String fecha) {                     //metodo que busca las consultas ya existentes
            for (int i = 0; i < cantidadConsultas; i++) {
                Consulta consultaAux = listaConsultas[i];                //variable que servira para comparar las fechas ya que buscamos por fechas
                if (consultaAux.getFecha().equals(fecha)) {
                    return consultaAux;
                }
            }
            return null;
        }
    }
}
