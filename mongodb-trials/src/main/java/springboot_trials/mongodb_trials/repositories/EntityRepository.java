package springboot_trials.mongodb_trials.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import springboot_trials.mongodb_trials.entities.DataEntry;

@Repository
public interface EntityRepository extends MongoRepository<DataEntry, String> {
}
