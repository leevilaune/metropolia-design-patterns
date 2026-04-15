package dev.onesnzeroes.designpatterns.prototype.model;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{

    private List<Book> recommendedBooks;
    private String targetAudience;

    public Recommendation(String targetAudience) {
        this.recommendedBooks = new ArrayList<>();
        this.targetAudience = targetAudience;
    }

    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    public void setRecommendedBooks(List<Book> recommendedBooks) {
        this.recommendedBooks = recommendedBooks;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        this.recommendedBooks.add(book);
    }

    public void removeBook(Book book) {
        this.recommendedBooks.remove(book);
    }

    @Override
    public Recommendation clone() throws CloneNotSupportedException{
        Recommendation recommendation = (Recommendation) super.clone();
        recommendation.recommendedBooks = new ArrayList<>();
        for(Book b : this.recommendedBooks){
            recommendation.getRecommendedBooks().add(b.clone());
        }
        return recommendation;
    }
}
