package dev.onesnzeroes.designpatterns.factorymethod.model.map;

import dev.onesnzeroes.designpatterns.factorymethod.model.tile.BuildingTile;
import dev.onesnzeroes.designpatterns.factorymethod.model.tile.ForestTile;
import dev.onesnzeroes.designpatterns.factorymethod.model.tile.RoadTile;
import dev.onesnzeroes.designpatterns.factorymethod.model.tile.Tile;

import java.util.Arrays;
import java.util.Random;

public class CityMap extends Map{
    
    public CityMap(int size) {
        super(size);
    }

    @Override
    public Tile createTile() {
        String[] tiles = {"road","forest","building"};
        Random random = new Random();
        int r = random.nextInt(0,100);
        Tile t;
        if(r<33){
            t = new RoadTile();
        }else if(r<66){
            t = new ForestTile();
        }else{
            t =  new BuildingTile();
        }
        return t;
    }
}
