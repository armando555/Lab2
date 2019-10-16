package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    /**
     * this function read that user write on the console
     * @param mensaje
     * @return
     */
    public static String inputString(String mensaje){
        System.out.println(mensaje);
        Scanner sc=new Scanner(System.in);
        String linea=sc.nextLine();
        return linea;
    }
    /**
     * this function read that user write on the console
     * @param mensaje
     * @return
     */
    public static int inputInt(String mensaje)throws InputMismatchException {
        System.out.println(mensaje);
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        return num;
    }
}
