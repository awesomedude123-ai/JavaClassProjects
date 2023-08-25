package edu.psu.ist.inheritance;

public class Tester {
    public static void main(String[] args) {
        SuperClass c=new SuperClass();
        SubClassOne s = new SubClassOne();
        SubClassTwo k = new SubClassTwo();

        SuperClass s1=new SubClassOne();
        SuperClass k1=new SubClassTwo();
        s1.eat();
        s1.sleep();
        s.free();
        k.high();
        k1.sleep();
        k1.eat();

    }
}
