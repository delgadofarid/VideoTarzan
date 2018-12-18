package com.store.videotarzan.controller.admin;

import com.store.videotarzan.model.Actor;
import com.store.videotarzan.model.Movie;
import com.store.videotarzan.service.ActorService;
import com.store.videotarzan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminMovie {

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;

    private Path path;

    @RequestMapping("/movie/addMovie")
    public String addMovie(Model model) {
        List<Actor> actors = actorService.getActorList();
        Movie movie = new Movie();
        movie.setUnitInStock(0);
        model.addAttribute("movie", movie);
        model.addAttribute("actors", actors);
        return "addMovie";

    }

    @RequestMapping(value = "/movie/addMovie", method = RequestMethod.POST)
    public String addMoviePost(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, Model model,
                               HttpServletRequest request) throws RuntimeException {

        if (result.hasErrors()) {
            List<Actor> actors = actorService.getActorList();
            model.addAttribute("actors", actors);
            return "addMovie";
        }

        movieService.addMovie(movie);

        MultipartFile movieImage = movie.getMovieImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + movie.getMovieId() + ".png");

        if (movieImage != null && !movieImage.isEmpty()) {
            try {
                movieImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Movie image saving failed", e);
            }
        }

        return "redirect:/admin/movieInventory";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "movieCast",
                new CustomCollectionEditor(List.class) {
                    @Override
                    protected Object convertElement(Object element) {
                        long id = Long.parseLong(String.valueOf(element));
                        Actor actor = actorService.getActorById(id);
                        return actor;
                    }

                });
    }

    @RequestMapping("/movie/editMovie/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        List<Actor> actors = actorService.getActorList();
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie",movie);
        model.addAttribute("actors", actors);
        return "editMovie";
    }

    @RequestMapping(value = "/movie/editMovie", method = RequestMethod.POST)
    public String editMoviePost(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, Model model,
                                HttpServletRequest request) throws RuntimeException {

        if (result.hasErrors()) {
            List<Actor> actors = actorService.getActorList();
            model.addAttribute("actors", actors);
            return "editMovie";
        }

        MultipartFile movieImage = movie.getMovieImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + movie.getMovieId() + ".png");

        if (movieImage != null && !movieImage.isEmpty()) {
            try {
                movieImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Movie image saving failed", e);
            }
        }

        movieService.editMovie(movie);

        return "redirect:/admin/movieInventory";

    }

    @RequestMapping("/movie/deleteMovie/{id}")
    public String deleteMovie (@PathVariable Long id, Model model, HttpServletRequest request){

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        movieService.deleteMovie(movieService.getMovieById(id));

        return "redirect:/admin/movieInventory";
    }


}
