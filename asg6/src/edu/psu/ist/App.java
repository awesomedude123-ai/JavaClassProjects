package edu.psu.ist;


import edu.psu.ist.controller.PuzzleBoxController;
import edu.psu.ist.model.PuzzleBox;
import edu.psu.ist.view.PuzzleBoxView;

public class App {
    public static void main(String[] args) {
        PuzzleBox<String> model=new PuzzleBox<>();
        PuzzleBoxView view=new PuzzleBoxView();
        PuzzleBoxController controller=new PuzzleBoxController(model,view);
        view.setVisible(true);
    }//end main method



}
