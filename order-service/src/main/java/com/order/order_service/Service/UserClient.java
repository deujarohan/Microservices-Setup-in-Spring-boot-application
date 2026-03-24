package com.order.order_service.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.order.order_service.Model.UserDTO;

@Component
@FeignClient(value = "user-service", url = "http://localhost:8082")
public interface UserClient {

    @GetMapping("/users/{id}")
    UserDTO getUser(@PathVariable Long id);
}
