package main;

import java.time.LocalTime;

import lioncurses.Color;

public class Main {

    public static void main(String[] args)
    throws InterruptedException {

        while(true){

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

            Thread.sleep(16);
        }
    }
}