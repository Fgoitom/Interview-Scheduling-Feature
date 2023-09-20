package model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Time;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Document
public class InterviewsInfo {
@Id

    private int interviewee_id;
    private Date date;
    private Time time;
    private String location;
    private String status;


    private List<Interviewer> interviewer;




}
