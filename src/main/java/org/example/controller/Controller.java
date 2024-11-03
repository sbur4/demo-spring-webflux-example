package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping(path = "/hello/{text}")
    public Mono<String> hello(@PathVariable String text) {
        return Mono.just("Hello, " + text + "!");
    }

    @GetMapping(path = "/hello")
    public Flux<String> hi() {
        Flux<String> flux = Flux.just("Hello ", "World ", "from ", "EPAM", "!");
        flux.subscribe(System.out::println);
        return flux;
    }
}