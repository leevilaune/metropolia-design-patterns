package dev.onesnzeroes.designpatterns.state.state;

import dev.onesnzeroes.designpatterns.state.entity.Player;

public class MasterState extends State{
    public MasterState(Player player) {
        super(player);
    }

    @Override
    public String getStateName() {
        return "master";
    }

    @Override
    public void action() {
        System.out.println("You won!");
        System.out.println(this.getPlayer());
        System.exit(0);
    }
}
