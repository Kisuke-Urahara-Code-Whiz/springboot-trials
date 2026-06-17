package springboot_trials.sse_trials.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import springboot_trials.sse_trials.services.SSEService;

@Slf4j
@RestController
public class SSEController {

    SSEService sseService;

    SSEController(SSEService sseService){
        this.sseService = sseService;
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream() throws IOException, InterruptedException {
        log.info("Controller Thread -> {}", Thread.currentThread().getName());
        SseEmitter emitter = new SseEmitter(0L);
        sseService.stream(emitter);
        log.info("Controller Thread exit -> {}", Thread.currentThread().getName());
        return emitter;
    }

    @GetMapping(value = "/streamJson", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamJson() throws IOException, InterruptedException {
        SseEmitter emitter = new SseEmitter(0L);
        sseService.streamJSON(emitter);
        return emitter;
    }

}