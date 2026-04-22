package dev.onesnzeroes.designpatterns.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.onesnzeroes.designpatterns.facade.https.HttpClient;
import dev.onesnzeroes.designpatterns.facade.service.HttpService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HttpService service = new HttpService(new HttpClient(), new ObjectMapper());
        try {
            System.out.println(service.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random","value"));
            System.out.println(service.getAttributeValueFromJson("https://api.fxratesapi.com/latest","base"));
            System.out.println(service.getJoke().orElseThrow(() -> new NullPointerException("Joke has no value")).getValue());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}