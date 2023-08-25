package edu.pst.ist.view;

import javax.swing.*;

public class HelloAppView extends JFrame {

    public HelloAppForm form;

    public HelloAppView(){
        this.form= new HelloAppForm();
        JPanel content=form.getMyPanel();

        this.setContentPane(content);

        this.pack();

        this.setTitle("Hello App!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
