package edu.psu.ist.view;

import javax.swing.*;

public class SplitListForm {
    private JPanel MyPanel;
    private JLabel listValueLabel;
    private JTextField valueTextField;
    private JButton addToRightAtButton;
    private JButton removeFromRightAtButton;
    private JLabel lastRemovedValue;
    private JButton moveForwardButton;
    private JButton moveToBeginningButton;
    private JLabel rightLenTextValue;
    private JButton clearButton;
    private JLabel leftLenTextValue;
    private JButton countOfButton;
    private JButton undoButton;
    private JLabel rightLenLabel;

    public JTextField getValueTextField() {
        return valueTextField;
    }

    public JPanel getMyPanel() {
        return MyPanel;
    }

    public JLabel getListValueLabel() {
        return listValueLabel;
    }

    public JButton getAddToRightAtButton() {
        return addToRightAtButton;
    }

    public JButton getRemoveFromRightAtButton() {
        return removeFromRightAtButton;
    }

    public JLabel getLastRemovedValue() {
        return lastRemovedValue;
    }

    public JButton getMoveForwardButton() {
        return moveForwardButton;
    }

    public JButton getMoveToBeginningButton() {
        return moveToBeginningButton;
    }

    public JLabel getRightLenTextValue() {
        return rightLenTextValue;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JLabel getLeftLenTextValue() {
        return leftLenTextValue;
    }

    public JButton getCountOfButton() {
        return countOfButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JLabel getRightLenLabel() {
        return rightLenLabel;
    }
}
