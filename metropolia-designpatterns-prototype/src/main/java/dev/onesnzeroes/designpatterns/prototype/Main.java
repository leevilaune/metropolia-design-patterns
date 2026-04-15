package dev.onesnzeroes.designpatterns.prototype;

import dev.onesnzeroes.designpatterns.prototype.model.Book;
import dev.onesnzeroes.designpatterns.prototype.model.Recommendation;
import dev.onesnzeroes.designpatterns.prototype.model.RecommendationRegistry;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final RecommendationRegistry registry = new RecommendationRegistry();

    public static void main(String[] args) throws CloneNotSupportedException {

        seedData();

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View recommendation");
            System.out.println("2. Clone recommendation");
            System.out.println("3. Modify recommendation");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> viewRecommendation();
                case 2 -> cloneRecommendation();
                case 3 -> modifyRecommendation();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }

    private static void seedData() {
        Recommendation beginner = new Recommendation("beginner");
        beginner.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        beginner.addBook(new Book("Harry Potter", "J.K. Rowling"));

        registry.addEntry(beginner);
    }

    private static void viewRecommendation() {
        System.out.print("Enter audience: ");
        String key = scanner.nextLine();

        try {
            Recommendation rec = registry.getByTargetAudience(key);
            printRecommendation(rec);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cloneRecommendation() throws CloneNotSupportedException {
        System.out.print("Enter audience to clone: ");
        String key = scanner.nextLine();

        try {
            Recommendation clone = registry.getByTargetAudience(key);

            System.out.print("Enter new audience name: ");
            String newAudience = scanner.nextLine();

            clone.setTargetAudience(newAudience);
            registry.addEntry(clone);

            System.out.println("Cloned and saved.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyRecommendation() throws CloneNotSupportedException {
        System.out.print("Enter audience: ");
        String key = scanner.nextLine();

        try {
            Recommendation rec = registry.getByTargetAudience(key);

            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Change audience");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    rec.addBook(new Book(title, author));
                }
                case 2 -> {
                    printRecommendation(rec);

                    System.out.print("Title to remove: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    rec.removeBook(new Book(title, author));
                }
                case 3 -> {
                    System.out.print("New audience: ");
                    rec.setTargetAudience(scanner.nextLine());
                }
            }

            // Save modified version as new prototype
            registry.addEntry(rec);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printRecommendation(Recommendation rec) {
        System.out.println("Audience: " + rec.getTargetAudience());

        for (Book b : rec.getRecommendedBooks()) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }
    }
}