package src;

import java.io.FileNotFoundException;

public class MainUnMix {
    public static void main(String[] args) {
        boolean archivo=true;
        while(archivo) {
            try {
                System.out.println();
                UnMix unMx = new UnMix();
                unMx.solution(unMx.comands);
                archivo=false;
            } catch (FileNotFoundException e) {
                System.err.println("It couldn't open");
            }
        }
    }
}
