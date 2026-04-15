package dev.onesnzeroes.designpatterns.prototype.model;

public class Book implements Cloneable{

    private String title;
    private String author;

    public Book(){

    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        book.author = this.author;
        book.title = this.title;

        return book;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
