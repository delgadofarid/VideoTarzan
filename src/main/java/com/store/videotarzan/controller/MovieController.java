package com.store.videotarzan.controller;

import com.store.videotarzan.model.Movie;
import com.store.videotarzan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("movieList")
    public String getMovies (Model model) {
        List<Movie> movies = movieService.getMovieList();
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @RequestMapping("/viewMovie/{id}")
    public String viewMovie(@PathVariable Long id, Model model) throws IOException {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "viewMovie";
    }

}
