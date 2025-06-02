
package fr.univartois.butinfo.ihm.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class facade {
    private static final int NOMBRE_ENNEMIS = 3;
    private GameMap gameMap;
    public ArrayList<Enemy> enemies = new ArrayList<>();
    private Player player = new Player();


    public facade(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void initializeGame() {
        // Vider la liste d'ennemis existante
        enemies.clear();

        // Ajouter de nouveaux ennemis
        for (int i = 0; i < NOMBRE_ENNEMIS; i++) {
            // Création d'un ennemi avec le nom correspondant à l'image
            Enemy enemy = new Enemy("agent",this);
            // Placement de l'ennemi sur la carte
            placeCharacter(enemy);
            // Ajout de l'ennemi à la liste

            enemies.add(enemy);
            enemy.animate();
        }
    }

    public void placeCharacter(AbstractCharacter character) {
        List<Tile> emptyTiles = gameMap.getEmptyTiles();

        if (emptyTiles.isEmpty()) {
            throw new IllegalStateException("Aucune tuile vide disponible.");
        }

        Random random = new Random();
        Tile ApparitionPerso = emptyTiles.get(random.nextInt(emptyTiles.size()));

        int row = ApparitionPerso.getRow();
        int column = ApparitionPerso.getColumn();
        character.setPosition(row, column);
    }
    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    public  void HAUT(AbstractCharacter character){
        int row = character.getRow()-1;
        int column = character.getColumn();
        if (gameMap.isOnMap(row, column)&& gameMap.get(row, column).getContent() ==TileContent.LAWN) {
            character.setPosition(row, column);

        }

    }
    public  void BAS(AbstractCharacter character){
        int row = character.getRow()+1;
        int column = character.getColumn();
        if (gameMap.isOnMap(row, column)&& gameMap.get(row, column).getContent() ==TileContent.LAWN) {
            character.setPosition(row, column);
        }
    }
    public  void GAUCHE(AbstractCharacter character){
        int row = character.getRow();
        int column = character.getColumn()-1;
        if (gameMap.isOnMap(row, column)&& gameMap.get(row, column).getContent() ==TileContent.LAWN) {
            character.setPosition(row, column);
        }
    }
    public void DROITE(AbstractCharacter character){
        int row = character.getRow();
        int column = character.getColumn()+1;
        if (gameMap.isOnMap(row, column)&& gameMap.get(row, column).getContent() ==TileContent.LAWN) {
            character.setPosition(row, column);
        }
    }
    public void MouvementHAUT(){
        HAUT(player);

    }
    public void MouvementBAS(){
        BAS(player);

    }
    public void MouvementGAUCHE(){
        GAUCHE(player);

    }
    public void MouvementDROITE(){
        DROITE(player);
    }
}