enum Color {
    ROJO, VERDE, AMARILLO, PURPURA
}

public class Jugada {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_BLACK = "\u001B[30m"; //Cambiar a "\u001B[0m" en caso de tener un tema oscuro
    private static final char CUADRADO = '\u25A0';

    private final Color[] fichas;

    public Jugada(String cadena) {
        fichas = new Color[cadena.length()];
        for(int i = 0; i < fichas.length; i++){
            switch (cadena.charAt(i)){
                case 'R':
                    fichas[i] = Color.ROJO;
                    break;
                case 'V':
                    fichas[i] = Color.VERDE;
                    break;
                case 'A':
                    fichas[i] = Color.AMARILLO;
                    break;
                case 'P':
                    fichas[i] = Color.PURPURA;
                    break;
            }
        }
    }

    public Jugada(int numFichas) {
        fichas = new Color[numFichas];
        for (int i = 0; i < fichas.length; i++){
            int random = (int) (Math.random() * 4);
            switch (random){
                case 0:
                    fichas[i] = Color.ROJO;
                    break;
                case 1:
                    fichas[i] = Color.VERDE;
                    break;
                case 2:
                    fichas[i] = Color.AMARILLO;
                    break;
                case 3:
                    fichas[i] = Color.PURPURA;
                    break;
            }
        }
    }

    public Pistas comprobar(Jugada oculta) {
        boolean[] acertado = new boolean[fichas.length];
        boolean[] acertadoOculta = new boolean[fichas.length];

        int aciertos = 0;
        int descolocados = 0;

        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i] == oculta.fichas[i]) {
                acertado[i] = true;
                acertadoOculta[i] = true;
                aciertos++;
            }
        }

        for (int i = 0; i < fichas.length; i++) {
            if (!acertado[i]) {
                for (int j = 0; j < fichas.length; j++) {
                    if (!acertadoOculta[j] && fichas[i] == oculta.fichas[j]) {
                        acertado[i] = true;
                        acertadoOculta[j] = true;
                        descolocados++;
                        break;
                    }
                }
            }
        }

        return new Pistas(aciertos, descolocados);

    }

    public void visualizar() {
        for (Color ficha : fichas) {
            switch (ficha) {
                case ROJO:
                    System.out.print(ANSI_RED + CUADRADO + " ");
                    break;
                case VERDE:
                    System.out.print(ANSI_GREEN + CUADRADO + " ");
                    break;
                case AMARILLO:
                    System.out.print(ANSI_YELLOW + CUADRADO + " ");
                    break;
                case PURPURA:
                    System.out.print(ANSI_PURPLE + CUADRADO + " ");
                    break;
            }
        }
        System.out.print(ANSI_BLACK);
    }

    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (Color ficha : fichas) {
            switch (ficha) {
                case ROJO:
                    resultado.append("R");
                    break;
                case VERDE:
                    resultado.append("V");
                    break;
                case AMARILLO:
                    resultado.append("A");
                    break;
                case PURPURA:
                    resultado.append("P");
                    break;
            }
        }
        return resultado.toString();
    }

}
