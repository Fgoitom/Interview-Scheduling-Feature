package service;

import model.InterviewSlot;
import org.springframework.http.ResponseEntity;
import service.Impl.NotFoundException;

public interface InterviewSlotService {
    public InterviewSlot createInterviewSlot(InterviewSlot slot);
    public ResponseEntity<Void> deleteInterviewSlot(String id);
    public InterviewSlot updateInterviewSlot(String id,InterviewSlot updatedSlot) throws NotFoundException;
}
