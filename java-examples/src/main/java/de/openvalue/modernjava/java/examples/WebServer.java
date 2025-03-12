package de.openvalue.modernjava.java.examples;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Path;

// 1. run the server using CLI: jwebserver -p 9000
//  open http://localhost:9000 in your browser
// 2. run this class
//  open http://localhost:9000 in your browser
public class WebServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);

        server.createContext("/", new HelloHandler());
        server.createContext("/welcome", HttpHandlers.of(200, Headers.of("Allow", "GET"), "Welcome"));

        server.start();
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}