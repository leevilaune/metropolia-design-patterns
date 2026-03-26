package dev.onesnzeroes.designpatterns.visitor.model.element;

import dev.onesnzeroes.designpatterns.visitor.model.visitor.SearchVisitor;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SizeCalculatorVisitor;

import java.util.List;

public class Directory implements IFileSystemElement {

    private String name;
    private List<IFileSystemElement> elements;

    public Directory(String name, List<IFileSystemElement> elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IFileSystemElement> getElements() {
        return elements;
    }

    public void setElements(List<IFileSystemElement> elements) {
        this.elements = elements;
    }

    @Override
    public void accept(SearchVisitor visitor) {
        visitor.visit(this);
        for(IFileSystemElement element : this.getElements()){
            element.accept(visitor);
        }
    }

    @Override
    public void accept(SizeCalculatorVisitor visitor) {
        visitor.visit(this);
        for(IFileSystemElement element : this.getElements()){
            element.accept(visitor);
        }
    }
}
