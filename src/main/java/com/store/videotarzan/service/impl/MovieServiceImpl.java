package com.store.videotarzan.service.impl;

import com.store.videotarzan.dao.MovieDao;
import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.model.Movie;
import com.store.videotarzan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> getMovieList() {
        return movieDao.getMovieList();
    }

    public Movie getMovieById(Long movieId) {
        return movieDao.getMovieById(movieId);
    }

    public void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    public void editMovie(Movie movie) {
        movieDao.editMovie(movie);
    }

    public void deleteMovie(Movie movie) {
        movieDao.deleteMovie(movie);
    }

    public void updateUnitsInStock(List<CartItem> cartItems) {
        movieDao.updateUnitsInStock(cartItems);
    }
}
