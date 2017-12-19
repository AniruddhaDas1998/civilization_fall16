package view;

import controller.GameController;
import model.Unit;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    private ListView<String> recruits;
    private Button sel;
    public RecruitMenu() {
        ObservableList<String> items = FXCollections.observableArrayList(
            "Melee Unit", "Range Unit", "Hybrid Unit", "Siege Unit",
            "Settlers", "Farmers", "Coal Miners", "Anglers", "Master Builders");
        recruits = new ListView<>(items);
        sel = new Button("Select");
        recruits.setMaxWidth(130.0);
        super.addMenuItem(recruits);
        super.addMenuItem(sel);
        sel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean rec = false;
                    if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Melee Unit")) {
                        Unit m = GameController.getCivilization()
                            .getMeleeUnit();
                        if (m.isAffordable()) {
                            m.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(m);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Range Unit")) {
                        Unit r = GameController.getCivilization()
                            .getRangedUnit();
                        if (r.isAffordable()) {
                            r.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(r);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Hybrid Unit")) {
                        Unit h = GameController.getCivilization()
                            .getHybridUnit();
                        if (h.isAffordable()) {
                            h.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(h);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Siege Unit")) {
                        Unit s = GameController.getCivilization()
                            .getSiegeUnit();
                        if (s.isAffordable()) {
                            s.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(s);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Settlers")) {
                        TextInputDialog dialog = new
                            TextInputDialog("Settlement Name");
                        dialog.setTitle("A New Settlement");
                        dialog.setHeaderText("You Have Recruited a Settlers");
                        dialog.setContentText("Enter the Name of "
                            + "Your Settlement: ");
                        Optional<String> result = dialog.showAndWait();
                        Unit s = GameController.getCivilization()
                            .getSettlerUnit(result.get());
                        if (s.isAffordable()) {
                            s.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(s);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                            if (result.isPresent()) {
                                GameController.getLastClicked().getTile()
                                    .setOccupant(GameController
                                            .getCivilization()
                                                .getSettlerUnit(result.get()));
                            }
                        }
                        GameController.getLastClicked().updateTileView();
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Farmers")) {
                        Unit f = GameController.getCivilization()
                            .getFarmerUnit();
                        if (f.isAffordable()) {
                            f.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3")
                                .toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(f);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Coal Miners")) {
                        Unit c = GameController.getCivilization()
                            .getCoalMinerUnit();
                        if (c.isAffordable()) {
                            c.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(c);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Anglers")) {
                        Unit a = GameController.getCivilization()
                            .getAnglerUnit();
                        if (a.isAffordable()) {
                            a.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(a);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    } else if (recruits.getSelectionModel().getSelectedItem()
                        .equals("Master Builders")) {
                        Unit m = GameController.getCivilization()
                            .getMasterBuilderUnit();
                        if (m.isAffordable()) {
                            m.applyInitialCosts();
                            Media casReg = new Media(getClass()
                                .getResource("chaching.mp3").toString());
                            playMedia(casReg);
                            GameController.getLastClicked().getTile()
                                .setOccupant(m);
                            rec = true;
                            GameController.updateResourcesBar();
                            GameController.getLastClicked().updateTileView();
                        }
                    }
                    if (!rec) {
                        Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                        newAlert.setHeaderText("Unable to recruit. :(");
                        newAlert.setTitle("Oops!");
                        newAlert.showAndWait();
                        GameController.updateResourcesBar();
                    }
                } catch (Exception e) {
                    System.out.print("");
                }
            }
        });
        GameController.updateResourcesBar();
    }
    private void playMedia(Media m) {
        if (m != null) {
            MediaPlayer mp = new MediaPlayer(m);
            mp.play();
        }
    }
}