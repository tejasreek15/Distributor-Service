package com.insurfin.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class DistributorRequest {

    @Valid
    private PersonalDetails personalDetails;
    @Valid
    private List<Address> address;
    @Valid
    private Kyc kyc;
}
