package edu.psu.ist;

import edu.psu.ist.controller.LockAppController;
import edu.psu.ist.model.IDialLock;
import edu.psu.ist.model.TrLockImpl;
import edu.psu.ist.view.LockAppView;

public class App {

    public static void main(String[] args) {

        //Testing the entire app by initializing a model and making a new view.

        IDialLock model = new TrLockImpl(7,3,1,5);
        LockAppView view=new LockAppView();

        LockAppController controller=new LockAppController(view, model);

        view.setVisible(true);
    }

}
