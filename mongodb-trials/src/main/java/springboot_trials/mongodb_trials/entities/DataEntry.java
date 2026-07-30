package springboot_trials.mongodb_trials.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "trials")
@Builder
@Data
public class DataEntry {

    @Id
    public String name;

}
