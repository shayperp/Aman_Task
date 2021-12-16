package com.example.demo.rest.service.impl;

import com.example.demo.rest.model.Movie;
import com.example.demo.rest.service.MoviesRestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class MovieRestServiceImpl implements MoviesRestService {
    @Override
    public Movie getMovieById(String id) throws IOException {
        String apiKey = "62dd0423a87fceead32a9f10943fb909";
        String url = String.format("https://api.themoviedb.org/3/movie/ %s?api_key= %s", id, apiKey);
        String s = GetData(url);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(s, Movie.class);
    }

    @Override
    public byte[] getPoster(String posterPath) throws IOException {
        String url = String.format("https://image.tmdb.org/t/p/w500%s", posterPath);
        return getBytes(url);

    }

    private byte[] getBytes(String url) throws IOException {
        URL toDownload = new URL(url);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            byte[] chunk = new byte[4096];
            int bytesRead;
            InputStream stream = toDownload.openStream();

            while ((bytesRead = stream.read(chunk)) > 0) {
                outputStream.write(chunk, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputStream.toByteArray();
    }

    private String GetData(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            return response;


            // an error happened


        }
        return url;

    }



}
