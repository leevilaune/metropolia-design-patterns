package dev.onesnzeroes.designpatterns.visitor;

import dev.onesnzeroes.designpatterns.visitor.model.element.*;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SearchVisitor;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SizeCalculatorVisitor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file1 = new File("notes.txt", 10);
        File file2 = new File("image.jpg", 20);
        File file3 = new File("report.txt", 30);
        File file4 = new File("music.mp3", 40);

        Directory docs = new Directory("docs", List.of(file1, file3));
        Directory media = new Directory("media", List.of(file2, file4));

        Directory root = new Directory("root", List.of(docs, media));

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("\nSearch results (.txt files):");

        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getFileName() + " (" + file.getSizeMb() + " MB)");
        }
    }
}