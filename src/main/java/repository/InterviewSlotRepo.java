package repository;

import model.InterviewSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewSlotRepo  extends MongoRepository<InterviewSlot, String> {
}
