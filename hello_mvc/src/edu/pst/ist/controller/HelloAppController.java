package edu.pst.ist.controller;

import edu.pst.ist.model.StringWapperClass;
import edu.pst.ist.view.HelloAppView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HelloAppController {
    private HelloAppView view;
    private StringWapperClass model;

    public HelloAppController(StringWapperClass model, HelloAppView view){
        //this code runs once
        this.view=view;
        this.model=model;

        this.view.form.getTextValueLabel().setText(model.getText());



        this.view.form.getCheckNumberButton().setEnabled(false);


        this.view.form.getReverseTextButton().addActionListener(e -> {
            //lambda expression for the action event method
            this.model.reverse();
            this.view.form.getTextValueLabel().setText(model.getText());});

        this.view.form.getNumberTextField().
                getDocument()
                .addDocumentListener(new MyNumberValidatingListener());


        /*
        this.view.form.getCheckNumberButton().addActionListener(e -> {
            if(isValidNum(this.view.form.getNumberTextField().getText())==false){
                JOptionPane.showMessageDialog(view,"ERR: Number accepts power numbers","ERR",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(view,"This is acceptable");
            }
        });*/


    }//end constructor

    public class MyNumberValidatingListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            activateButton(view.form.getNumberTextField().getText());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            activateButton(view.form.getNumberTextField().getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            activateButton(view.form.getNumberTextField().getText());
        }
    }

    private void activateButton(String text){
        this.view.form.getCheckNumberButton().setEnabled(isValidNum(text));
    }

    private boolean isValidNum(String numberStr){
        try {
            int y = Integer.parseInt(this.view.form.getNumberTextField().getText());
            return y > 0;
        }catch(Exception x){
            return false;
        }
    }


}
