package src;

import java.io.*;
import java.util.ArrayList;

public class Mix {

    String argument;
    DoubleLinkedList lista;
    ClipBoard cb=new ClipBoard();
    FileWriter fw;
    String lettersR;
    ArrayList<Integer> positions;

    public Mix(String message){
        argument=message;
        lista=new DoubleLinkedList();
        char caracter;
        for(int i=0;i<argument.length();i++){
            caracter=argument.charAt(i);
            lista.insert(caracter);
        }
    }
    /**
     * this is the construct of the Mix and take the message of the user and construct the DoubleLinkedList
     */
    public Mix(){
        argument=IO.inputString("INGRESE EL MENSAJE A CIFRAR");
        lista=new DoubleLinkedList();
        char caracter;
        for(int i=0;i<argument.length();i++){
            caracter=argument.charAt(i);
            lista.insert(caracter);
        }
        try{
            String nombre= IO.inputString("Type the name of the file name.txt");
            fw=new FileWriter(nombre);
        }catch (Exception e){
            System.err.println("It couldn't open");
        }
    }

    /**
     * This function write on the File
     * @param fw
     * @param message
     */
    public static void writeInFile(FileWriter fw,String message){
        try{
            fw.write(message);
            fw.write("\n");
        }catch (Exception e){
            System.err.println("It couldn't write");
        }
    }

    /**
     * this function is where the comands are ejecuting after they have checked
     * @return
     */
    public void comandsEjecution(){
        String answer;
        String [] comand={};
        int counter=1;
        do{
            answer=UserInteraction.menuComands(lista,counter);
            counter=0;
            try{
                comand=answer.split(" ");
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Comand no right");
            }
            switch (comand[0]){
                case "b":
                    lista=b(lista,comand[1],Integer.parseInt(comand[2]));
                    writeInFile(fw,"r "+comand[2]+" "+(Integer.parseInt(comand[2])+comand[1].length()-1));
                    break;
                case "r":
                    lista=r(lista,Integer.parseInt(comand[1]),Integer.parseInt(comand[2]));
                    for (int i=0;i<lettersR.length();i++) {
                        System.out.print(lettersR.charAt(i));
                    }
                    System.out.println();
                    writeInFile(fw,"b "+lettersR+" "+comand[1]);
                    break;
                case "d":
                    lista=d(lista,comand[1].charAt(0));
                    for (Integer g:positions) {
                        writeInFile(fw,"b "+comand[1].charAt(0)+" "+g);
                    }
                    break;
                case "f":
                    lista=f(lista,comand[1].charAt(0),comand[2].charAt(0));
                    for (Integer g:positions) {
                        writeInFile(fw,"r "+(g+1)+" "+(g+1));
                        writeInFile(fw, "b "+comand[1].charAt(0)+" "+(g));
                    }
                    break;
                case "z":
                    break;
                case "ce":
                    lista=ce(lista,Integer.parseInt(comand[1]));
                    writeInFile(fw,"dc "+comand[1]);
                    break;
                case "dc":
                    lista=dc(lista,Integer.parseInt(comand[1]));
                    writeInFile(fw,"ce "+comand[1]);
                    break;
                case "c":
                    copy(Integer.parseInt(comand[1]),Integer.parseInt(comand[2]),cb);
                    //writeInFile(fw,"c "+comand[1]+" "+comand[2]);
                    break;
                case "x":
                    DoubleLinkedList listaCut=cut(Integer.parseInt(comand[1]),Integer.parseInt(comand[2]),cb);
                    String letters="";
                    for(int i=0;i<=listaCut.getLen();i++){
                        letters+=listaCut.getElement(i);
                    }
                    writeInFile(fw,"b "+letters+" "+comand[1]);
                    break;
                case "p":
                    String cadena=paste(Integer.parseInt(comand[1]),cb);
                    lista=b(lista,cadena,Integer.parseInt(comand[1]));
                    writeInFile(fw,"r "+comand[1]+" "+(Integer.parseInt(comand[1])+cadena.length()-1));
                    break;
            }
        }while(!(answer.equalsIgnoreCase("q")));
        System.out.println("THIS IS THE LIST MIXED");
        lista.printList();
        argument="";
        for (int i=0;i<=lista.getLen();i++){
            argument+=lista.getElement(i);
        }
        writeInFile(fw,argument);
        try {
            fw.close();
        }catch (Exception e){
            System.err.println("It couldn't close");
        }

    }

    /**
     * this function is insert a string on the linked list at specific position
     * @param list
     * @param data
     * @param position
     * @return
     */
    public DoubleLinkedList b(DoubleLinkedList list,String data,int position){
        char [] data1=new char[data.length()];
        for (int i=0;i<data.length();i++){
            data1[i]=data.charAt(i);
        }
        if (position<=list.getLen()) {
            if(position==0){
                if(data.charAt(0)=='_'){
                    list.preInsert(' ');
                }else{
                    list.preInsert(data.charAt(0));
                }
                position++;
                for(int p=position;p<data.length();p++){
                    if(data.charAt(p)=='_'){
                        list.insert(' ',p);
                    }else{
                        list.insert(data.charAt(p),p);
                    }

                    System.out.println();
                }
            }else {
                int count=0;
                for(int p=position;p<=list.getLen();p++){
                    if(data.charAt(count)=='_'){
                        list.insert(' ',p);
                    }else{
                        list.insert(data.charAt(count),p);
                    }
                    count++;
                    if ( count==data.length()){
                        break;
                    }
                }
            }
        }else{
            if(position==list.getLen()+1){
                if(data.charAt(data.charAt(0))=='_'){
                    list.insert(' ',list.getLen()+1);
                }else{
                    list.insert(data.charAt(0),list.getLen()+1);
                }

            }
        }
        return list;
    }

    /**
     * This function remove all the elements of the string from position1 to position2
     * @param list
     * @param position1
     * @param position2
     * @return
     */
    public DoubleLinkedList r(DoubleLinkedList list,int position1, int position2){
        if (position1<=position2&& position1<=list.getLen()&&position2<=list.getLen()){
            lettersR=list.deleteFromTo2(position1,position2);
        }
        return list;
    }

    /**
     * this function remove all the elements of the string if they are same to data
     * @param list
     * @param data
     * @return
     */
    public DoubleLinkedList d(DoubleLinkedList list,char data){
        positions=list.deleteAll2(data);
        return list;
    }

    /**
     * this function can fix the string replacing all the characters same to replaced with the character replaceTo
     * @param list
     * @param replaced
     * @param replaceTo
     * @return
     */
    public DoubleLinkedList f(DoubleLinkedList list,char replaced,char replaceTo){
        positions=list.replace(replaced,replaceTo);
        return list;
    }

    /**
     * This function changes all the characters of the list (en español no sé cómo escribirlo en inglés) le incrementa el número cifer al caracter  para convertirlo en otro caracter cifrado
     * @param list
     * @param cifer
     * @return
     */
    public DoubleLinkedList ce(DoubleLinkedList list,int cifer){
        list.shiftASCII(cifer);
        return list;
    }
    /**
     * This function changes all the characters of the list (en español no sé cómo escribirlo en inglés) le disminuye el número descifer al caracter  para convertirlo al caracter original
     * @param list
     * @param descifer
     * @return
     */
    public DoubleLinkedList dc(DoubleLinkedList list,int descifer){
        list.desShiftASCII(descifer);
        return  list;
    }

    /**
     * This function paste the list from the key (number), to the message at the "position"
     * @param position
     * @param cb
     * @return
     */

    public String paste(int position,ClipBoard cb ){
        int key=IO.inputInt("Ingrese la key :D");
        DoubleLinkedList list1= cb.paste(key);
        String cadena="";
        int size=list1.getLen();
        for(int i=0;i<size+1;i++){
            cadena+=list1.getElement(i);
        }
        System.out.println(cadena);
        return cadena;
    }

    /**
     * This function cut the elements of the list from position to position2 and add to the ClipBoard, but delete that elements from the original message
     * @param position
     * @param position2
     * @param cb
     * @return
     */
    public DoubleLinkedList cut(int position,int position2,ClipBoard cb ){
        DoubleLinkedList copys=new DoubleLinkedList();
        int count=position;
        position2++;
        while(count<position2){
            if(lista.getElement(count)==' '){
                copys.insert('_');
            }else{
                copys.insert(lista.getElement(count));
            }
            count++;
        }
        lista.deleteFromTo2(position,position2-1);
        int key=IO.inputInt("Ingrese la key :D");
        cb.copy(key,copys);
        System.out.println("LIST OF KEY");
        copys.printList();
        System.out.println();
        return copys;
    }

    /**
     * This function copy the elements of the list from position to position2 and add to the ClipBoard
     * @param position
     * @param position2
     * @param cb
     * @return
     */
    public DoubleLinkedList copy(int position,int position2,ClipBoard cb ){
        DoubleLinkedList copys=new DoubleLinkedList();
        int count=position;
        //position2++;
        while(count<=position2){
            copys.insert(lista.getElement(count));
            count++;
        }
        int key=IO.inputInt("Ingrese la key :D");
        cb.copy(key,copys);
        copys.printList();
        return copys;
    }


}

