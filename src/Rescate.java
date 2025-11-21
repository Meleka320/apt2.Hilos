import java.util.*;

//Explicacion en el comentario

class Rescate implements Runnable {
    private Balsa balsa;
    private Barco barco;

    public Rescate(Balsa balsa, Barco barco) {
        this.balsa = balsa;
        this.barco = barco;
    }

    @Override
    public void run() {
        while (barco.hayPasajeros()) {
            List<Pasajero> rescatados = barco.rescatarPasajeros(balsa.getCapacidad());
            if (!rescatados.isEmpty()) {
                System.out.print("Balsa " + balsa.getNombre() + " rescató a pasajeros: ");
                for (Pasajero p : rescatados) {
                    System.out.print(p.getId() + " ");
                }
                System.out.println();
            }

            try {
                Thread.sleep(balsa.getTiempo()); // esperar tiempo de rescate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}