package fr.univartois.butinfo.ihm.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * La classe AbstractCharacter est la classe parente des différents personnages pouvant se
 * déplacer dans le jeu du Bomberman.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public abstract class AbstractCharacter {

    /**
     * La ligne où se trouve ce personnage (propriété JavaFX).
     */
    private final IntegerProperty row = new SimpleIntegerProperty();

    /**
     * La colonne où se trouve ce personnage (propriété JavaFX).
     */
    private final IntegerProperty column = new SimpleIntegerProperty();

    /**
     * Les points de vie restants pour ce personnage.
     */
    private int health;

    /**
     * La façade du jeu, permettant d’interagir avec les règles du jeu.
     */

    /**
     * Crée une nouvelle instance de AbstractCharacter.
     *
     * @param initialHealth Les points de vie initiaux du personnage.
     */
    protected AbstractCharacter(int initialHealth) {
        this.health = initialHealth;

    }

    public abstract String getName();

    public int getRow() {
        return row.get();
    }

    public void setRow(int row) {
        this.row.set(row);
    }

    public IntegerProperty rowProperty() {
        return row;
    }

    public int getColumn() {
        return column.get();
    }

    public void setColumn(int column) {
        this.column.set(column);
    }

    public IntegerProperty columnProperty() {
        return column;
    }

    public void setPosition(int row, int column) {
        setRow(row);
        setColumn(column);
    }

    public int getHealth() {
        return health;
    }

    public void incHealth() {
        health++;
    }

    public void decHealth() {
        health--;
    }
}
