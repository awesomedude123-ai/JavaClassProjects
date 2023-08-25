package edu.psu.ist.model;

public final class Turn {
    enum Direction{L,R};

    public Direction dir;
    public int stopDigit;


    public Turn(Direction dir, int stopDigit){
        this.dir=dir;
        this.stopDigit=stopDigit;
    }

    @Override
    public String toString() {
        return String.format("%s-%d",dir,stopDigit);
    }
}
