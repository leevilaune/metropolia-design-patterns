package dev.onesnzeroes.designpatterns.proxy.model.document;

import dev.onesnzeroes.designpatterns.proxy.model.AccessControlService;
import dev.onesnzeroes.designpatterns.proxy.model.User;
import dev.onesnzeroes.designpatterns.proxy.model.exception.AccessDeniedException;

import java.time.Instant;

public class DocumentProxy implements IDocument {

    private IDocument document;

    public DocumentProxy(IDocument document){
        this.document = document;
    }
    @Override
    public boolean isProtected(){
        return true;
    }

    @Override
    public int getId() {
        return this.document.getId();
    }

    @Override
    public String getContent(User user) {
        try{
            if(AccessControlService.getInstance().isAllowed(this.getId(), user.getUsername())){
                return this.document.getContent(user);
            }else{
                throw new AccessDeniedException(String.format("Document is protected and user %s has no access", user.getUsername()));
            }
        }catch (AccessDeniedException e) {
            return e.getMessage();
        }
    }

    @Override
    public void setContent(String content) {

    }

    @Override
    public Instant getCreationDate() {
        return this.document.getCreationDate();
    }

    @Override
    public void setCreationDate(Instant creationDate) {
        this.document.setCreationDate(creationDate);
    }
}
