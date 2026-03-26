package dev.onesnzeroes.designpatterns.visitor.model.visitor;

import dev.onesnzeroes.designpatterns.visitor.model.element.Directory;
import dev.onesnzeroes.designpatterns.visitor.model.element.File;

public class SizeCalculatorVisitor implements IFileSystemVisitor {

    private int totalSize;

    public SizeCalculatorVisitor() {
        this.totalSize = 0;
    }

    public int getTotalSize(){
        return this.totalSize;
    }

    @Override
    public void visit(File file) {
        this.totalSize += file.getSizeMb();
    }

    @Override
    public void visit(Directory dir) {

    }
}
