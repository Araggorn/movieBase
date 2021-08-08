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

    public String sendRequest(String movie) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb8.p.rapidapi.com/auto-complete?q=" + movie))
                .header("x-rapidapi-key", "df5215ec0dmsh8fd874d744af291p18754fjsn213892c8404")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        System.out.println(request);
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());
        return response.body();
    }
    public void setRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb8.p.rapidapi.com/title/get-top-stripe?tconst=tt0944947&currentCountry=US&purchaseCountry=US"))
                .header("x-rapidapi-key", "df5215ec0dmsh8fd874d744af291p18754fjsn213892c84047")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
