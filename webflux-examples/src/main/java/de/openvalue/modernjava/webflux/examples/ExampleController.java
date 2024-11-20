package de.openvalue.modernjava.webflux.examples;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// add an endpoint for all the tasks, test using curl, e.g. curl localhost:8080/flux or the TestClient Class
// 1. return a mono, using Mono.just()
// 2. return a flux, using Flux.just()
// 3. return a ResponseStatusException with code BadRequest using the error method

@RestController
public class ExampleController {


}
