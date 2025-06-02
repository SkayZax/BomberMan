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

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


import java.util.Random;

/**
 * La classe Enemy représente un adversaire du joueur dans le jeu du Bomberman.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class Enemy extends AbstractCharacter {
    private facade gameFacade;

    /**
     * Le nom de ce personnage.
     */
    private final String name;
    private Timeline timeline;

    /**
     * Construit un nouvel Enemy.
     *
     * @param name Le nom du personnage.
     */
    public Enemy(String name,facade gameFacade) {
        super(1);
        this.name = name;
        this.gameFacade = gameFacade;
    }
    public void moveRandomly(){
        Random random = new Random();
        random.nextInt(4);
        switch (random.nextInt(4)) {
            case 0:
                gameFacade.HAUT(this);
                break;
            case 1:
                gameFacade.BAS(this);
                break;
            case 2:
                gameFacade.GAUCHE(this);
                break;
            case 3:
                gameFacade.DROITE(this);
        }
    }
    public void animate() {
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> moveRandomly()));
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.ihm.bomberman.model.AbstractCharacter#getName()
     */
    @Override
    public String getName() {
        return name;
    }

}
