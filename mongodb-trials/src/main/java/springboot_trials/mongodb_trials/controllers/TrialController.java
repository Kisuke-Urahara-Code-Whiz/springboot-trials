package springboot_trials.mongodb_trials.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import springboot_trials.mongodb_trials.services.TrialService;

@RestController
@RequiredArgsConstructor
public class TrialController {

    private final TrialService trialService;

    @GetMapping
    public ResponseEntity<?> greet(@RequestParam String name) {
        trialService.insert(name);
        return ResponseEntity.ok("Mongo db working");
    }
}