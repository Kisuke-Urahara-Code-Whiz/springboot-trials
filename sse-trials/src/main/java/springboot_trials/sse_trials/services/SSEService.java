package springboot_trials.sse_trials.services;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.Duration;

import lombok.extern.slf4j.Slf4j;
import springboot_trials.sse_trials.dtos.SSEResponse;

@Slf4j
@Service
public class SSEService {

    @Async
    public void stream(SseEmitter emitter) throws IOException, InterruptedException {
        for (int i = 1; i <= 20; i++) {
            log.info("SENDING");
            log.info("Service Thread -> {}", Thread.currentThread().getName());
            emitter.send(
                    SseEmitter.event()
                            .name("message")
                            .data("Message " + i)
            );
            Thread.sleep(Duration.ofSeconds(1));
        }
        emitter.complete();
    }

    @Async
    public void streamJSON(SseEmitter emitter) throws IOException, InterruptedException {
        for (int i = 1; i <= 10; i++) {
            emitter.send(
                    SseEmitter.event()
                            .name("message")
                            .data(SSEResponse.builder()
                                    .message("Hello")
                                    .build(), MediaType.APPLICATION_JSON)
            );
            Thread.sleep(Duration.ofSeconds(1));
        }
        emitter.complete();
    }
}
