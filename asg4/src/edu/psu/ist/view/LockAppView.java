package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class LockAppView extends JFrame {
    private LockForm form;

    public LockAppView(){
        this.form=new LockForm();
        JPanel content=form.getMyPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(300,300));
        this.pack();

        this.setTitle("Dial Lock App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LockForm form(){
        return form;
    }
}
