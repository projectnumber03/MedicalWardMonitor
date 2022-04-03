package ru.plorum.util;

import ru.plorum.repository.PropertiesRepository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public enum WebClient {

    INSTANCE;

    public String get(final String url) throws Exception {
        final String serverAddress = PropertiesRepository.INSTANCE.getString("server.address");
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("%s%s", serverAddress, url)))
                .GET()
                .build();
        final HttpResponse<String> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
