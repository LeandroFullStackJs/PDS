import java.util.List;
import java.util.ArrayList;

public class Funcion {
    private int id;
    private String fecha;
    private int hora;
    private Grupo grupo;
    private int duracion; // en minutos
    private List<Asiento> asientosDisponibles;
    private int capacidadMaxima;

    // Constructor
    public Funcion(int id, String fecha, int hora, Grupo grupo, int duracion, int capacidadMaxima) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.grupo = grupo;
        this.duracion = duracion;
        this.capacidadMaxima = capacidadMaxima;
        this.asientosDisponibles = new ArrayList<>();  // Inicializamos la lista
        cargarAsientos();  // Llenamos los asientos disponibles al crear la función
    }

    // Método para llenar los asientos disponibles
    private void cargarAsientos() {
        for (int i = 1; i <= capacidadMaxima; i++) {  // Usamos la capacidad máxima general
            asientosDisponibles.add(new Platea(i, 100.0)); // Ejemplo de costo base
        }
    }

    public double calcularCostoTotal() {
        return duracion * 2; // Ejemplo: 2 unidades monetarias por minuto de duración
    }

    public List<Asiento> getAsientosDisponibles() {
        List<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientosDisponibles) {
            if (asiento.isDisponible()) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }

    public void reservarAsiento(Asiento asiento) {
        asiento.setDisponible(false);
    }

    public void liberarAsiento(Asiento asiento) {
        asiento.setDisponible(true);
    }

    @Override
    public String toString() {
        return "Funcion [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", duracion=" + duracion + "]";
    }
}
