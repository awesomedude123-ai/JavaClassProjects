package edu.psu.ist.controller;

import edu.psu.ist.model.IProducer;
import edu.psu.ist.model.PuzzleBox;
import edu.psu.ist.view.PuzzleBoxView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PuzzleBoxController {

    private PuzzleBox model;
    private PuzzleBoxView view;

    public PuzzleBoxController(PuzzleBox model, PuzzleBoxView view){
        this.model=model;
        this.view=view;

        this.view.setSize(400,300);


        //Pre-set values according to directions
        this.view.form.getNumberOfValuesTextField().setText("0");
        this.view.form.getClearButton().setEnabled(false);
        this.view.form.getDoubleOrderedButton().setEnabled(false);
        this.view.form.getSortButton().setEnabled(false);


        this.view.form.getClearButton().addActionListener(x -> {
            this.model.clear();
            this.view.form.getNumberOfValuesTextField().setText("0");
            //Since PuzzleBox list is cleared, these options are no longer viable to list
            this.view.form.getAddedValues().setText("");
            this.view.form.getClearButton().setEnabled(false);
            this.view.form.getDoubleOrderedButton().setEnabled(false);
            this.view.form.getSortButton().setEnabled(false);
        });

        this.view.form.getSortButton().addActionListener(x -> {
            this.model.sort();
            this.view.form.getAddedValues().setText(this.model.toString());
        });


        this.view.form.getRandomizeButton().addActionListener(x -> {
            IProducer<Integer> iProducer=new IProducer<Integer>() {
                @Override
                public Integer produce() {//Provide produce method a body to use when called
                    int y=(int) (Math.random()*10);
                    return y;
                }
            };
            this.model.randomlyPopulate(iProducer);
            this.view.form.getNumberOfValuesTextField().setText(this.model.numOfItems() + "");
            //Since PuzzleBox list is populated, these options are all viable for user.
            this.view.form.getAddedValues().setText(this.model.toString());
            this.view.form.getClearButton().setEnabled(true);
            this.view.form.getDoubleOrderedButton().setEnabled(true);
            this.view.form.getSortButton().setEnabled(true);
        });


        this.view.form.getClearAndAddNewButton().addActionListener( x -> {
            String value=this.view.form.getAddedValues().getText();
            List<String> values=getTextFieldContents(value);
            this.model.clear();//Clear current values in the list
            if(!values.isEmpty()){//Makes sure values has elements to be added to list.
                this.model.addItemsTo(values);
                //Since PuzzleBox list is populated, these options are all viable for user.
                this.view.form.getNumberOfValuesTextField().setText(this.model.numOfItems() + "");
                this.view.form.getClearButton().setEnabled(true);
                this.view.form.getDoubleOrderedButton().setEnabled(true);
                this.view.form.getSortButton().setEnabled(true);
            }

        });

        this.view.form.getDoubleOrderedButton().addActionListener(x -> {
            boolean value=this.model.inDoubleOrder();
            if(value==false){//Depending on the result of the method will a different message pop up.
                JOptionPane.showMessageDialog(this.view.form.getMyPanel(),"False: The list is not double ordered", "Failure",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this.view.form.getMyPanel(), "True: The list is double ordered", "Success",JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }//end controller

    private List<String> getTextFieldContents(String textFieldStr) {
        List<String> result = new ArrayList<>();

        // want to split on one or more whitespace chars
        for (String s : textFieldStr.split("\\s+")) {
            s = s.trim(); // clean up the string, then verify (below)
            if (s.isEmpty() || s.isBlank() || s.contains(" ")) {
                JOptionPane.showMessageDialog(view,
                        "Invalid pattern: must be a " +
                                "whitespace delimited list");
                return new ArrayList<>();
            }
            result.add(s);
        }
        return result;
    }

}
