package model;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Represents a Legion unit.
 *
 * @author Jim Harris
 * @version 1.0
 */
class LegionUnit extends MeleeUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public LegionUnit(Civilization owner) {
        super(owner);
        this.setDamage((int) (this.getDamage() * 1.5));
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit) {
            damage(((MilitaryUnit) o).getDamage());
            Media casReg = new Media(getClass()
                            .getResource("Melee.mp3").toString());
            playMedia(casReg);
        }
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/legion_icon.PNG");
    }
    private void playMedia(Media m) {
        if (m != null) {
            MediaPlayer mp = new MediaPlayer(m);
            mp.play();
        }
    }
}
