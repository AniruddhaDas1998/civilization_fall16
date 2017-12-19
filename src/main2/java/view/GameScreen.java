package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    private static VBox mens = new VBox(10);
    private static AbstractMenu men;
    public GameScreen() {
        men = new StatusMenu();
        this.setCenter(GridFX.getInstance());
        this.setTop(getResources().getRootNode());
        mens.getChildren().setAll(men.getRootNode().getChildren());
        mens.setStyle("-fx-background-color: #9400D3;");
        this.setLeft(mens);
        this.update();
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        this.setTop(this.getResources().getRootNode());
        this.setLeft(mens);
    }

    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
        ResourcesMenu res = new ResourcesMenu();
        return res;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        if (state == GameController.GameState.MILITARY) {
            MilitaryMenu mm = new MilitaryMenu();
            //mens.getChildren().clear();
            mens.getChildren().setAll(mm.getRootNode().getChildren());
        } else if (state == GameController.GameState.WORKER) {
            WorkerMenu wm = new WorkerMenu();
            //mens.getChildren().clear();
            mens.getChildren().setAll(wm.getRootNode());
        } else if (state == GameController.GameState.RECRUITING) {
            RecruitMenu rm = new RecruitMenu();
            //mens.getChildren().clear();
            mens.getChildren().setAll(rm.getRootNode().getChildren());
        } else if (state == GameController.GameState.BUILDING) {
            BuildingMenu bm = new BuildingMenu();
            //mens.getChildren().clear();
            mens.getChildren().setAll(bm.getRootNode().getChildren());
        } else if (state == GameController.GameState.NEUTRAL) {
            StatusMenu sm = new StatusMenu();
            //mens.getChildren().clear();
            mens.getChildren().setAll(sm.getRootNode().getChildren());
        }
    }
}
