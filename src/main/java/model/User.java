package model;




import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document
public class User {
@Id
    private int id;
    private String username;
    private String password;
    private Role roles;
}
