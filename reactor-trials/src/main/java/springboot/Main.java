package springboot;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");
    }

    public static Flux<Integer> sendFlux() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> i*10);
    }

}