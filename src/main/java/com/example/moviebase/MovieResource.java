package com.example.moviebase;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/movie")
public class MovieResource {

    MovieClient movieClient;

    @GetMapping("/{movie}")
    public void getMovie(@PathVariable("movie") String movie) {
        String s = movieClient.sendRequest(movie);
        System.out.println(s);
    }

    @GetMapping("/{hej}")
    public void getMovie() throws IOException, InterruptedException {
        movieClient.setRequest();
    }



}
