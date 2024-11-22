public class Tablero {
    private final static int MAX_JUGADAS = 10;

    private final Jugada[] jugadas;
    private final Pistas[] pistas;
    private int numJugadas;

    public Tablero() {
       this.jugadas = new Jugada[MAX_JUGADAS];
       this.pistas = new Pistas[MAX_JUGADAS];
       this.numJugadas = 0;
    }


    public Jugada[] getJugadas() {
        return jugadas;
    }

    public Pistas[] getPistas() {
        return pistas;
    }

    public int getNumJugadas() {
        return numJugadas;
    }

    public void insertar(Jugada jugada, Pistas pistas) {
        if (numJugadas < MAX_JUGADAS) {
            this.jugadas[numJugadas] = jugada;
            this.pistas[numJugadas] = pistas;
            numJugadas++;
        } else {
            System.out.println("No se pueden insertar más jugadas");
        }
    }

    public boolean completo() {
        return numJugadas >= MAX_JUGADAS;
    }

    public void visualizar() {
        for (int i = 0; i < numJugadas; i++) {
            System.out.printf("Jugada %d \t", i + 1);
            jugadas[i].visualizar();
            System.out.print("\t");
            pistas[i].visualizar();
            System.out.println();
        }
    }


}
