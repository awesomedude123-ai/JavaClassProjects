package edu.psu.ist.model;

import java.util.*;


/**
 * This class is implementing the SplittableList Interface.
 * It will consist of two lists that will have the values user adds to the list.
 * By utilizing the methods below, user can modify the lists.
 * Some of the methods will throw @Exception if they do not pass the check.
 * @name Sri Mukkamala
 * @param <T>
 */
public class UtilListImpl<T> implements ISplittableList<T>{

    //Used linked list for both lists because values are being added to the front of the list
    //More efficiency using LinkedList over ArrayList because only one node changes and has only one pointer. Done in O(1)
    private List<T> left=new LinkedList<>();
    private List<T> right=new LinkedList<>();

    private Map<T, Integer> countingMap=new HashMap<>();



    public UtilListImpl(){
        //Empty constructor so every other case except the "undo" copied list objects works in making the model object.
    }

    public UtilListImpl(ISplittableList<T> copiedList){
        ArrayList<T> a = new ArrayList<>(); //Made this array as a placeholder for values in copiedList
        while(copiedList.rightLength()>0){
            a.add(copiedList.removeFromRightAtFront());//Here, we are adding the elements in the right list of copied list to a.
        }
        for(int x=a.size()-1;x>=0;x--){
            //Since the right list is inverted (the first value entered becomes the last value in the list),
            // we add the last element first so that it matches the way the user entered the values
            addToRightAtFront(a.get(x));
        }
        a.clear();
        copiedList.moveToVeryBeginning(); //We are now getting all the values from the left list in copiedList to the right list so we can access it
        while(copiedList.rightLength()>0){
            a.add(copiedList.removeFromRightAtFront());
        }
        for(int x=0;x<a.size();x++){
            //Since the last value user enters becomes the first element in the right list,
            // if the user movesForward(), then the last value user enters also becomes first value of the left list.
            //Thus, we can add the values to the left list starting with index 0
            addToRightAtFront(a.get(x));
            moveForward();//This puts value in the left list
        }

        for(int x=0; x<this.left.size();x++){//Refills the copied list with its values
            copiedList.addToRightAtFront(this.left.get(x));
            copiedList.moveForward();
        }

        for(int x=this.right.size()-1;x>=0;x--){//Refills the copied list with its values
            copiedList.addToRightAtFront(this.right.get(x));
        }


    }//end "undo" constructor

    @Override
    public void addToRightAtFront(T e) {// O(1)
        this.right.add(0,e);
        if(countingMap.containsKey(e)){
            countingMap.put(e, countingMap.get(e)+1);
        }else{
            countingMap.put(e,1);
        }
    }//end addToRightAtFront method

    @Override
    public T removeFromRightAtFront() { //O(1)
        if(right.isEmpty()){
            throw new NoSuchElementException("There is no values in the list to remove. Please try again!");

        }
        T x=this.right.get(0);
        this.right.remove(0);
        int y=countingMap.get(x)-1;
        if(y==0){
            countingMap.remove(x);
        }else{
            countingMap.put(x,y);
        }
        return x;
    }//end removeFromRightAtFront method

    @Override
    public void moveToVeryBeginning() { //O(n)
        for(int i=0;i<this.left.size();i++){ //O(n)
            this.right.add(i,this.left.get(i));
        }
        this.left.clear();
    }//end moveToVeryBeginning method

    @Override
    public int countOf(T e) { //O(1)
        int count=0;
        if(countingMap.containsKey(e)){
            return countingMap.get(e);
        }
        return 0;
    }//end countOf method

    @Override
    public void moveForward() { //O(n)
            if(this.right.isEmpty()){
                throw new IllegalStateException("There is no next value. Please try again!");
            }else {
                T x=this.right.get(0);
                this.left.add(x); //O(n)
                this.right.remove(0);
            }
    }//end moveForward method

    @Override
    public int leftLength() { //O(1)
        return this.left.size();
    }//end leftLength method

    @Override
    public int rightLength() { //O(1)
        return this.right.size();
    }//end rightLength method

    @Override
    public void clear() { //O(1)
        this.right.clear();
        this.left.clear();
        this.countingMap.clear();
    }//end clear method

    @Override public String toString() { // O(n)
        StringBuilder sb = new StringBuilder("<");
        boolean first = true;
        for (T e : left) { // O(n) -- all calls to append(..) are O(1)
            // assuming you're just appending a fixed number of chars
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        sb.append("><");
        first = true;
        for (T e : right) { // O(n)
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        return sb.append(">").toString();
    }//end toString method


}
