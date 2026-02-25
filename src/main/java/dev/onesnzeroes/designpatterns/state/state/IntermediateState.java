package dev.onesnzeroes.designpatterns.state.state;

import dev.onesnzeroes.designpatterns.state.entity.Player;

public class IntermediateState extends State{

    public IntermediateState(Player player) {
        super(player);
    }

    @Override
    public String getStateName() {
        return "intermediate";
    }

    @Override
    public void action() {
        System.out.println("1. Train");
        System.out.println("2. Mediate");
        int action = this.readAction();
        System.out.println(action);
        if (action == 1) {
            this.getPlayer().setXp(this.getPlayer().getXp() + 10);
        } else if (action == 2) {
            this.getPlayer().setHp(this.getPlayer().getHp() + 10);
        }
        System.out.println(this.getPlayer());
        if(this.getPlayer().getXp() >= 50){
            this.getPlayer().setState(new ExpertState(this.getPlayer()));
            System.out.println("you have leveled up to expert");
        }
    }
}
