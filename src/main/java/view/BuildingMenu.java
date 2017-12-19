

package view;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import controller.GameController;
import model.Building;
import model.Settlement;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
     * there should be an invest and demolish button for this menu
     * as well as functions associated with the buttons
     */
    public BuildingMenu() {
        super();
        Button invest = new Button("Invest");
        Button demolish = new Button("Demolish");
        super.addMenuItem(invest);
        super.addMenuItem(demolish);
        invest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GameController.getCivilization().getTreasury()
                    .getCoins() >= 25) {
                    ((Building) (GameController.getLastClicked().getTile()
                                 .getOccupant())).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                    GameController.updateResourcesBar();
                    Media casReg = new Media(getClass()
                        .getResource("chaching.mp3").toString());
                    playMedia(casReg);
                } else {
                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                    newAlert.setHeaderText("Unable to invest. :(");
                    newAlert.setTitle("Oops!");
                    newAlert.showAndWait();
                    GameController.updateResourcesBar();
                }
            }
        });
        demolish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GameController.getCivilization().getNumSettlements() > 1
                    && (GameController.getLastClicked().getTile()
                        .getOccupant() instanceof Settlement)) {
                        Building b = (Building) (GameController.getLastClicked()
                                                 .getTile().getOccupant());
                        b.demolish();
                        Media casReg = new Media(getClass()
                            .getResource("Demolish.mp3").toString());
                        playMedia(casReg);
                        GameController.getCivilization()
                            .decrementNumSettlements();
                        GameController.getLastClicked().getTile()
                            .setOccupant(null);
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }   else if (GameController.getCivilization()
                            .getNumSettlements() <= 1
                                 && (GameController.getLastClicked().getTile()
                                     .getOccupant() instanceof Settlement)) {
                        Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                        newAlert.setHeaderText("You cannot destroy"
                            + " your Last Settlement!");
                        newAlert.setTitle("Oops!");
                        newAlert.showAndWait();
                        GameController.updateResourcesBar();
                    }   else {
                        Building b = (Building) (GameController
                                                    .getLastClicked()
                                                    .getTile().getOccupant());
                        b.demolish();
                        Media casReg = new Media(getClass()
                            .getResource("Demolish.mp3").toString());
                        playMedia(casReg);
                        GameController.getLastClicked()
                            .getTile().setOccupant(null);
                        GameController.getLastClicked().updateTileView();
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
