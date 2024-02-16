package com.insurfin.dto;

import com.insurfin.util.ApplicationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PersonalDetails {

    @NotBlank(message = ApplicationConstants.NAME_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z ]*$", message = ApplicationConstants.INVALID_NAME)
    private String fullName;
    @NotBlank(message = ApplicationConstants.DOB_NOT_BLANK)
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d{2})$", message = ApplicationConstants.INVALID_DOB)
    private String dob;
    @NotBlank(message = ApplicationConstants.GENDER_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z]+$", message = ApplicationConstants.INVALID_GENDER)
    private String gender;
    @NotBlank(message = ApplicationConstants.EMAIL_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = ApplicationConstants.INVALID_EMAIL)
    private String email;
    @NotBlank(message = ApplicationConstants.PHONE_NUMBER_NOT_BLANK)
    @Pattern(regexp = "(^$|[0-9]{10})", message = ApplicationConstants.INVALID_PHONE_NUMBER)
    private String phoneNumber;
    @NotBlank(message = ApplicationConstants.PAN_NOT_BLANK)
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]", message = ApplicationConstants.INVALID_PAN_NUMBER)
    private String panNumber;
    @NotBlank(message = ApplicationConstants.AADHAAR_NOT_BLANK)
    @Pattern(regexp = "(^$|[0-9]{12})", message = ApplicationConstants.INVALID_AADHAAR_NUMBER)
    private String aadhaarNumber;

}
