/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d'aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d'adéquation
 * à un usage particulier et d'absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d'auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d'un contrat, d'un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d'autres éléments du logiciel.
 *
 * (c) 2022-2025 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */
package fr.univartois.butinfo.ihm.model;
/**
 * La classe Bomb représente une bombe qui peut être déposée sur une tuile de la map afin
 * de faire exploser le contenu des tuiles environnantes.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class Bomb {

    /**
     * La carte du jeu où cette bombe a été déposée.
     */
    protected GameMap gameMap;

    /**
     * La ligne de la carte où cette bombe a été déposée.
     */
    protected int row;

    /**
     * La colonne de la carte où cette bombe a été déposée.
     */
    protected int column;

    /**
     * Modifie la carte du jeu où cette bombe a été déposée.
     *
     * @param gameMap La carte du jeu où cette bombe a été déposée.
     */
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    /**
     * Modifie la position où cette bombe a été déposée.
     *
     * @param row La ligne de la carte où cette bombe a été déposée.
     * @param column La colonne de la carte où cette bombe a été déposée.
     */
    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Donne le nom de cette bombe.
     *
     * @return Le nom de cette bombe.
     */
    public String getName() {
        return "bomb";
    }

    /**
     * Donne le délai entre le moment où cette bombe est posée et le moment où elle
     * explose (en secondes).
     *
     * @return Le délai avant l'explosion de cette bombe.
     */
    public int getDelay() {
        return 3;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getName();
    }

}
