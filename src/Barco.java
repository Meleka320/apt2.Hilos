import java.util.*;

//Explicacion en el comentario

class Barco {
    private final List<Pasajero> pasajeros;

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public synchronized List<Pasajero> rescatar(int cantidad) {
        // Ordenamos por prioridad (menor primero)
        pasajeros.sort(Comparator.comparingInt(Pasajero::getPrioridad));

        List<Pasajero> rescatados = new ArrayList<>();
        int n = Math.min(cantidad, pasajeros.size());
        for (int i = 0; i < n; i++) {
            rescatados.add(pasajeros.remove(0));
        }
        return rescatados;
    }

    public boolean hayPasajeros() {
        return !pasajeros.isEmpty();
    }
}