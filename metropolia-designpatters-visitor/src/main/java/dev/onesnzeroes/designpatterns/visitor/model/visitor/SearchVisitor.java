package dev.onesnzeroes.designpatterns.visitor.model.visitor;

import dev.onesnzeroes.designpatterns.visitor.model.element.Directory;
import dev.onesnzeroes.designpatterns.visitor.model.element.File;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements IFileSystemVisitor{

    private List<File> files;
    private String condition;

    public SearchVisitor(String condition){
        this.files = new ArrayList<>();
        this.condition = condition;
    }

    public List<File> getFoundFiles() {
        return this.files;
    }

    @Override
    public void visit(File file) {
        if(file.getFileName().contains(this.condition)){
            this.files.add(file);
        }
    }

    @Override
    public void visit(Directory dir) {
    }
}
