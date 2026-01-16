package dev.onesnzeroes.designpatterns.composite.model;

public class Employee extends Node{

    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(Node n) {
        throw new UnsupportedOperationException("Unable to add to leaf node");
    }

    @Override
    public void remove(Node n) {
        throw new UnsupportedOperationException("Unable to remove from leaf node");

    }

    @Override
    public void print(int indents) {
        System.out.print(" ".repeat(indents));
        System.out.println("<employee>");
        System.out.print(" ".repeat(indents+Node.INDENTS));
        System.out.println("<name>"+super.getName()+"</name>");
        System.out.print(" ".repeat(indents+Node.INDENTS));
        System.out.println("<salary>"+this.salary+"</salary>");
        System.out.print(" ".repeat(indents));
        System.out.println("</employee>");


    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
