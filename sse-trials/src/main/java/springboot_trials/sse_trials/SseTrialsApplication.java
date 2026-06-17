package springboot_trials.sse_trials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SseTrialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseTrialsApplication.class, args);
	}

}
