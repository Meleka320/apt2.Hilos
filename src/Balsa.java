import java.util.*;

//Explicacion en el comentario
class Balsa {
    private String nombre;
    private int capacidad;
    private int tiempo; // en milisegundos

    public Balsa(String nombre, int capacidad, double tiempoSegundos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempo = (int)(tiempoSegundos * 1000); // convertir a ms
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTiempo() {
        return tiempo;
    }
}
