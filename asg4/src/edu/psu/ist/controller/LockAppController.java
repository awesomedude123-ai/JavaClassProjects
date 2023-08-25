package edu.psu.ist.controller;

import edu.psu.ist.model.IDialLock;
import edu.psu.ist.view.LockAppView;

import javax.swing.*;
import java.awt.*;

public class LockAppController {

    private LockAppView view;
    private IDialLock model;

    public LockAppController(LockAppView view, IDialLock model){
        this.view=view;
        this.model=model;


        view.form().getLockStatusLabel().setText("Locked "+model.toString());
        view.form().getLockStatusLabel().setForeground(Color.red);

        view.form().getCurrentTickLabel().setText(model.currentTick() + "");


        view.form().getRightButton().addActionListener(e -> {
            model.right(1);
            view.form().getCurrentTickLabel().setText(model.currentTick()+"");
        });

        view.form().getLeftButton().addActionListener(e -> {
            model.left(1);
            view.form().getCurrentTickLabel().setText(model.currentTick()+"");
        });

        view.form().getPullButton().addActionListener(e -> {
            boolean x = model.pull();
            if(x==false){
                JOptionPane.showMessageDialog(view,"Wrong secret combination.Please reset and try it again");
                view.form().getLockStatusLabel().setForeground(Color.red);
            }else{
                view.form().getLockStatusLabel().setText("Unlocked "+model.toString());
                view.form().getLockStatusLabel().setForeground(Color.green);
            }

        });

        view.form().getResetButton().addActionListener( e -> {
            model.reset();
            view.form().getCurrentTickLabel().setText(model.currentTick()+"");
            view.form().getLockStatusLabel().setText("Locked "+model.toString());
            view.form().getLockStatusLabel().setForeground(Color.red);
        });




    }

}
