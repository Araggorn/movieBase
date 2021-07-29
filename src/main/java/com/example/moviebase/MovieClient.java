package com.example.moviebase;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class MovieClient {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MovieClient.class);

    public void sendRequest() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr"))
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());

    }




    public void sendRequestSearch() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://movie-database-imdb-alternative.p.rapidapi.com/?s=Avengers%20Endgame&page=1&r=json"))
                .header("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
