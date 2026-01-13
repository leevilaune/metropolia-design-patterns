package dev.onesnzeroes.designpatterns.factorymethod.model.tile;

public abstract class Tile {

    private String type;
    private String description;

    public Tile(String type, String description){
        this.type = type;
        this.description = description;
    }

    public char getCharacter(){
        return this.type.toUpperCase().charAt(0);
    }

    public String getType(){
        return this.type;
    }

    public abstract void action();
}
