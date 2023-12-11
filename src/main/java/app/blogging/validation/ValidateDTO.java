package app.blogging.validation;

import app.blogging.exceptions.DTOValidationException;
import app.blogging.payloads.UserRequestDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidateDTO {
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    private static final String ALPHA_REGEX = "^[a-zA-Z\\s]+$";
    private static final String ALPHANUM_REGEX = "^[a-zA-Z0-9\\s_!#@$%&'*+/=?`{|}~^-]*$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$";

    public static boolean validUserRequestDto(UserRequestDto user){
        if(user.getEmail()==null || !user.getEmail().matches(EMAIL_REGEX)){
            throw new DTOValidationException("Email","Email can't be blank and must be valid format");
        }
        if(user.getName()==null || !user.getName().matches(ALPHA_REGEX) || user.getName().length()==0){
            throw new DTOValidationException("Name","Name can't be blank or contain invalid characters");
        }
        if (user.getPassword()==null || !user.getPassword().matches(PASSWORD_REGEX) ){
            throw new DTOValidationException("Password","Password must be 8 characters and must contain atleast one Letter, Special Character, UpperCase, LowerCase and Digit");
        }
        if(user.getAbout()==null || !user.getAbout().matches(ALPHANUM_REGEX)){
            throw new DTOValidationException("About","About must not be null and must contain Alphanumeric Characters");
        }
        return true;
    }
}
