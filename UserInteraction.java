package src;



public class UserInteraction {
    /**
     *
     * @param list this is the list to apply the comands
     *             and this function print all the comands to the user, and use the function checkComand() to be sure of
     *             the comand is right
     */
    public static String menuComands(DoubleLinkedList list,int num){
        if(num!=0) {
            System.out.println("___________________________________________________________________________________________________________________________________________________________");
            System.out.println("These comands can you do:\nb \"string\" #position\nr #positionInicial #positionFinal\nh for help");
            System.out.println("d #character to delete\nf #characterReplaced #characterToReplace\nz randomExecutions \nce #number to shift ASCII \ndc #number to des-shift ASCII  \nQ for quit and save");
            System.out.println("c #start positiion to copy #end position to copy\np #start position to paste\nx #start position to cut #end position to cut");
        }
        System.out.println("This is your list for now");
        list.printList();
        System.out.println();
        String answer=IO.inputString("Which comand do you want to do?");
        boolean comandChecked=checkComand(answer,list);
        if (comandChecked){
            return  answer;
        }else{
            System.err.println("This comands is no right");
            return menuComands(list,0);
        }
    }

    /**
     *
     * @param comand this is the comand to check
     * @param list this is the list to apply the comand
     * @return true if the comand is right but if the comand is not right return false
     */
    public static boolean checkComand(String comand, DoubleLinkedList list){
        String [] copy= comand.split(" ");
        boolean firstPart=false;
        boolean secondPart=false;
        boolean thirdPart=false;
        int number;
        int number2;
        if(copy.length<=3&&copy.length>0){
            switch (copy[0]) {
                case "b":
                    firstPart = true;
                    try {
                        number = Integer.parseInt(copy[2]);
                        if (number >= 0) {
                            secondPart = true;
                            thirdPart = true;
                        }
                    } catch (Exception e) {
                        System.err.println("The comand is no right");
                    }
                    break;

                case "r":
                    firstPart = true;
                    try {
                        number = Integer.parseInt(copy[1]);
                        number2 = Integer.parseInt(copy[2]);
                        if (number >= 0 && number2 >= 0 && number2 >= number) {
                            secondPart = true;
                            thirdPart = true;
                        } else {
                            System.err.println("The comand is no right");
                        }
                    } catch (Exception e) {
                        System.err.println("The comand is no right");
                    }
                    break;

                case "h":
                    firstPart = true;
                    thirdPart = true;
                    secondPart = true;
                    UserInteraction.menuComands(list,1);
                    break;

                case "d":
                    firstPart = true;
                    if (copy[1].length() == 1) {
                        thirdPart = true;
                        secondPart = true;
                    }
                    break;

                case "f":
                    firstPart = true;
                    if (copy.length==3){
                        if ((copy[1].length() == 1 && copy[2].length() == 1)) {
                            secondPart = true;
                            thirdPart = true;
                        }
                    }
                    break;

                case "z":
                    firstPart=true;
                    secondPart=true;
                    thirdPart=true;
                    break;
                case "Q":
                    firstPart=true;
                    secondPart=true;
                    thirdPart=true;
                    break;
                case "q":
                    firstPart=true;
                    secondPart=true;
                    thirdPart=true;
                    break;
                case "ce":
                    firstPart=true;
                    thirdPart=true;
                    try{
                        int number5;
                        number2=Integer.parseInt(copy[1]);
                        secondPart=true;
                    }catch (Exception e){
                        System.err.println("the comands is no right");
                    }
                    break;
                case "dc":
                    firstPart=true;
                    thirdPart=true;
                    try{
                        int number5;
                        number5=Integer.parseInt(copy[1]);
                        secondPart=true;
                    }catch (Exception e){
                        System.err.println("the comands is no right");
                    }
                    break;
                case "c":
                    firstPart=true;
                    try{
                        number2=Integer.parseInt(copy[1]);
                        number=Integer.parseInt(copy[2]);
                        thirdPart=true;
                        secondPart=true;
                    }catch(Exception e){
                        System.err.println("The comand is no right");
                    }
                    break;
                case "x":
                    try{
                        firstPart=true;
                        number2=Integer.parseInt(copy[1]);
                        number=Integer.parseInt(copy[2]);
                        thirdPart=true;
                        secondPart=true;
                    }catch(Exception e){
                        System.err.println("The comand is no right");
                    }
                    break;
                case "p":
                    firstPart=true;
                    try{
                        number=Integer.parseInt(copy[1]);
                        secondPart=true;
                        thirdPart=true;
                    }catch (Exception e){
                        System.err.println("The comand is no right");
                    }
                    break;

                    default:
                        firstPart=false;
                        secondPart=false;
                        thirdPart=false;
                        System.err.println("The comand is no right");
                        break;
            }
        }
        return (firstPart&&secondPart)&&thirdPart;
    }

}
