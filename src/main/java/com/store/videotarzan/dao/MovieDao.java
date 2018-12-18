package com.store.videotarzan.dao;

import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> getMovieList();

    Movie getMovieById(Long movieId);

    void addMovie(Movie movie);

    void editMovie(Movie movie);

    void deleteMovie(Movie movie);

    void updateUnitsInStock(List<CartItem> cartItems);

}
