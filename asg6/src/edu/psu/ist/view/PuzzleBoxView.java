package edu.psu.ist.view;

import javax.swing.*;

public class PuzzleBoxView extends JFrame {

    public final PuzzleBoxForm form;

    public PuzzleBoxView(){
        this.form=new PuzzleBoxForm();
        JPanel content=this.form.getMyPanel();
        this.setContentPane(content);
        this.pack();

        this.setTitle("Puzzlin', Recurssin', n' Sortin'");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end constructor

}//end class
