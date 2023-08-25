package edu.psu.ist.view;

import javax.swing.*;


/**
 * In this class, we created the view which will hold the frame and its content.
 * Using the ListForm instance to get the form and content.
 */
public class SplitListView extends JFrame {

    public final SplitListForm form;

    public SplitListView(){
        this.form=new SplitListForm();
        JPanel content=this.form.getMyPanel();
        this.setContentPane(content);
        this.pack();

        this.setTitle("Splittable Madness");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
