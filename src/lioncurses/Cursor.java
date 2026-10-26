package lioncurses;

public class Cursor {

    // mover cursor
    public static void moveTo(int row, int col) {
        System.out.printf("\033[%d;%dH", row, col);
    }

    // ocultar cursor
    public static void hide() {
        System.out.print("\033[?25l");
    }

    // mostrar cursor
    public static void show() {
        System.out.print("\033[?25h");
    }

    // mueve el cursor hacia arriba
    public static void up(int n) {
        System.out.printf("\033[%dA", n);
    }

    // mueve el cursor hacia abajo
    public static void down(int n) {
        System.out.printf("\033[%dB", n);
    }
    
    // mueve el cursor hacia la derecha
    public static void right(int n) {
        System.out.printf("\033[%dC", n);
    }

    // mueve el cursor hacia la izquierda
    public static void left(int n) {
        System.out.printf("\033[%dD", n);
    }

    // mueve el cursor al inicio de linea
    public static void lineBegin() {
        System.out.print("\033[G");
    }

}
