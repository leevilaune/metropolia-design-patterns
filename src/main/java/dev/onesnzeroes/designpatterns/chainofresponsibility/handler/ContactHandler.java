package dev.onesnzeroes.designpatterns.chainofresponsibility.handler;

import dev.onesnzeroes.designpatterns.chainofresponsibility.Feedback;
import dev.onesnzeroes.designpatterns.chainofresponsibility.FeedbackType;

public class ContactHandler extends Handler{

    @Override
    public void process(Feedback feedback) {
        if(feedback.getType() == FeedbackType.CONTACT_REQUEST){
            System.out.println("Forwarding");
        }
        super.process(feedback);
    }
}
