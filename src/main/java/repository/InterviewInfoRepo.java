package repository;

import model.Interviewer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InterviewInfoRepo extends MongoRepository<Integer, InterviewerRepo> {


    public Interviewer findById(int interviewee_id);
}
