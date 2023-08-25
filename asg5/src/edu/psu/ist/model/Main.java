package edu.psu.ist.model;

public class Main {
    public static void main(String[] args) {
        ISplittableList<Integer> b =
                new UtilListImpl<>();
        System.out.println(b);                // should print: <><>

        b.addToRightAtFront(3);
        System.out.println(b);                // should print: <><3>

        b.addToRightAtFront(2);
        System.out.println(b);                // <><2, 3>

        b.addToRightAtFront(1);
        System.out.println(b);                // <><1, 2, 3>


        System.out.println("\n\n\n");
        ISplittableList<Integer> copied=new UtilListImpl<>(b);

        System.out.println(copied);                // should print: <><>

        copied.addToRightAtFront(3);
        System.out.println(copied);                // should print: <><3>

        copied.addToRightAtFront(2);
        System.out.println(copied);                // <><2, 3>

        copied.addToRightAtFront(1);
        System.out.println(copied);                // <><1, 2, 3>

        copied.moveForward();
        System.out.println(copied);                // <1><2, 3>

        copied.moveForward();
        System.out.println(copied);                // <1, 2><3>

        copied.moveForward();
        System.out.println(copied);                // <1, 2, 3><>

        copied.moveToVeryBeginning();
        System.out.println(copied);                // <><1, 2, 3>

        int x = copied.removeFromRightAtFront();   // x now holds val. 1
        System.out.println(copied);                // <><2, 3>

        copied.clear();
        System.out.println(copied);                // <><>
    }
}
