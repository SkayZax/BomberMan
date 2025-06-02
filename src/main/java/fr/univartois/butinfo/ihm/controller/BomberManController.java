package fr.univartois.butinfo.ihm.controller;

import fr.univartois.butinfo.ihm.model.*;
import fr.univartois.butinfo.ihm.view.GameMapFactory;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.net.URL;


import fr.univartois.butinfo.ihm.view.UpdateView;

/**
 * La classe HelloController illustre le fonctionnement du contrôleur associé à une vue.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class BomberManController implements UpdateView {
    private static final int TAILLE_PERSO = 64;
    /**
     * Le label de l'application, où l'on va pouvoir afficher des messages.
     * Cet attribut sera initialisé automatiquement par JavaFX grâce à l'annotation {@link FXML}.
     */
    @FXML
    private GridPane grid;
    public Tile tile ;


    public UpdateView  updateView;

    // Taille de chaque case en pixels
    private static final int TAILLE = 64;
    private static final int ROWS = 13;
    private static final int COLS = 15;
    GameMap map = GameMapFactory.createMapWithRegularIntermediateWall(ROWS,COLS);
    private facade facade;
    public Scene scene;
    @FXML
    public void initialize() {
        // Créez d'abord la carte
        map = GameMapFactory.createMapWithRandomBrickWalls(ROWS,COLS,75);
        // Initialisez la facade avec la carte
        facade = new facade(map);

        updateView();
        facade.placeCharacter(facade.getPlayer());
        facade.initializeGame();
        liaisonEnemis();
        liaisonPlayer(facade.getPlayer());
    }



    private Image loadImage(String imageName) {
        try {
            URL url = getClass().getResource("/images/"+ imageName);
            if (url == null) {
                throw new IllegalArgumentException("Image non trouvée : " + imageName);
            }
            return new Image(url.toExternalForm(), TAILLE, TAILLE, true, true);
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image " + imageName + ": " + e.getMessage());
            return null;
        }
    }

    public void updateView() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                // Création d'un nouvel ImageView
                ImageView imageView = new ImageView();
                imageView.setFitHeight(TAILLE);
                imageView.setFitWidth(TAILLE);

                // Récupération de la tuile correspondante
                Tile currentTile = map.get(i, j);

                // Création du binding pour l'image
                imageView.imageProperty().bind(
                        Bindings.createObjectBinding(
                                () -> loadImage(currentTile.getContent().getName() + ".png"),
                                currentTile.contentProperty()
                        )
                );

                // Ajout de l'ImageView à la grille
                grid.add(imageView, j, i);
            }
        }
    }
    public void liaisonPlayer(AbstractCharacter character) {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(TAILLE_PERSO);
        imageView.setFitWidth(TAILLE_PERSO);


        Image image = loadImage(character.getName() + ".png");
        imageView.setImage(image);
        imageView.setStyle("-fx-alignment: center; -fx-content-display: center;");

        GridPane.setConstraints(imageView, character.getColumn(), character.getRow());
        grid.getChildren().add(imageView);

        // Utilisation des propriétés pour les listeners
        character.rowProperty().addListener((obs, oldVal, newVal) ->
                GridPane.setRowIndex(imageView, newVal.intValue()));

        character.columnProperty().addListener((obs, oldVal, newVal) ->
                GridPane.setColumnIndex(imageView, newVal.intValue()));
    }
    public void liaisonEnemis() {
        for (Enemy enemy : facade.enemies) {
            liaisonPlayer(enemy);
        }
    }
    public UpdateView setUpdateView(UpdateView updateView){
        return this.updateView = updateView;
    }

    @Override
    public void Personnage(AbstractCharacter character) {

    }
    public void setScene(Scene scene){
        this.scene = scene;
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    facade.MouvementHAUT();
                    break;
                case DOWN:
                    facade.MouvementBAS();
                    break;
                case LEFT:
                    facade.MouvementGAUCHE();
                    break;
                case RIGHT:
                    facade.MouvementDROITE();
            }
        });

    }
// Exemple : 12 lignes, 18 colonnes
}