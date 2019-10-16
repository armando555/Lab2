package src;

import java.util.Hashtable;

public class ClipBoard {
    private Hashtable<Integer,DoubleLinkedList> hash;

    /**
     * this is the construct of the ClipBoard and inicialize the hashtable
     */
    public ClipBoard(){
        this.hash=new Hashtable<>();
    }

    /**
     * This function put in the hashTable the list at the n key
     * @param n
     * @param list
     */
    public void copy(int n, DoubleLinkedList list){
        hash.put(n,list);
    }

    /**
     * This function get the list from the hastable at the n key
     * @param n
     * @return
     */
    public DoubleLinkedList paste(int n){
        return hash.get(n);
    }

    /**
     * This function get the list from hashtable with the key n
     * @param n
     * @return
     */
    public String show(int n){
        return "ClibBoard["+n+"]==>{"+hash.get(n).toString()+"}";
    }
}
