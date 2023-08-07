package com.apotek.transaction.feignclient;


import com.apotek.transaction.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserFeignClient {
    @GetMapping("/user/all")
    List<UserDTO> getAllUsers();

    @GetMapping("/user/{id}")
    UserDTO getUserById(@PathVariable Integer id);
}
