package com.snva.security.model;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Interviewer {
    @Id
    private int id;
    private String name;


    private InterviewsInfo interviewsInfo;
}
