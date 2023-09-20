package controller;
import model.InterviewSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import service.Impl.NotFoundException;
import service.InterviewSlotService;



@RestController
@RequestMapping("/api/interview-slots")
    public class InterviewSlotController {

    private final InterviewSlotService slotService;

    @Autowired
    public InterviewSlotController(InterviewSlotService slotService) {
        this.slotService = slotService;
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<InterviewSlot> createInterviewSlot(@RequestBody InterviewSlot slot) {
        InterviewSlot createdSlot = slotService.createInterviewSlot(slot);
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    // Add other endpoints for viewing, updating, and deleting interview slots if needed
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{slotId}")
    public ResponseEntity<InterviewSlot> updateInterviewSlot(@PathVariable String id, @RequestBody InterviewSlot updatedSlot) throws NotFoundException {
        return new ResponseEntity<>( slotService.updateInterviewSlot(id, updatedSlot), HttpStatus.OK);

    }
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteInterviewSlot( @PathVariable String Id) {
        return slotService.deleteInterviewSlot(Id);
    }

}
