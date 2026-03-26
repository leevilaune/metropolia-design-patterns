package dev.onesnzeroes.designpatterns.visitor.model.visitor;

import dev.onesnzeroes.designpatterns.visitor.model.element.Directory;
import dev.onesnzeroes.designpatterns.visitor.model.element.File;

public interface IFileSystemVisitor {

    void visit(File file);
    void visit(Directory dir);
}
