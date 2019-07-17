package com.example.springboot_306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model){
        //create a director

        Director director = new Director();
        director.setName ("Stephen Bullock");
        director.setGenre ( "Sci Fi" );

        //create a movie

        Movie movie = new Movie ();
        movie.setTitle ( "Star Movie" );
        movie.setYear ( 2019 );
        movie.setDescription("About stars....");

        //add the movie to an empty list

        Set<Movie> movies = new HashSet<Movie> (  );
        movies.add ( movie );

        movie = new Movie ();
        movie.setTitle ( "DeathStar Ewkos" );
        movie.setYear ( 2010 );
        movie.setDescription ( "About ewkos on the deathstar...." );
        movies.add ( movie );

        //add the list of movies to the director's movie list

        director.setMovies ( movies );

        //save the director to the database

        directorRepository.save ( director );

        //grad sll tje directors from the database and send them to the template

        model.addAttribute ( "directors", directorRepository.findAll () );
        return "index";
    }
}
