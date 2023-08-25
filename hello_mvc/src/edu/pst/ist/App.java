package edu.pst.ist;

import edu.pst.ist.controller.HelloAppController;
import edu.pst.ist.model.StringWapperClass;
import edu.pst.ist.view.HelloAppView;

public class App {

    public static void main(String[] args) {

        HelloAppView view=new HelloAppView();
        StringWapperClass model=new StringWapperClass();

        HelloAppController controller=new HelloAppController(model,view);

        view.setVisible(true);

    }

}
