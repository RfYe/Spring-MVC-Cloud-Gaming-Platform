package gamesRenting.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    public String title;
    public String publisher;
    public String publishDate;
    public String description;
    public String trailerUrl;
    public int rating;
    public Game(){
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTrailerUrl(String trailerUrl){this.trailerUrl=trailerUrl;}
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public String getDescription() {
        return description;
    }
    public String getTrailerUrl(){return trailerUrl;}
    public int getRating() {
        return rating;
    }
}
