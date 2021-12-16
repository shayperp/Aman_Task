package com.example.demo.service.imp;

import com.example.demo.rest.model.Movie;
import com.example.demo.rest.service.FileService;
import com.example.demo.rest.service.MoviesRestService;
import com.example.demo.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final MoviesRestService moviesRestService;
    private final FileService fileService;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public ApplicationServiceImpl(MoviesRestService moviesRestService, FileService fileService) {
        this.moviesRestService = moviesRestService;
        this.fileService = fileService;
    }

    @Override
    public void Task2() {

        Scanner sc = new Scanner(System.in);
        int a = 100;
        Map<String, Double> moviesWithPopularity = new HashMap<>();
        do {
            System.out.print("Enter imdb id - ");
            a = sc.nextInt();
            String imdbId = String.valueOf(a);
            Movie movieById = null;
            try {
                movieById = moviesRestService.getMovieById(imdbId);
                saveThePoster(movieById);
            } catch (IOException e) {
                logger.log(Level.WARNING, "Cant desiralize" + e.getMessage());
                break;
            }
            logger.log(Level.INFO, "movie title  : " + movieById.getOriginalTitle());
            moviesWithPopularity.put(movieById.getTitle(), movieById.getPopularity());
        } while (a != 0);

        Map.Entry<String, Double> mostPopularMovie = Collections.max(moviesWithPopularity.entrySet(), Map.Entry.comparingByValue());
        String mostPopularMovieString = String.format("Most popular movie %s with rating %.2f", mostPopularMovie.getKey(), mostPopularMovie.getValue());
        logger.log(Level.INFO, "Most popular movie : " + mostPopularMovieString);

    }

    private void saveThePoster(Movie movieById) {
        String posterPath = movieById.getPosterPath();
        try {

            byte[] poster = moviesRestService.getPoster(posterPath);
            posterPath = posterPath.replace("/", "");
            String path = String.format("c:\\temp\\%s",posterPath);
            fileService.saveFile(path,poster);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

    }
}
