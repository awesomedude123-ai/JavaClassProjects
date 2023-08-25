package edu.pst.ist.model;

public class StringWapperClass {

    private String myWrappedString="Hi everyone";

    public StringWapperClass(){

    }

    public String getText(){
        return this.myWrappedString;
    }

    public void reverse(){
        this.myWrappedString = new StringBuilder(myWrappedString).reverse().toString();
    }

}
