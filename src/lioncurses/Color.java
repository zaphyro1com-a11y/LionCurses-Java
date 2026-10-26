package lioncurses;

public class Color {

    //* Atributos */
    //Constantes para el modo Color16
    //-- Colores Normales
    public static final int BLACK = 30;
    public static final int RED = 31;
    public static final int GREEN = 32;
    public static final int YELLOW = 33;
    public static final int BLUE = 34;
    public static final int MAGENTA = 35;
    public static final int CYAN = 36;
    public static final int WHITE = 37;
    //-- Colores Brillantes
    public static final int B_BLACK = 30;
    public static final int B_RED = 31;
    public static final int B_GREEN = 32;
    public static final int B_YELLOW = 33;
    public static final int B_BLUE = 34;
    public static final int B_MAGENTA = 35;
    public static final int B_CYAN = 36;
    public static final int B_WHITE = 37;

    //* Metodos *
    // Cambiar color del foreground en modo COLOR16
    static void FGC16(int color){
        // revisar color
        if(color>16) return;

        System.out.printf("\033[%dm", color);

    }

    // Cambiar el color del BackGround en modo Color16
    static void BGC16(int color){
        // Revisar color
        if(color>16) return;
        System.out.printf("\033[%dm", color+10);

    }

    // Imprime un cadena y la colorea usando Color16 (bg y fg)
    public static void print16(int foreground, int background, String _Str){
        // activar los colores
        FGC16(foreground);
        BGC16(background);
        // imprimir cadena
        System.out.print(_Str);
        // Apagar colores
        off();

    }

    // Imprime una cadena con formato usando Color16
    public static void printf16(int foreground, int background, String format, Object... args) {
        // Activar colores
        FGC16(foreground);
        BGC16(background);
        // Imprimir texto formateado
        System.out.printf(format, args);
        // Restaurar colores
        off();

    }

    // Convierte RGB a formato Color256
    static int RGBto256(int r, int g, int b ) {

        // Revisar RGB
        if(r > 255 || g > 255 || b > 255) return 1;

        int R = Math.round(r * 5f / 255f);
        int G = Math.round(g * 5f / 255f);
        int B = Math.round(b * 5f / 255f);
    
        // WAOS :0
        return 16 + 36 * R + 6 * G + B;
    }

    // Cambia el color del FG usando el modo Color256
    static void FGC256(int color){
        // Revisar color
        if (color > 256) return ;

        System.out.printf("\033[38;5;%dm", color);

    } 

    // Cambia el color del FG usando el modo Color256, pero permite ingresar RGB
    public static void FGC256(int r, int g, int b){
        // Comprobar RGB
        if (r > 255 || g >255 || b > 255) return;

        System.out.printf("\033[38;5;%dm", RGBto256(r, g, b));

    } 

    // Cambia el color del BG usando el modo Color256
    static void BGC256(int color){
        // Revisar Color
        if (color > 255) return;
        System.out.printf("\033[48;5;%dm", color);

    }

    // Camia el color del BG usando el modo Color256, pero permite ingresar RGB
    public static void BGC256(int r, int g, int b){
        // Comprobar RGB
        if (r > 255 || g >255 || b > 255) return;

        System.out.printf("\033[48;5;%dm", RGBto256(r, g, b));

    }

    // Imprime un mensaje y lo colorea usando el modo 256
    public static void print256(int foreground, int background, String str){
        //Activar Colores
        FGC256(foreground);
        BGC256(background);

        // Imprimir mensaje
        System.out.print(str);

        // off
        off();

    }

    //imprime un mensaje con formato y lo colorea usando el modo Color256
    public static void printf256(int foreground, int background, String format, Object... args){
        //Activar Colores
        FGC256(foreground);
        BGC256(background);
        // Imprimir mensaje
        System.out.printf(format, args);

        // off
        off();

    }

    // Cambia el color del FG usando el modo TrueColor (24-bits) RBG
    static void FGTC(int r, int g, int b){
        // Revisar RGB
        if (r > 255 || g > 255 || b > 255) return;

        System.out.printf("\033[38;2;%d;%d;%dm", r, g , b);

    }

    // Cambia el color del BG usando el modo TrueColor ()-bits RGB
    static void BGTC(int r, int g, int b){
        // Revisar RGB
        if (r > 255 || g > 255 || b > 255) return;

        System.out.printf("\033[48;2;%d;%d;%dm", r, g , b);

    }

    // Imprime un mensaje y lo colorea usando el modo TrueColor RGB
    public static void printRGB(int fr, int fg, int fb, int br, int bg, int bb, String str){
        // Activar Colores
        FGTC(fr, fg, fb);
        BGTC(br, bg, bb);

        // Imprimir Mensaje
        System.out.print(str);

        // Off
        off();

    }

    // Imprime un mensaje con formato y lo colorea usando el modo TrueColor RGB
    public static void printfRGB(int fr, int fg, int fb, int br, int bg, int bb, String format, Object... args){
        // Activar Colores
        FGTC(fr, fg, fb);
        BGTC(br, bg, bb);
        //Imprimir
        System.out.printf(format, args);
        //Apagar
        off();

    }

    // Termina todo lo relacionado con colores y fromatos
    public static void off(){
        System.out.print("\033[0m");

    }
    
}