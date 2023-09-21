package com.snva.security.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "interview_slots")
@Setter
@Getter
    public class InterviewSlot {
        @Id
        private String id;
        private LocalDateTime startTime;
        private LocalDateTime endTime;



}
