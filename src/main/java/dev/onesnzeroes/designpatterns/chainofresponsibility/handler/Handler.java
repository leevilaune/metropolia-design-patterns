package dev.onesnzeroes.designpatterns.chainofresponsibility.handler;

import dev.onesnzeroes.designpatterns.chainofresponsibility.Feedback;

public abstract class Handler {

    private Handler nextHandler;

    public void process(Feedback feedback) {
        if (nextHandler != null) {
            nextHandler.process(feedback);
        }
    }
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

}