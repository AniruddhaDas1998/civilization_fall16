package view;

import controller.GameController;
import model.Convertable;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        //TODO
        super();
        Button move = new Button("Move");
        Button convert = new Button("Convert");
        super.addMenuItem(move);
        super.addMenuItem(convert);
        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameController.moving();
                GameController.updateResourcesBar();
            }
        });
        convert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GameController.getLastClicked().getTile().getOccupant()
                        instanceof Convertable && ((Convertable)
                         GameController.getLastClicked().getTile()
                        .getOccupant()).canConvert(GameController
                        .getLastClicked()
                        .getTile().getType())) {
                    GameController.getLastClicked()
                        .getTile().setOccupant(((Convertable)
                         GameController.getLastClicked().getTile()
                        .getOccupant()).convert());
                    Media casReg = new Media(getClass()
                        .getResource("Convert.mp3").toString());
                    playMedia(casReg);
                    GameController.getLastClicked().updateTileView();
                    GameController.updateResourcesBar();
                } else {
                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                    newAlert.setHeaderText("Unable to convert. :(");
                    newAlert.setTitle("Oops!");
                    newAlert.showAndWait();
                    GameController.updateResourcesBar();
                }
            }
        });
    }
    private void playMedia(Media m) {
        if (m != null) {
            MediaPlayer mp = new MediaPlayer(m);
            mp.play();
        }
    }
}
