package dev.onesnzeroes.designpatterns.factorymethod.model.map;

import dev.onesnzeroes.designpatterns.factorymethod.model.tile.Tile;

public abstract class Map {

    private int size;
    private Tile[][] tileGrid;

    public Map(int size){
        this.size = size;
        this.tileGrid = new Tile[size][size];
    }

    public abstract Tile createTile();

    public void display(){
        for(int i = 0; i < this.size;i++){
            for (int j = 0; j < this.size;j++){
                System.out.print(this.tileGrid[i][j].getCharacter()+" ");
            }
            System.out.println();
        }
    }

    public Tile[][] getTileGrid() {
        return tileGrid;
    }

    public void addToTileGrid(Tile t){
        for(int i = 0; i < this.size;i++){
            for (int j = 0; j < this.size;j++){
                if(this.tileGrid[i][j] == null){
                    this.tileGrid[i][j] = t;
                    return;
                }
            }
        }
    }
}
