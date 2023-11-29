package app.blogging.payloads;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    @NotEmpty
    @Size(min = 2,message = "Username must be of min of 4 characters")
    private String name;
    @Email(message = "Invalid Email Address")
    private String email;
    @NotEmpty
    @Size(min=6,message = "Password must of 6 characters")
    private String password;
    private String about;
}
