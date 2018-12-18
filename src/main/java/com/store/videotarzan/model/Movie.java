package com.store.videotarzan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 4557413805517780550L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @NotBlank(message = "The movie name must not be null.")
    private String movieTitle;
    @NotBlank(message = "The movie description must not be null.")
    private String movieDescription;
    @NotBlank(message = "The movie director must not be null.")
    private String movieDirector;
    @Min(value = 0, message = "The movie price must not be less than zero.")
    private double moviePrice;
    @Min(value = 0, message = "The movie unit must not be less than zero.")
    private int unitInStock;
    @NotEmpty(message = "The cast must contain at least one actor.")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "MOVIE_ACTOR",
            joinColumns = { @JoinColumn(name = "MOVIE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ACTOR_ID") })
    private List<Actor> movieCast;

    @Transient
    private MultipartFile movieImage;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public List<Actor> getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(List<Actor> movieCast) {
        this.movieCast = movieCast;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(double moviePrice) {
        this.moviePrice = moviePrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public MultipartFile getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(MultipartFile movieImage) {
        this.movieImage = movieImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
