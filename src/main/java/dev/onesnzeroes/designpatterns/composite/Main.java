package dev.onesnzeroes.designpatterns.composite;

import dev.onesnzeroes.designpatterns.composite.model.Department;
import dev.onesnzeroes.designpatterns.composite.model.Employee;
import dev.onesnzeroes.designpatterns.composite.model.Node;

import java.beans.XMLEncoder;
public class Main {

    public static void main(String[] args) {
        Node organization = new Department("Organization");

        Node it = new Department("IT");
        Node hr = new Department("HR");
        Node dev = new Department("Development");

        Node alice = new Employee("Alice", 4000);
        Node bob = new Employee("Bob", 3500);
        Node charlie = new Employee("Charlie", 5000);
        Node diana = new Employee("Diana", 4500);

        organization.add(it);
        organization.add(hr);

        it.add(dev);
        it.add(alice);
        it.add(bob);

        dev.add(charlie);

        hr.add(diana);

        System.out.println("Total salary: " + organization.getSalary());

        System.out.println("\nOrganization structure (XML):");
        organization.print(0);

        it.remove(bob);

        System.out.println("\nAfter removing Bob:");
        System.out.println("Total salary: " + organization.getSalary());
        organization.print(0);
    }

}