package dev.onesnzeroes.designpatterns.facade.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.onesnzeroes.designpatterns.facade.https.HttpClient;
import dev.onesnzeroes.designpatterns.facade.model.JokeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HttpServiceTest {

    private HttpClient httpClient;
    private ObjectMapper mapper;
    private HttpService service;

    @BeforeEach
    void setUp() {
        httpClient = mock(HttpClient.class);
        mapper = new ObjectMapper();
        service = new HttpService(httpClient, mapper);
    }

    @Test
    void testGetJoke_success() throws Exception {
        String json = """
        {
          "id": "1",
          "value": "Chuck Norris joke"
        }
        """;

        when(httpClient.get(anyString())).thenReturn(json);

        Optional<JokeModel> result = service.getJoke();

        assertTrue(result.isPresent());
        assertEquals("Chuck Norris joke", result.get().getValue());
    }

    @Test
    void testGetJoke_httpFails_returnsEmpty() throws Exception {
        when(httpClient.get(anyString())).thenThrow(new RuntimeException("API down"));

        Optional<JokeModel> result = service.getJoke();

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetAttributeValueFromJson_success() throws Exception {
        String json = """
        {
          "name": "Bitcoin",
          "price": "50000"
        }
        """;

        when(httpClient.get(anyString())).thenReturn(json);

        String value = service.getAttributeValueFromJson(
                "http://fake-url.com",
                "price"
        );

        assertEquals("50000", value);
    }

    @Test
    void testGetAttributeValueFromJson_missingAttribute() throws Exception {
        String json = """
        {
          "name": "Bitcoin"
        }
        """;

        when(httpClient.get(anyString())).thenReturn(json);

        assertThrows(IllegalArgumentException.class, () -> {
            service.getAttributeValueFromJson("url", "price");
        });
    }
}