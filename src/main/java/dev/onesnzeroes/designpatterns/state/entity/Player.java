package dev.onesnzeroes.designpatterns.state.entity;

import dev.onesnzeroes.designpatterns.state.state.NoviceState;
import dev.onesnzeroes.designpatterns.state.state.State;

public class Player {

    private State state;
    private int xp;
    private int hp;
    private String name;
    public Player(){
        this.state = new NoviceState(this);
    }

    public void action(){
        while (true){
            this.state.action();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "state=" + state.getStateName() +
                ", xp=" + xp +
                ", hp=" + hp +
                ", name='" + name + '\'' +
                '}';
    }
}
