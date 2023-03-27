package com.github.filiperobot.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
    private final String json;

    private final HttpResponse<String> httpResponse;

    public ClienteHttp(String url){

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(url)).GET().build();

            this.httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            this.json = this.httpResponse.body();
        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getJson(){
        return json;
    }

    public HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }
}
