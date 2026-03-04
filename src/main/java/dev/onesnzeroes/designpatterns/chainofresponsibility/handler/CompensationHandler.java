package dev.onesnzeroes.designpatterns.chainofresponsibility.handler;

import dev.onesnzeroes.designpatterns.chainofresponsibility.Feedback;
import dev.onesnzeroes.designpatterns.chainofresponsibility.FeedbackType;

public class CompensationHandler extends Handler{

    @Override
    public void process(Feedback feedback) {
        if(feedback.getType() == FeedbackType.COMPENSATION_CLAIM){
            if((int) (Math.random() * 2) == 1) System.out.println("Rejected");
            else System.out.println("Approved");
            return;
        }
        super.process(feedback);
    }
}
