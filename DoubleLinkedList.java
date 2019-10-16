package src;

import java.util.ArrayList;

public class DoubleLinkedList {
    /**
     * head of the list
     */
    private Node top;

    /**
     * constructor of the list, initialize the head in null
     */

    public DoubleLinkedList(){
        top=null;
    }

    /**
     *
     * @return this function return how many elements does lista have, the size
     */
    public int getLen(){
        int size=0;
        Node temp=top;
        while(temp.getNext()!=null){
            temp=temp.getNext();
            size++;
        }
        return size;
    }

    /**
     *
     * @param insertar this function search a position index on the list, and insert in that position the new character
     * @param index position index to search in the linked list
     */
    public void insert(char insertar, int index){
        Node temp=top;
        int count=0;
        if (!(index<0 || index > getLen()+1)) {
            if (top == null) {
                top = new Node(insertar, null, null);
                temp=top;
            } else {
                if(index!=0&&index<=getLen()) {
                    while (temp.getNext() != null && count < index - 1) {
                        temp = temp.getNext();
                        count++;
                    }
                    Node nuevo = new Node(insertar, temp.getNext(), temp);
                    temp.getNext().setPrev(nuevo);
                    temp.setNext(nuevo);
                }else{
                    if(index==getLen()+1){
                        while (temp.getNext() != null ) {
                            temp = temp.getNext();
                        }
                        Node nuevo = new Node(insertar, null, temp);
                        temp.setNext(nuevo);
                    }else {
                        Node temp1 = new Node(insertar, top, null);
                        top.setPrev(temp1);
                    }
                }
            }
        }else{
            System.err.println("INDEX BOUND");
        }
    }

    /**
     * This function return the data of the element from the list
     * @param index
     * @return
     */
    public char getElement(int index){
        Node temp=top;
        int count=0;
        while(temp.getNext()!=null && count<index){
            temp=temp.getNext();
            count++;
        }
        return temp.getData();
    }

    /**
     * This function insert a element to the list after the last element of the list
     * @param insertar
     */
    public void insert(char insertar){
        Node temp=top;
        if (temp==null){
            top=new Node(insertar,null,null);
        }else{
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(new Node(insertar,null,temp));
        }
    }

    /**
     * This function insert at the first position on the list
     * @param insertar
     */
    public void preInsert(char insertar){
        Node temp=top;
        if(top==null){
            top=new Node(insertar,null,null);
        }else{
            top=new Node(insertar,temp,null);
        }
    }

    /**
     *This function delete a element from the linked list on a position "index"
     * @param index
     */
    public void deleteAt(int index){
        Node temp=top;
        Node prev=new Node();
        int count=0;
        if (!(index<0 || index > getLen())) {
            if(index!=0) {
                while (temp.getNext() != null && count < index) {
                    prev = temp;
                    temp = temp.getNext();
                    count++;
                }
                prev.setNext(temp.getNext());
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(prev);
                }
            }else{
                top=top.getNext();
            }

        }else{
            System.err.println("INDEX BOUND");
        }
    }



    public String deleteFromTo2(int index1,int index2){
        String letters="";
        if(((index1<=index2)&&index2<=getLen())&&index1>=0){
            int count=0;
            while(count<=index2-index1){
                if(getElement(index1)==' '){
                    letters+='_';
                }else {
                    letters += getElement(index1);
                }
                deleteAt(index1);
                count++;
            }
        }
        return letters;
    }

    /**
     *
     * @param a this function delete all the characters that are the same to "a"
     */
    public ArrayList <Integer> deleteAll(char a){
        ArrayList <Integer> positions=new ArrayList<>();
        int count =0;
        Node temp=top;
        if(top.getData()==a){
            temp=top.getNext();
            top=top.getNext();
            positions.add(count);
        }
        if(top!=null){
            while(temp.getNext()!=null){
                if(temp.getData()==a){
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                    positions.add(count);
                }
                count++;
                temp=temp.getNext();
            }
            if(temp.getData()==a){
                temp.getPrev().setNext(temp.getNext());
                positions.add(count);
            }
        }
        return  positions;
    }
    public ArrayList <Integer> deleteAll2(char a){
        Node temp=top;
        ArrayList<Integer> positions=new ArrayList<>();
        int count=0;
        while(temp.getNext()!=null){
            temp=temp.getNext();
            count++;
        }
        if(temp.getData()==a){
            temp.getPrev().setNext(null);
            positions.add(count);
        }
        while(temp.getPrev()!=null){
            if(temp.getData()==a&&temp.getNext()!=null){
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                positions.add(count);
            }
            count--;
            temp=temp.getPrev();
        }
        if(temp.getData()==a&&temp.getPrev()!=null){
            temp.getPrev().setNext(temp.getNext());
            positions.add(count);
        }
        return positions;
    }

    /**
     *
     * @param a
     * @param b this function replace all the characters "a" to characters "b" in the linked list
     */
    public ArrayList<Integer> replace(char a, char b){
        ArrayList <Integer> position=new ArrayList<>();
        Node temp=top;
        int count=0;
        if(top!=null){
            while(temp.getNext()!=null){
                if(temp.getData()==a) {
                    temp.setData(b);
                    position.add(count);
                }
                temp=temp.getNext();
                count++;
            }
            if(temp.getData()==a){
                temp.setData(b);
                position.add(count);
            }
        }
        return position;
    }

    /**
     * this function delete the linked list putting the head on null
     */
    public void deleteHead(){
        this.top=null;
    }

    /**
     *This function delete all the character from position "index1" to position "index2"
     * @param index1
     * @param index2
     */


    /**
     * This function apply the shift ASCII to the list
     * @param numCifer
     */
    public void shiftASCII(int numCifer){
        int character;
        char character1;
        Node temp=top;
        if(top!=null) {
            while (temp.getNext() != null) {
                character1 = temp.getData();
                character = (int) character1;
                character = character + numCifer;
                character1 = (char) character;
                temp.setData(character1);
                temp = temp.getNext();
            }
            character1 = temp.getData();
            character = (int) character1;
            character = character + numCifer;
            character1 = (char) character;
            temp.setData(character1);
        }else{
            System.err.println("Nothing to Cifer");
        }
    }

    /**
     * This function apply des-shift ASCII to the list
     * @param numCifer
     */
    public void desShiftASCII(int numCifer){
        int character;
        char character1;
        Node temp=top;
        if(top!=null) {
            while (temp.getNext() != null) {
                character1 = temp.getData();
                character = character1;
                character = character - numCifer;
                character1 = (char) character;
                temp.setData(character1);
                temp = temp.getNext();
            }
            character1=temp.getData();
            character=character1;
            character=character-numCifer;
            character1=(char)character;
            temp.setData(character1);
        }else{
            System.err.println("Nothing to Descifer");
        }
    }


    /**
     * This function print all the elements of the linked list
     */
    public void printList(){
        if(top!=null) {
            Node temp = top;
            int i = 0;
            while (temp.getNext() != null) {
                System.out.print("[" + i + "] " + temp.getData() + " ");
                temp = temp.getNext();
                i++;
            }
            System.out.print("[" + i + "]" + temp.getData() + " ");
        }
    }



}
