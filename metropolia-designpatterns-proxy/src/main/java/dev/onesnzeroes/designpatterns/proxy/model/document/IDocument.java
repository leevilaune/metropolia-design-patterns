package dev.onesnzeroes.designpatterns.proxy.model.document;

import dev.onesnzeroes.designpatterns.proxy.model.User;
import dev.onesnzeroes.designpatterns.proxy.model.exception.AccessDeniedException;

import java.time.Instant;

public interface IDocument {

    int getId();
    boolean isProtected();
    String getContent(User user);
    void setContent(String content);
    Instant getCreationDate();
    void setCreationDate(Instant creationDate);
}
