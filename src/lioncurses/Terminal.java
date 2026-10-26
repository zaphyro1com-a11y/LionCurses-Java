package lioncurses;

public class Terminal{

    // * Metodos
    
    // Limpiar Pantalla
    public static void clear(){
        System.out.print("\033[2J");
        System.out.print("\033[H");
        System.out.flush();

    }

    // limpia la linea actual
    public static void clearLine() {
        System.out.print("\033[2K");
    }

    // limpia desde el cursor hasta el final
    public static void clearToEnd() {
        System.out.print("\033[0K");
    }

}