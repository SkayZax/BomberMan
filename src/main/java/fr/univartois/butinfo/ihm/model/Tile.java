package fr.univartois.butinfo.ihm.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Tile {

    private final int row;

    private final int column;

    private final ObjectProperty<TileContent> content = new SimpleObjectProperty<>();

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    // Propriété content au lieu d'un simple champ
    public TileContent getContent() {
        return content.get();
    }

    public void setContent(TileContent content) {
        this.content.set(content);
    }

    public ObjectProperty<TileContent> contentProperty() {
        return content;
    }

    public boolean isEmpty() {
        return getContent() != null && getContent().isEmpty();
    }
}