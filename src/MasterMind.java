import java.io.*;

public class MasterMind {
    private Tablero tablero;
    private Jugada jugadaOculta;
    private int numFichas;

    public MasterMind(int numFichas) {
        this.numFichas = numFichas;
        this.jugadaOculta = new Jugada(numFichas);
        this.tablero = new Tablero();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public MasterMind(String nombreArchivo) {
        try (BufferedReader leer = new BufferedReader(new FileReader(nombreArchivo))) {
            String primeraLinea = leer.readLine();
            this.numFichas = primeraLinea.length();
            this.jugadaOculta = new Jugada(primeraLinea);

            this.tablero = new Tablero();

            String linea;
            while ((linea = leer.readLine()) != null) {
                String[] jugadaYPistas = linea.split(" ");
                Jugada jugada = new Jugada(jugadaYPistas[0]);
                Pistas pistas = new Pistas(Integer.parseInt(jugadaYPistas[1]), Integer.parseInt(jugadaYPistas[2]));
                tablero.insertar(jugada, pistas);
            }
        } catch (IOException e) {
            System.out.println("ERROR AL RECUPERAR LA PARTIDA");
        }
    }

    private void guardarPartida(String nombreArchivo) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(nombreArchivo))) {

            escribir.write(jugadaOculta.toString());
            escribir.newLine();

            for (int i = 0; i < tablero.getNumJugadas(); i++) {
                Jugada jugada = tablero.getJugadas()[i];
                Pistas pistas = tablero.getPistas()[i];
                escribir.write(jugada.toString() + " " + pistas.toString());
                escribir.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR AL GUARDAR LA PARTIDA");
        }
    }

    public void jugar() {
        while (true) {
            String input = Teclado.leerJugadaGuardar(numFichas,"Introduce jugada o G (guardar la partida).\nR (Rojo), V(Verde), A (Amarillo), P (púrpura): ");

            if (input.equals("G")) {
                String nombreArchivo = Teclado.leerString("Nombre del archivo: ");
                guardarPartida(nombreArchivo);
                System.out.println("Partida guardada. Fin del juego.");
                break;
            } else {
                Jugada jugada = new Jugada(input);
                Pistas pistas = jugada.comprobar(jugadaOculta);
                tablero.insertar(jugada, pistas);
                tablero.visualizar();

                if (pistas.getAciertos() == numFichas) {
                    System.out.println("ACERTASTE LA JUGADA");
                    break;
                }

                if (tablero.completo()) {
                    System.out.println("FIN DE LOS INTENTOS, NO CONSEGUISTE ACERTAR");
                    System.out.print("La jugada oculta era: ");
                    jugadaOculta.visualizar();
                    System.out.println();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        MasterMind masterMind;
        if (Teclado.leerSiNo("¿Quieres recuperar una partida? (S/N): ") == 'S') {
            String nombreArchivo = Teclado.leerString("Nombre del archivo: ");
            masterMind = new MasterMind(nombreArchivo);
            masterMind.getTablero().visualizar();
        } else {
            int fichas = Teclado.leerEntero(4, 6, "Número de fichas de las jugadas (4 - 6): ");
            masterMind = new MasterMind(fichas);
        }
        masterMind.jugar();
    }
}
