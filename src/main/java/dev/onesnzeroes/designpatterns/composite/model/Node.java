package dev.onesnzeroes.designpatterns.composite.model;

public abstract class Node {

    private String name;
    public static final int INDENTS = 4;

    public Node(String name){
        this.name = name;
    }

    public abstract void add(Node n);
    public abstract void remove(Node n);
    public abstract void print(int indents);
    public abstract double getSalary();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
