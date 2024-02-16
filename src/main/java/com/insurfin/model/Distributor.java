package com.insurfin.model;

import com.insurfin.dto.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;


@Data
@Document(collection = "Distributor")
public class Distributor {

    @Id
    private String distributorId;
    private String userId;
    private String fullName;
    private String dob;
    private String gender;
    private String email;
    private String phoneNumber;
    private String panNumber;
    private String aadhaarNumber;
    private List<Address> address;
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String accountNumber;
}
