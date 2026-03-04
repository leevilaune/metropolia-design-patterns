package dev.onesnzeroes.designpatterns.chainofresponsibility.handler;

import dev.onesnzeroes.designpatterns.chainofresponsibility.Feedback;
import dev.onesnzeroes.designpatterns.chainofresponsibility.FeedbackType;

public class FeedbackHandler extends Handler {

    @Override
    public void process(Feedback feedback) {
        if(feedback.getType() == FeedbackType.GENERAL_FEEDBACK){
            System.out.println("Analyzed and responded");
        }
        super.process(feedback);
    }
}
