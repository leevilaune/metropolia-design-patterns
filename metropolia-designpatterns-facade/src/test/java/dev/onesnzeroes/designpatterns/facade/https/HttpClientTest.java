package dev.onesnzeroes.designpatterns.facade.https;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HttpClientTest {

    @Test
    void testGet_success() throws Exception {

        OkHttpClient okHttpClient = mock(OkHttpClient.class);
        Call call = mock(Call.class);
        Response response = mock(Response.class);
        ResponseBody body = mock(ResponseBody.class);

        when(okHttpClient.newCall(any())).thenReturn(call);
        when(call.execute()).thenReturn(response);
        when(response.body()).thenReturn(body);
        when(body.string()).thenReturn("{\"hello\":\"world\"}");

        HttpClient httpClient = new HttpClient(okHttpClient);

        String result = httpClient.get("http://test-url");

        assertEquals("{\"hello\":\"world\"}", result);
    }

    @Test
    void testGet_throwsIOException() throws Exception {

        OkHttpClient okHttpClient = mock(OkHttpClient.class);
        Call call = mock(Call.class);

        when(okHttpClient.newCall(any())).thenReturn(call);
        when(call.execute()).thenThrow(new IOException("network error"));

        HttpClient httpClient = new HttpClient(okHttpClient);

        assertThrows(IOException.class, () -> {
            httpClient.get("http://test-url");
        });
    }

    @Test
    void testGet_nullBody_returnsNull() throws Exception {

        OkHttpClient okHttpClient = mock(OkHttpClient.class);
        Call call = mock(Call.class);
        Response response = mock(Response.class);

        when(okHttpClient.newCall(any())).thenReturn(call);
        when(call.execute()).thenReturn(response);
        when(response.body()).thenReturn(null);

        HttpClient httpClient = new HttpClient(okHttpClient);

        String result = httpClient.get("http://test-url");

        assertNull(result);
    }
}