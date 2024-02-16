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
public class Kyc {

    @NotBlank(message = ApplicationConstants.BANK_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = ApplicationConstants.INVALID_BANK)
    private String bankName;
    @NotBlank(message = ApplicationConstants.BRANCH_NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = ApplicationConstants.INVALID_BRANCH)
    private String branchName;
    @NotBlank(message = ApplicationConstants.IFSC_NOT_BLANK)
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = ApplicationConstants.INVALID_IFSC)
    private String ifscCode;
    @NotBlank(message = ApplicationConstants.ACCOUNT_NO_NOT_BLANK)
    @Pattern(regexp = "^[0-9a-zA-Z]{9,18}$", message = ApplicationConstants.INVALID_ACCOUNT_NO)
    private String accountNumber;
}
