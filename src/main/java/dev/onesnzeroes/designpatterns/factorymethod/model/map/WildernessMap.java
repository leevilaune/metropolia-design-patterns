package dev.onesnzeroes.designpatterns.factorymethod.model.map;

import dev.onesnzeroes.designpatterns.factorymethod.model.tile.*;

import java.util.Random;

public class WildernessMap extends Map{

    public WildernessMap(int size) {
        super(size);
    }

    @Override
    public Tile createTile() {
        Random random = new Random();
        int r = random.nextInt(0,100);
        Tile t;
        if(r<33){
            t = new SwampTile();
        }else if(r<66){
            t = new ForestTile();
        }else{
            t =  new WaterTile();
        }
        return t;
    }
}
