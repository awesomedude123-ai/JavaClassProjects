package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * In this class, we implement a variety of methods to create a Puzzle Box object. With this object, we can add items, sort items, clear items, check items,
 * and randomize the items in the box. PuzzleBox object is a generic class that takes a data that is Comparable
 * To modify the object, we are using a list which is a dynamic type of LinkedList.
 * @param <T>
 */
public class PuzzleBox<T extends Comparable<T>> {
    private List<T> list;

    public PuzzleBox(){
        list=new LinkedList<>();
    }


    //addItemsTo method: We add the items that have been passed into the method into this.list
    public void addItemsTo(List<T> passedItem){
        for (T i: passedItem){
            this.list.add(i);
        }
    }//end addItemsTo method

    //toString method: Prints the values in a format required by the user
    @Override
    public String toString() {
        String answer="";
        for(T i:this.list){
            answer+=(i+" ");
        }
        return answer.trim();
    }//end toString method

    //clear method: Recursively removes the first element in the list until no elements remain
    public void clear(){
        if(this.list.isEmpty()){
            return;
        }else{
            this.list.remove(0);
            clear();
        }
    }//end clear method


    //numOfItems method: Recursively removes the first element in the list to get the number of elements are in it. Then re-adds elements into list and returns count
    public int numOfItems(){
        int value=0;
        List<T> placeHolder=new ArrayList<>();
        for(T i: this.list){
            placeHolder.add(i);
        }//Each recurssive call, will make a placeHolder list and add the element in this.list so elements are stored.
        if(this.list.isEmpty()){
            return 0;
        }else{
            this.list.remove(0);
            value=1+numOfItems();
            //Remove an element until this.list is size 0. Add 1 to each call so size of the list will be added
        }
        //since placeholder has all elements from original list, just cleared the list and added the elements into it from placeHolder.
        this.list.clear();
        for(T i: placeHolder){
            this.list.add(i);
        }
        return value;
    }//end numOfItems method


    //Swaps the positions of consecutive elements if the first element is bigger than the second. Theoretically, after each loop of the while loop,
    //this.list elements should be in different order than before the loop started, kept in aList. This means the list is still changing.
    //Once, aList and this.list(after running through the for loop) are exact same, then this.list is finished sorting and will leave the while loop.
    public void sort(){//O(n^2)
        ArrayList<T> aList=new ArrayList<>();
        while(!aList.equals(this.list)){//Checks if aList equal to this.list
            aList=new ArrayList<>();
            for(T x: this.list){
                aList.add(x);//add values in this.list order to aList.
            }//end for loop
            for(int i=0;i<=this.list.size()-2;i++){
                if(this.list.get(i).compareTo(this.list.get(i+1))>0 && this.list.get(i).toString().length()==this.list.get(i+1).toString().length() ||
                        (this.list.get(i).toString().length()>this.list.get(i+1).toString().length())){
                    /*
                    Checks to see if first element larger than next element and if the length of the strings are equal. This way, numbers like 1,2,3, etc
                    are compared correctly. Numbers like 10,11,12,etc are compared differently as strings and thus, if compared to 1,2,3, need to be
                    compared using lengths.
                     */
                    Collections.swap(this.list,i,i+1);//Swaps the position of the two values.
                }//changes the order of this.list if list is not sorted
            }//end for loop
        }

    }//end sort method


    //inDoubleOrder method: Calling method which is used for simple input. Checks to see if list is odd since odd list can never be double ordered.
    public boolean inDoubleOrder(){
        if(list.size()%2==1){ //If list is odd, then automatically return false since it cannot be double ordered
            return false;
        }else{
            return realInDoubleOrder(list,0,list.get(0));
        }
    }//end inDoubleOrder method


    //Helper Method for inDoubleOrder: Takes in list, index, and lastNum. Checks to see if the current index and one after it. If it is the same, then add
    //2 to the index for next pair and set lastNum to current value. If not, return false.
    private boolean realInDoubleOrder(List<T> li, int index,T lastNum){
        if(li.get(index).compareTo(li.get(index+1))==0 && li.get(index).compareTo(lastNum)>=0){
            //Checking to see if the pair of numbers are equal and if the last number is smaller than the current index number
            if(index==li.size()-2){
                //If passes through each pair, then returns true since it is double ordered
                return true;
            }else{
                //If index not close to end, then rerun the method
                return realInDoubleOrder(li, index+2,li.get(index));
            }
        }else{
            //If last num is larger or pair of numbers not equal, then automatically the list in not double ordered.
            return false;
        }
    }


    //randomlyPopulate method: takes in IProducer interface object and generates random value from its produce() method. Adds value to list.
    public void randomlyPopulate(IProducer<T> itemProducer){
        this.list.clear();
        for(int i=0;i<8;i++){
            T generatedItem=itemProducer.produce();//Runs method that is created when object is created.
            this.list.add(generatedItem);
        }
    }//end randomlyPopulate method

}