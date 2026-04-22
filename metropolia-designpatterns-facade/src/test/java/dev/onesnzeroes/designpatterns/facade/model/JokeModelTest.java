package dev.onesnzeroes.designpatterns.facade.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokeModelTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testDeserializeFromJson() throws Exception {

        String json = """
        {
          "icon_url": "http://example.com/icon.png",
          "id": "123",
          "url": "http://example.com/joke",
          "value": "Chuck Norris joke",
          "extra_field": "should be ignored"
        }
        """;

        JokeModel model = mapper.readValue(json, JokeModel.class);

        assertEquals("http://example.com/icon.png", model.getIconUrl());
        assertEquals("123", model.getId());
        assertEquals("http://example.com/joke", model.getUrl());
        assertEquals("Chuck Norris joke", model.getValue());
    }

    @Test
    void testSerializeToJson() throws Exception {

        JokeModel model = new JokeModel(
                "icon.png",
                "1",
                "url",
                "joke"
        );

        String json = mapper.writeValueAsString(model);

        assertTrue(json.contains("icon.png"));
        assertTrue(json.contains("joke"));
    }
}