package dev.onesnzeroes.designpatterns.factorymethod;

import dev.onesnzeroes.designpatterns.factorymethod.model.map.CityMap;
import dev.onesnzeroes.designpatterns.factorymethod.model.map.Map;
import dev.onesnzeroes.designpatterns.factorymethod.model.map.WildernessMap;
import dev.onesnzeroes.designpatterns.factorymethod.model.tile.Tile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        System.out.println("Give q as type to quit");
        while(true){
            System.out.print("Map type (city or wilderness):\n> ");
            String type = r.nextLine().toLowerCase();
            if(type.equals("q")){
                return;
            }
            System.out.print("Map size:\n> ");
            int size = Integer.parseInt(r.nextLine());

            Map map = createMap(size, type);
            if(map == null){
                System.err.println("Invalid map type");
                continue;
            }
            map.display();
        }
    }
    public static Map createMap(int size, String type){
        Map map;
        if (type.equals("city")) {
            map = new CityMap(size);
        }else if(type.equals("wilderness")){
            map = new WildernessMap(size);
        }else{
            return null;
        }
        for (int i = 0; i < (size * size); i++) {
            Tile t = map.createTile();
            map.addToTileGrid(t);
        }
        return map;
    }
}