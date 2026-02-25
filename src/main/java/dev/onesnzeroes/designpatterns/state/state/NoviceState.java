package dev.onesnzeroes.designpatterns.state.state;

import dev.onesnzeroes.designpatterns.state.entity.Player;

public class NoviceState extends State{

    public NoviceState(Player player){
        super(player);
    }

    @Override
    public String getStateName() {
        return "novice";
    }

    @Override
    public void action(){
        System.out.println("1. Train");
        int action = this.readAction();
        System.out.println(action);
        if (action == 1) {
            this.getPlayer().setXp(this.getPlayer().getXp() + 10);
        }
        System.out.println(this.getPlayer());
        if(this.getPlayer().getXp() >= 10){
            this.getPlayer().setState(new IntermediateState(this.getPlayer()));
            System.out.println("you have leveled up to intermediate");
        }
    }
}
