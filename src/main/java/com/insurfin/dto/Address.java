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
public class Address {

    @NotBlank(message = ApplicationConstants.ADDRESS_TYPE_NOT_BLANK)
    private String addressType;
    @NotBlank(message = ApplicationConstants.ADDRESS_NOT_BLANK)
    private String addressLine1;
    @NotBlank(message = ApplicationConstants.ADDRESS_NOT_BLANK)
    private String addressLine2;
    @NotBlank(message = ApplicationConstants.CITY_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z ]+$", message = ApplicationConstants.INVALID_CITY)
    private String city;
    @NotBlank(message = ApplicationConstants.STATE_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z ]+$", message = ApplicationConstants.INVALID_STATE)
    private String state;
    @NotBlank(message = ApplicationConstants.COUNTRY_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z]+$", message = ApplicationConstants.INVALID_COUNTRY)
    private String country;
    @NotBlank(message = ApplicationConstants.PINCODE_NOT_BLANK)
    @Pattern(regexp = "\\d{6}", message = ApplicationConstants.INVALID_PINCODE)
    private String pinCode;

    private String gstNumber;
}
