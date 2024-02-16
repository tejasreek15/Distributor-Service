package com.insurfin.client;

import com.insurfin.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface UserClient {

    @GetExchange("/api/user")
    ResponseEntity<BaseResponse> getUser(@RequestParam String email);
}
