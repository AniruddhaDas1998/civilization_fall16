package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ResourcesMenu {
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    private static HBox resources = new HBox(10);
    public ResourcesMenu() {
        resources.setStyle("-fx-background-color: #ffd700;");
        Label strat = new Label("Strat Level: "
            + GameController.getCivilization()
            .getStrategy().getStrategyLevel());
        strat.setTextFill(Color.PURPLE);
        Label res = new Label("Resources : "
            + GameController.getCivilization().getResources());
        res.setTextFill(Color.PURPLE);
        Label sets = new Label("Settlements : "
            + GameController.getCivilization().getNumSettlements());
        sets.setTextFill(Color.PURPLE);
        Label money = new Label("Money : "
            + GameController.getCivilization().getTreasury().getCoins());
        money.setTextFill(Color.PURPLE);
        Label food = new Label("Food : "
            + GameController.getCivilization().getFood());
        food.setTextFill(Color.PURPLE);
        Label happy = new Label("Happiness : "
            + GameController.getCivilization().getHappiness());
        happy.setTextFill(Color.PURPLE);
        resources.getChildren().addAll(strat, res, sets, money,
            food, happy);
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public static void update() {
        //resources.getChildren().clear();
        Label strat = new Label("Strat Level: "
            + GameController.getCivilization()
            .getStrategy().getStrategyLevel());
        strat.setTextFill(Color.PURPLE);
        Label res = new Label("Resources : "
            + GameController.getCivilization().getResources());
        res.setTextFill(Color.PURPLE);
        Label sets = new Label("Settlements : "
            + GameController.getCivilization().getNumSettlements());
        sets.setTextFill(Color.PURPLE);
        Label money = new Label("Money : "
            + GameController.getCivilization().getTreasury().getCoins());
        money.setTextFill(Color.PURPLE);
        Label food = new Label("Food : "
            + GameController.getCivilization().getFood());
        food.setTextFill(Color.PURPLE);
        Label happy = new Label("Happiness : "
            + GameController.getCivilization().getHappiness());
        happy.setTextFill(Color.PURPLE);
        resources.getChildren().setAll(strat, res, sets, money,
            food, happy);
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public static HBox getRootNode() {
        //TODO
        update();
        return resources;
    }
}
