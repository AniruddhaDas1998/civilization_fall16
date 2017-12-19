package view;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */

public class StartScreen extends StackPane {
    private ListView<CivEnum> list;
    private Button btn;
    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        ObservableList<CivEnum> items = FXCollections
            .observableArrayList(CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY,
            CivEnum.ROMAN_EMPIRE);
        list = new ListView<>(items);
        list.setMaxSize(200.0, 100.0);
        list.setLayoutX(70.0);
        list.setLayoutY(50.0);
        list.setTranslateX(0.0);
        list.setTranslateY(150.0);
        Label l = new Label("Select a Civilization");
        l.setTranslateX(0.0);
        l.setTranslateY(86.0);
        l.setTextFill(Color.RED);
        l.setFont(new Font(26.0));
        Image image = new Image("File:./src/main/java/view/civ_background.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        this.getChildren().addAll(iv);
        this.getChildren().addAll(list);
        this.getChildren().addAll(l);
        btn = new Button("START");
        btn.setTranslateY(230.0);
        this.getChildren().addAll(btn);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return btn;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return list;
    }
}