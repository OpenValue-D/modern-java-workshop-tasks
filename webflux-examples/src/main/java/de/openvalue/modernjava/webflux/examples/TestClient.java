package de.openvalue.modernjava.webflux.examples;

import org.springframework.web.reactive.function.client.WebClient;

public class TestClient {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080");

        var response = webClient.get()
                .uri("/api/items")
                .retrieve()
                .bodyToFlux(String.class);

        response.subscribe(
                item -> System.out.println("Received: " + item),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed")
        );

        // keep running long enough for the async operations to complete
        response.blockLast();
    }
}
