package dev.onesnzeroes.designpatterns.visitor.model.element;

import dev.onesnzeroes.designpatterns.visitor.model.visitor.SearchVisitor;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SizeCalculatorVisitor;

public class File implements IFileSystemElement {
    private String fileName;
    private int sizeMb;

    public File(String fileName, int sizeMb) {
        this.fileName = fileName;
        this.sizeMb = sizeMb;
    }

    public int getSizeMb() {
        return sizeMb;
    }

    public void setSizeMb(int sizeMb) {
        this.sizeMb = sizeMb;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void accept(SearchVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(SizeCalculatorVisitor visitor) {
        visitor.visit(this);
    }
}
