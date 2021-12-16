package com.example.demo.rest.service;

import com.example.demo.rest.model.Movie;

import java.io.IOException;
import java.net.MalformedURLException;

public interface MoviesRestService {

    Movie getMovieById(String id) throws IOException;

    byte[] getPoster(String posterPath) throws IOException;
}
