package com.insurfin.service;

import com.insurfin.dto.BaseResponse;
import com.insurfin.dto.DistributorRequest;


public interface DistributorService {


    BaseResponse saveDistributor(DistributorRequest distributorRequest, String userId);


}
