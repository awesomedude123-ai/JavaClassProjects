package edu.psu.ist.view;

import javax.swing.*;

public class LockForm {
    private JPanel myPanel;
    private JButton rightButton;
    private JButton leftButton;
    private JButton pullButton;
    private JButton resetButton;
    private JLabel lockStatusLabel;
    private JLabel currentTickLabel;

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JLabel getLockStatusLabel() {
        return lockStatusLabel;
    }

    public JLabel getCurrentTickLabel() {
        return currentTickLabel;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getPullButton() {
        return pullButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
}
