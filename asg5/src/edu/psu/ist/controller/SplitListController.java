package edu.psu.ist.controller;

import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;
import java.util.Stack;

/**
 * Controller class will be implementing both the model and the view class.
 * Will take user action(pressing button, entering a value) and conduct necessaru action of the specific button.
 * In each button, current model object will be passed into UtilListImpl constructor to make copied list which will be pushed into an undo stack.
 * Additionally, try-catch statements have been implemented for buttons that may throw exceptions due to check.
 * Each change made to the list is shown in the labels of leftLength, rightLength, listValue.
 */
public class SplitListController {

    private ISplittableList<String> model;
    private SplitListView view;

    private Stack<ISplittableList<String>> undoStack=new Stack<>();



    public SplitListController(ISplittableList<String> model, SplitListView view){
        this.view=view;
        this.model=model;

        this.view.setSize(500,260);//setting size of view so user does not have to resize manually

        this.view.form.getListValueLabel().setText(model.toString());

        this.view.form.getAddToRightAtButton().addActionListener(x -> {
            ISplittableList<String> copied = new UtilListImpl<>(this.model);//Passes the model before it is changed to something new and create copied version
            undoStack.push(copied); //copied version pushed onto the stack
            String y=this.view.form.getValueTextField().getText();
            if(y.isBlank() || y.isEmpty()){
                JOptionPane.showMessageDialog(this.view, "Enter a value into the text field provided","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                this.model.addToRightAtFront(y);
                this.view.form.getListValueLabel().setText(this.model.toString());
                this.view.form.getRightLenTextValue().setText(this.model.rightLength()+"");
                this.view.form.getLeftLenTextValue().setText(this.model.leftLength()+"");
                this.view.form.getValueTextField().setText("");
            }
        });


        this.view.form.getCountOfButton().addActionListener(x -> {
            String strOfCount=this.view.form.getValueTextField().getText().toString();
            if(strOfCount.isEmpty() || strOfCount.isBlank()){
                JOptionPane.showMessageDialog(this.view,"Enter a value into the text field provided","Error",JOptionPane.ERROR_MESSAGE);
            }else {
                int numOfValues = this.model.countOf(strOfCount);
                JOptionPane.showMessageDialog(this.view, "The number of " + strOfCount + " in the list is: " + numOfValues);
                this.view.form.getValueTextField().setText("");
            }
            });


        this.view.form.getClearButton().addActionListener(x -> {
            if(this.model.rightLength()!=0 || this.model.leftLength()!=0){
                //Check to see if the model is not empty so an empty stack is not added unnecessarily
                ISplittableList<String> copied = new UtilListImpl<>(this.model);
                undoStack.push(copied);
            }
            this.model.clear();
            this.view.form.getListValueLabel().setText(this.model.toString());
            this.view.form.getRightLenTextValue().setText(this.model.rightLength()+"");
            this.view.form.getLeftLenTextValue().setText(this.model.leftLength()+"");
            this.view.form.getValueTextField().setText("");
        });

        this.view.form.getMoveForwardButton().addActionListener(x -> {
            if(this.model.rightLength()!=0 || this.model.leftLength()!=0){
                ISplittableList<String> copied = new UtilListImpl<>(this.model);
                undoStack.push(copied);
            }
            try{
                this.model.moveForward();
                this.view.form.getListValueLabel().setText(this.model.toString());
                this.view.form.getValueTextField().setText("");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this.view,"List is empty. Please add some values to the list","Error",JOptionPane.ERROR_MESSAGE);
            }
            this.view.form.getRightLenTextValue().setText(this.model.rightLength()+"");
            this.view.form.getLeftLenTextValue().setText(this.model.leftLength()+"");
        });

        this.view.form.getMoveToBeginningButton().addActionListener(x -> {
            if(this.model.rightLength()!=0 || this.model.leftLength()!=0){
                //Check to see if the model is not empty so an empty stack is not added unnecessarily
                ISplittableList<String> copied = new UtilListImpl<>(this.model);
                undoStack.push(copied);
            }
            this.model.moveToVeryBeginning();
            this.view.form.getListValueLabel().setText(this.model.toString());
            this.view.form.getRightLenTextValue().setText(this.model.rightLength()+"");
            this.view.form.getLeftLenTextValue().setText(this.model.leftLength()+"");
            this.view.form.getValueTextField().setText("");
        });

        this.view.form.getRemoveFromRightAtButton().addActionListener(x -> {
            if(this.model.rightLength()!=0 || this.model.leftLength()!=0){
                ISplittableList<String> copied = new UtilListImpl<>(this.model);
                undoStack.push(copied);
            }
            try{
                String removedValue=this.model.removeFromRightAtFront();
                this.view.form.getListValueLabel().setText(this.model.toString());
                this.view.form.getValueTextField().setText("");
                this.view.form.getLastRemovedValue().setText(removedValue);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this.view,"List is empty. Please add some values to the list","Error",JOptionPane.ERROR_MESSAGE);
            }
            this.view.form.getRightLenTextValue().setText(this.model.rightLength()+"");
            this.view.form.getLeftLenTextValue().setText(this.model.leftLength()+"");
        });

        this.view.form.getUndoButton().addActionListener(x -> {
            if(undoStack.empty()){
                JOptionPane.showMessageDialog(this.view, "There is nothing to Undo","Error Message",JOptionPane.ERROR_MESSAGE);
            }else{
                this.model=undoStack.pop();
                this.view.form.getListValueLabel().setText(this.model.toString());
                this.view.form.getRightLenTextValue().setText(this.model.rightLength()+"");
                this.view.form.getLeftLenTextValue().setText(this.model.leftLength()+"");
                this.view.form.getValueTextField().setText("");
            }
        });
    }//end the constructor

}
