import java.util.ArrayList;

public class Eventi {
    private ArrayList<Evento> eventi;

    private class Evento {
        private final String nomeEvento;
        private int numPostiTot;
        private int numPostiOcc = 0;

        public Evento (String nomeEvento, int numPostiTot) {
            this.nomeEvento = nomeEvento;
            this.numPostiTot = numPostiTot;
        }

        public boolean aggiungiPosti(int n) {
            if (n <= 0)
                return false;

            numPostiTot += n;
            return true;
        }

        public boolean aggiungiPersone(int n) {
            if (n <= getPostiDisponibili()) {
                numPostiOcc += n;
                return true;
            }

            return false;
        }

        public String getNomeEvento() {
            return nomeEvento;
        }

        public int getNumPostiTot() {
            return numPostiTot;
        }

        public int getNumPostiOcc() {
            return numPostiOcc;
        }

        public int getPostiDisponibili () {
            return numPostiTot - numPostiOcc;
        }
    }

    public synchronized boolean crea(String nome, int postiTot) {
        for (Evento e : eventi)
            if (e.getNomeEvento().equals(nome))
                return false;

        eventi.add(new Evento(nome, postiTot));
        return true;
    }

    public synchronized boolean aggiungi(String nome, int posti) {
        for (Evento e : eventi)
            if (e.getNomeEvento().equals(nome)) {
                if(!e.aggiungiPosti(posti))
                    throw new IllegalArgumentException("Inserire un valore valido per posti");
                return true;
            }

        throw new IllegalArgumentException("L'evento cercato non esiste");
    }

    public synchronized boolean prenota(String nome, int posti) {
        for (Evento e : eventi) {
            System.out.println("PIPPOOOOOOOOOOOOOO");
        }

    }

}
