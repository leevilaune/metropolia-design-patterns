package dev.onesnzeroes.designpatterns.facade.https;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClient {

    private OkHttpClient client;

    public HttpClient(){
        this.client = new OkHttpClient();
    }

    public HttpClient(OkHttpClient client) {
        this.client = client;

    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = this.client.newCall(request).execute()) {
            if(response.body() == null) return null;
            return response.body().string();
        }
    }
}
