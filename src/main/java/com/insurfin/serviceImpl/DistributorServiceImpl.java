package com.insurfin.serviceImpl;


import com.insurfin.dto.BaseResponse;
import com.insurfin.dto.DistributorRequest;
import com.insurfin.model.Distributor;
import com.insurfin.repository.DistributorRepository;
import com.insurfin.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DistributorServiceImpl implements DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    @Override
    public BaseResponse saveDistributor(DistributorRequest distributorRequest, String userId) {
        Distributor existDistributor = distributorRepository.findByUserId(userId);
        Distributor distributor = new Distributor();
        if(existDistributor == null) {
            if(distributorRequest.getPersonalDetails() != null) {
                savePersonalDetails(distributorRequest, distributor);
            }
            if(distributorRequest.getAddress() != null) {
                saveAddressDetails(distributorRequest, distributor);
            }
            if(distributorRequest.getKyc() != null) {
                saveKycDetails(distributorRequest, distributor);
            }
            return BaseResponse.builder().data(distributor.getDistributorId()).message("Distributor Saved Successfully").error(false).build();
        } else {
            savePersonalDetails(distributorRequest, existDistributor);
            saveAddressDetails(distributorRequest, existDistributor);
            saveKycDetails(distributorRequest, existDistributor);
            return BaseResponse.builder().data(existDistributor.getDistributorId()).message("Distributor Updated Successfully").error(false).build();
        }
    }

    private void saveKycDetails(DistributorRequest distributorRequest, Distributor distributor) {
        distributor.setAccountNumber(distributorRequest.getKyc().getAccountNumber());
        distributor.setBankName(distributorRequest.getKyc().getBankName());
        distributor.setBranchName(distributorRequest.getKyc().getBranchName());
        distributor.setIfscCode(distributorRequest.getKyc().getIfscCode());
        distributorRepository.save(distributor);
    }

    private void saveAddressDetails(DistributorRequest distributorRequest, Distributor distributor) {
        distributor.setAddress(distributorRequest.getAddress());
        distributorRepository.save(distributor);
    }

    private void savePersonalDetails(DistributorRequest distributorRequest, Distributor distributor) {
        distributor.setFullName(distributorRequest.getPersonalDetails().getFullName());
        distributor.setDob(distributorRequest.getPersonalDetails().getDob());
        distributor.setGender(distributorRequest.getPersonalDetails().getGender());
        distributor.setEmail(distributorRequest.getPersonalDetails().getEmail());
        distributor.setPhoneNumber(distributorRequest.getPersonalDetails().getPhoneNumber());
        distributor.setPanNumber(distributorRequest.getPersonalDetails().getPanNumber());
        distributor.setAadhaarNumber(distributorRequest.getPersonalDetails().getAadhaarNumber());
        distributorRepository.save(distributor);
    }
}
