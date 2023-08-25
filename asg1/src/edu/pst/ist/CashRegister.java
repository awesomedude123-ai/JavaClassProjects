package edu.pst.ist;

import java.util.ArrayList;

public class CashRegister {
    private int itemCount;
    private double totalPrice;
    private ArrayList<Double> lastItem=new ArrayList<>();

    // constructor omitted

    public void clear() { totalPrice = 0; lastItem.clear();itemCount=0;}

    public void addItem(double price) { totalPrice += price; lastItem.add(price);itemCount++;}

    public void undo(){
        if(lastItem.size()>0){
            totalPrice-=lastItem.get(lastItem.size()-1);
            lastItem.remove(lastItem.size()-1);//Removes the last time in the arraylist so that
        }
        if(itemCount>0){//checks to see if someone actually added an item before taking it out.
            // If they did not take an item, them the count stays 0, otherwise it did decrease by 0.
            itemCount--;
        }
    }

    public String toString(){
        return "reg: "+this.totalPrice+" - # of items: "+itemCount;
    }
}
