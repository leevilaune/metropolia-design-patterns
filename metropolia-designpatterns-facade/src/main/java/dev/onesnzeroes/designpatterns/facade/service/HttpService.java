package dev.onesnzeroes.designpatterns.facade.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.onesnzeroes.designpatterns.facade.https.HttpClient;
import dev.onesnzeroes.designpatterns.facade.model.JokeModel;

import java.io.IOException;
import java.util.Optional;

public class HttpService {

    public HttpClient httpClient;
    public ObjectMapper mapper;

    public HttpService(HttpClient httpClient, ObjectMapper mapper){
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    /**
     * @return Optional<JokeModel>
     */
    public Optional<JokeModel> getJoke() {
        try {
            String jsonString = this.httpClient.get("https://api.chucknorris.io/jokes/random");

            return Optional.of(this.mapper.readValue(jsonString, JokeModel.class));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     *
     * @param urlString url to fetch from
     * @param attributeName takes json path from root, eg /root/l1/value
     * @return
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        String json = this.httpClient.get(urlString);
        JsonNode node = this.mapper.readTree(json);
        JsonNode valueNode = node.at(attributeName);
        if (valueNode.isMissingNode() || valueNode.isNull()) {
            throw new IllegalArgumentException("Attribute not found: " + attributeName);
        }
        return valueNode.asText();
    }
}
