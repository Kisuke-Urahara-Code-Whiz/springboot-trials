package springboot_trials.mongodb_trials.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import springboot_trials.mongodb_trials.entities.DataEntry;
import springboot_trials.mongodb_trials.repositories.EntityRepository;

@Service
@RequiredArgsConstructor
public class TrialService {

    private final EntityRepository entityRepository;

    public void insert(String name){
        entityRepository.save(DataEntry.builder().name(name).build());
    }
}
