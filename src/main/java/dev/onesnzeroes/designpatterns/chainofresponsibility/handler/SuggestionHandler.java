package dev.onesnzeroes.designpatterns.chainofresponsibility.handler;

import dev.onesnzeroes.designpatterns.chainofresponsibility.Feedback;
import dev.onesnzeroes.designpatterns.chainofresponsibility.FeedbackType;

public class SuggestionHandler extends Handler {

    @Override
    public void process(Feedback feedback) {
        if(feedback.getType() == FeedbackType.GENERAL_FEEDBACK){
            System.out.println("Logged and prioritized with " + ((int)(Math.random()*3)+1));
        }
        super.process(feedback);
    }
}
