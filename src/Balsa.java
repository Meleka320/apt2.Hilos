import java.util.concurrent.Semaphore;

class Balsa {
    private String nombre;
    private int capacidad;
    private int tiempo; // en ms

    // Semáforo que controla cuántos pasajeros puede tomar la balsa a la vez
    private Semaphore permisoBalsa;

    public Balsa(String nombre, int capacidad, double tiempoSegundos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempo = (int)(tiempoSegundos * 1000);
        this.permisoBalsa = new Semaphore(capacidad);
    }

    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
    public int getTiempo() { return tiempo; }
    public Semaphore getPermisoBalsa() { return permisoBalsa; }
}
