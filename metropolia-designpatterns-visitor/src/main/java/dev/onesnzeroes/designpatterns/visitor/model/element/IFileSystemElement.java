package dev.onesnzeroes.designpatterns.visitor.model.element;

import dev.onesnzeroes.designpatterns.visitor.model.visitor.SearchVisitor;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SizeCalculatorVisitor;

public interface IFileSystemElement {

    void accept(SearchVisitor visitor);
    void accept(SizeCalculatorVisitor visitor);
}
