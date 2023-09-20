package service.Impl;

import model.InterviewSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.InterviewSlotRepo;
import service.InterviewSlotService;

import java.util.Optional;

@Service
public class InterviewSlotServiceImpl implements InterviewSlotService {
        private final InterviewSlotRepo slotRepository;

        @Autowired
        public InterviewSlotServiceImpl(InterviewSlotRepo slotRepository) {
            this.slotRepository = slotRepository;
        }


    @Override
    public InterviewSlot createInterviewSlot(InterviewSlot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public ResponseEntity<Void> deleteInterviewSlot(String id) {
     slotRepository.deleteById(id);
        return null;
    }




    @Override

    public InterviewSlot updateInterviewSlot(String slotId, InterviewSlot updatedSlot) throws NotFoundException {
        Optional<InterviewSlot> existingSlotOptional = slotRepository.findById(slotId);
        if (existingSlotOptional.isPresent()) {
            InterviewSlot existingSlot = existingSlotOptional.get();

            // Update relevant fields of the existing slot with data from updatedSlot


            existingSlot.setStartTime(updatedSlot.getStartTime());
            existingSlot.setEndTime(updatedSlot.getEndTime());
            // Update other fields as needed

            // Save the updated slot
            return slotRepository.save(existingSlot);
        } else {
            throw new NotFoundException("Slot with ID " + slotId + " not found");
        }
    }

}
