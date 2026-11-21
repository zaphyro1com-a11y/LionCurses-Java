package main;

import lioncurses.Color;
import lioncurses.Terminal;

public class Main {

    static Color green = new Color(0,255,0);

    public static void main(String[] args)
    throws InterruptedException {

        while(true){

            Terminal.clear();

            double t =
                System.currentTimeMillis()
                / 1000.0;

            int r =
                (int)(127 + 127*Math.cos(t));

            int g =
                (int)(127 + 127*Math.cos(
                    t + 2*Math.PI/3));

            int b =
                (int)(127 + 127*Math.cos(
                    t + 4*Math.PI/3));

            Color.printfRGB(
                r, g, b,
                0, 0, 0,
                "RGB(%d,%d,%d)\r",
                r, g, b
            );

            Color.printfRGB(green, "\nHola mundo\n\n\n");

            Thread.sleep(16);
        }
    }
}