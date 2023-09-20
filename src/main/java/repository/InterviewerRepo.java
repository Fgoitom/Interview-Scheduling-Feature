package repository;

import model.Interviewer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepo extends MongoRepository<Integer, Interviewer> {
}
