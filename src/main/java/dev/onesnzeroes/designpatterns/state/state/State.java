package dev.onesnzeroes.designpatterns.state.state;

import dev.onesnzeroes.designpatterns.state.entity.Player;

import java.util.Scanner;

public abstract class State {

    private Player player;
    private Scanner scanner;

    public State(Player player){
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public Player getPlayer() {
        return player;
    }

    public int readAction(){
        System.out.print("> ");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public abstract String getStateName();

    public abstract void action();
}
