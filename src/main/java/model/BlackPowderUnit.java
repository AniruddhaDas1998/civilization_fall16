package model;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Represents a Black Powder unit.
 *
 * @author Jim Harris
 * @version 1.0
 */
class BlackPowderUnit extends SiegeUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        Media casReg = new Media(getClass()
                        .getResource("Melee.mp3").toString());
        playMedia(casReg);
    }

    @Override
    public char symbol() {
        return 'B';
    }


    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/"
                + "black_powder_unit_icon.PNG");
    }
    private void playMedia(Media m) {
        if (m != null) {
            MediaPlayer mp = new MediaPlayer(m);
            mp.play();
        }
    }
}
