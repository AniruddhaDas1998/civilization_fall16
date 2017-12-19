package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        //TODO
        super();
        Button move = new Button("Move");
        Button attack = new Button("Attack");
        super.addMenuItem(move);
        super.addMenuItem(attack);
        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameController.moving();
                GameController.updateResourcesBar();
            }
        });
        attack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameController.attacking();
                GameController.updateResourcesBar();
            }
        });
    }
}
