package com.store.videotarzan.dao.impl;

import com.store.videotarzan.dao.MovieDao;
import com.store.videotarzan.model.Actor;
import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.model.Movie;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Movie getMovieById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Movie movie = session.get(Movie.class, id);
        Hibernate.initialize(movie.getMovieCast());
        session.flush();
        return movie;
    }

    public List<Movie> getMovieList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Movie");
        List<Movie> movies = query.list();
        session.flush();
        return movies;
    }

    public void addMovie(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(movie);
        session.flush();
    }

    public void editMovie(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(movie);
        session.flush();
    }

    public void deleteMovie(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(movie);
        session.flush();
    }

    public void updateUnitsInStock(List<CartItem> cartItems) {
        Session session = sessionFactory.getCurrentSession();
        for (CartItem item: cartItems) {
            Movie movie = getMovieById(item.getMovie().getMovieId());
            movie.setUnitInStock(movie.getUnitInStock() - item.getQuantity());
            editMovie(movie);
        }
        session.flush();
    }
}
