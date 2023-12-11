package app.blogging.payloads;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    private String name;
    private String email;
}
