import java.util.ArrayList;
import java.util.List;

public class Barco {

    private final List<Pasajero> pasajeros = new ArrayList<>();

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    public boolean hayPasajeros() {
        return !pasajeros.isEmpty();
    }

    public synchronized List<Pasajero> rescatarPasajeros(int cantidad) {
        List<Pasajero> rescatados = new ArrayList<>();

        while (rescatados.size() < cantidad && !pasajeros.isEmpty()) {

            // 1. Buscar la menor prioridad presente
            int menorPrioridad = Integer.MAX_VALUE;
            for (int i = 0; i < pasajeros.size(); i++) {
                Pasajero p = pasajeros.get(i);
                if (p.getPrioridad() < menorPrioridad) {
                    menorPrioridad = p.getPrioridad();
                }
            }

            // 2. Recoger los pasajeros con esa prioridad
            for (int i = 0; i < pasajeros.size() && rescatados.size() < cantidad; i++) {
                Pasajero p = pasajeros.get(i);
                if (p.getPrioridad() == menorPrioridad) {

                    // Lo añadimos a la balsa:
                    rescatados.add(p);

                    // Lo eliminamos del barco:
                    pasajeros.remove(i);

                    // OBLIGATORIO rebobinar índice
                    i--;
                }
            }
        }

        return rescatados;
    }
}
