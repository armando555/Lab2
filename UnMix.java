package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UnMix {
    File file;
    String argument;
    Mix mix;
    ArrayList<String> comands;

    /**
     * This is the builder and here I get the
     * @throws FileNotFoundException
     */
    public UnMix() throws FileNotFoundException{
        comands=new ArrayList<>();
        String nombreArchivo=IO.inputString("Ingresa el nombre del archivo");
        file=new File(nombreArchivo);
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){
            argument=sc.nextLine();
            comands.add(argument);
        }
        mix=new Mix(argument);
    }

    /**
     * This comand ejecute all the comands invers that I saved on the txt
     * @param listCom
     */
    public void solution(ArrayList <String> listCom){
        int size=listCom.size();
        int count=size-2;
        String comando;
        String [] comand;
        while(count>=0){
            comando=listCom.get(count);
            boolean comandChecked=UserInteraction.checkComand(comando,mix.lista);
            if(comandChecked){
                comand=comando.split(" ");
                switch (comand[0]){
                    case "b":
                        mix.lista=mix.b(mix.lista,comand[1],Integer.parseInt(comand[2]));
                        break;
                    case "r":
                        mix.lista=mix.r(mix.lista,Integer.parseInt(comand[1]),Integer.parseInt(comand[2]));
                        break;
                    case "d":
                        mix.lista=mix.d(mix.lista,comand[1].charAt(0));
                        break;
                    case "f":
                        mix.lista=mix.f(mix.lista,comand[1].charAt(0),comand[2].charAt(0));
                        break;
                    case "ce":
                        mix.lista=mix.ce(mix.lista,Integer.parseInt(comand[1]));
                        break;
                    case "dc":
                        mix.lista=mix.dc(mix.lista,Integer.parseInt(comand[1]));
                        break;
                }
            }
            count--;
        }
        System.out.println("\nTHIS IS THE LIST UNMIXED\n");
        mix.lista.printList();
    }
}
