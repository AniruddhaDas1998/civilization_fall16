package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import view.GridFX;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    private StartScreen ss;
    private GameScreen gs;
    public void start(Stage primaryStage) {
        //sc = new StartScreen(stage);
        //Scene rand = this.startGame(stage);
        ss = new StartScreen();
        Scene scene = new Scene(ss);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Civilization Fall 16");
        primaryStage.show();
        ss.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.setScene(startGame());
                    primaryStage.show();
                } catch (Exception e) {
                    System.out.print("");
                }
            }
        });
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() throws Exception {
        TextInputDialog dialog = new TextInputDialog("Town Name");
        dialog.setTitle("A New Settlement");
        dialog.setHeaderText("You Have Built a Settlement");
        dialog.setContentText("Enter the Name of Your First Town: ");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if (ss.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.ANCIENT_EGYPT) {
                GameController.setCivilization(new Egypt());
                GridFX.getInstance().getMap().putSettlement(result.get(),
                    GameController.getCivilization(), 5, 5);
            } else if (ss.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.QIN_DYNASTY) {
                GameController.setCivilization(new QinDynasty());
                GridFX.getInstance().getMap().putSettlement(result.get(),
                    GameController.getCivilization(), 5, 5);
            } else if (ss.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.ROMAN_EMPIRE) {
                GameController.setCivilization(new RomanEmpire());
                GridFX.getInstance().getMap().putSettlement(result.get(),
                    GameController.getCivilization(), 5, 5);
            }
        }
        Scene s;
        GridFX.getInstance().getMap().addEnemies(new Bandit(), 1);
        gs = new GameScreen();
        s = new Scene(gs);
        return s;
    }
}
