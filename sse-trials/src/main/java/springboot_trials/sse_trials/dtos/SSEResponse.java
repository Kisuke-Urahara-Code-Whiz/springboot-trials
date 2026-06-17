package springboot_trials.sse_trials.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SSEResponse  {

    private String message;

}
