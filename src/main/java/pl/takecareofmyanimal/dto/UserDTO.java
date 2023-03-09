package pl.takecareofmyanimal.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String userName;
    private String name;
    private String lastName;
    private String email;
    private String city;
    private String phone;
}