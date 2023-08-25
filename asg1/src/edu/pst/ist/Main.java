package edu.pst.ist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CashRegister c=new CashRegister();
        Scanner oldScanner=new Scanner(System.in);
        c.addItem(10.0);
        c.addItem(20.0);
        System.out.println(c.toString());
        c.undo();
        c.addItem(10.0);
        System.out.println(c.toString());
        c.undo();
        System.out.println(c.toString());
        c.clear();
        System.out.println(c.toString());


    }
}
