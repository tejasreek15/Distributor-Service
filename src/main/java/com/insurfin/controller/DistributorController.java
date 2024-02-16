package com.insurfin.controller;


import com.insurfin.dto.DistributorRequest;

import com.insurfin.service.DistributorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
@Validated
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    @PostMapping("/saveDistributor")
    @PreAuthorize(value = "hasAnyRole('ROLE_DISTRIBUTOR')")
    public ResponseEntity<?> saveDistributor(@RequestBody @Valid DistributorRequest distributorRequest, @RequestParam String userId) {
        return new ResponseEntity<>(distributorService.saveDistributor(distributorRequest, userId), HttpStatus.CREATED);
    }

}
