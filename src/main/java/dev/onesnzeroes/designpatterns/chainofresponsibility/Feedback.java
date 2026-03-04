package dev.onesnzeroes.designpatterns.chainofresponsibility;

public class Feedback {

    private FeedbackType type;
    private String content;
    private String senderEmail;

    public Feedback(FeedbackType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public FeedbackType getType() {
        return type;
    }

    public void setType(FeedbackType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                '}';
    }
}
