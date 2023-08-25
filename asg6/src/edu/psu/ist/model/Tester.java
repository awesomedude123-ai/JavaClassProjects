package edu.psu.ist.model;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        PuzzleBox ne=new PuzzleBox();
        ne.addItemsTo(List.of(5,4,3,2,1));
        System.out.println(ne.toString());
        System.out.println(ne.numOfItems());
        System.out.println(ne.toString());
        ne.sort();
        System.out.println(ne.toString());
        ne.clear();
        System.out.println(ne);
        System.out.println("Here");

        /*
        System.out.println(ne.inDoubleOrder(List.of(0, 0 ,1, 1))); // true
        System.out.println(ne.inDoubleOrder(List.of(0, 1, 2, 2))); // false

        System.out.println(ne.inDoubleOrder(List.of("a", "a")));       // true
        System.out.println(ne.inDoubleOrder(List.of("a", "b")));       // false
        System.out.println(ne.inDoubleOrder(List.of("a")));          // false

        System.out.println(ne.inDoubleOrder(List.of(0, 0, 0)));    // false
        System.out.println(ne.inDoubleOrder(List.of(1, 1, 1, 1))); // true

        System.out.println(ne.inDoubleOrder(List.of(3, 3, 0, 0))); // false (not ascending)
        System.out.println(ne.inDoubleOrder(List.of(0, 0, 3, 3))); // true
        System.out.println(ne.inDoubleOrder(List.of(1, 2, 1, 2))); // false <- not ascending and pairs don't match
         */
    }
}
