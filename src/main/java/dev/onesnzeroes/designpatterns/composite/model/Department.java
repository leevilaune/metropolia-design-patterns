package dev.onesnzeroes.designpatterns.composite.model;

import java.util.ArrayList;
import java.util.List;

public class Department extends Node{

    private List<Node> nodes;

    public Department(String name) {
        super(name);
        this.nodes = new ArrayList<>();
    }

    @Override
    public void add(Node n) {
        this.nodes.add(n);
    }

    @Override
    public void remove(Node n) {
        this.nodes.remove(n);
    }
    @Override
    public double getSalary(){
        double totalSalary = 0;
        for(Node n : this.nodes){
            totalSalary += n.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void print(int indents) {
        System.out.print(" ".repeat(indents));

        System.out.println("<department name=\"" +super.getName()+"\">");
        for (Node n : this.nodes){
            n.print(indents+Node.INDENTS);
        }
        System.out.print(" ".repeat(indents));
        System.out.println("</department>");
    }
}
