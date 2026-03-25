package dev.onesnzeroes.designpatterns.proxy.model;

import dev.onesnzeroes.designpatterns.proxy.model.document.Document;
import dev.onesnzeroes.designpatterns.proxy.model.document.DocumentProxy;
import dev.onesnzeroes.designpatterns.proxy.model.document.IDocument;
import dev.onesnzeroes.designpatterns.proxy.model.exception.AccessDeniedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private AccessControlService accessControl;
    private Map<Integer,IDocument> documents;

    public Library(){
        this.accessControl = AccessControlService.getInstance();
        this.documents = new HashMap<>();
    }

    public int addProtectedDocument(String content, User user){
        IDocument document = new Document(content);
        document = new DocumentProxy(document);
        this.documents.putIfAbsent(document.getId(),document);
        this.accessControl.setAccessForUser(document.getId(), user.getUsername());
        return document.getId();
    }

    public int addUnprotectedDocument(String content){
        IDocument document = new Document(content);
        this.documents.putIfAbsent(document.getId(),document);
        return document.getId();
    }

    public IDocument getDocument(int documentId){
        return this.documents.get(documentId);
    }
}
