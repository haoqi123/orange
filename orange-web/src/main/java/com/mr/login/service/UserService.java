package com.mr.login.service;

import com.mr.commont.login.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 师利梅 on 2019/5/7.
 */
@Service
@FeignClient(value = "provider-login")
public interface UserService {

    @GetMapping(value = "addUser")
    String addUser(@RequestParam("user") User user);
}
