package dev.onesnzeroes.designpatterns.chainofresponsibility;

import dev.onesnzeroes.designpatterns.chainofresponsibility.handler.*;

public class Main {

    public static void main(String[] args) {

        Handler compensationHandler = new CompensationHandler();
        Handler contactHandler = new ContactHandler();
        Handler developmentHandler = new SuggestionHandler();
        Handler generalHandler = new FeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        Feedback m1 = new Feedback(
                FeedbackType.COMPENSATION_CLAIM,
                "My package arrived broken.",
                "alice@email.com"
        );

        Feedback m2 = new Feedback(
                FeedbackType.CONTACT_REQUEST,
                "Please call me about enterprise pricing.",
                "bob@email.com"
        );

        Feedback m3 = new Feedback(
                FeedbackType.DEVELOPMENT_SUGGESTION,
                "Add dark mode to the application.",
                "carol@email.com"
        );

        Feedback m4 = new Feedback(
                FeedbackType.GENERAL_FEEDBACK,
                "Great service, keep it up!",
                "dave@email.com"
        );

        compensationHandler.process(m1);
        compensationHandler.process(m2);
        compensationHandler.process(m3);
        compensationHandler.process(m4);
    }
}