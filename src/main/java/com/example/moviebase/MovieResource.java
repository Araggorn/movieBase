package com.example.moviebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/movie")
public class MovieResource {

    MovieClient movieClient;

    @GetMapping("/get")
    public void getMovie(){
       movieClient.sendRequest();
        System.out.println("aaa");
    }

    @GetMapping("/search")
    public void search() throws IOException, InterruptedException {
        movieClient.sendRequestSearch();
    }


}
