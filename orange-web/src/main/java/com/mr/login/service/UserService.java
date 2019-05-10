package com.mr.login.service;

import com.mr.commont.login.User;
import com.mr.commont.login.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 师利梅 on 2019/5/7.
 */
@Service
@FeignClient(value = "provider-login")
public interface UserService {

    @PostMapping(value = "addUser")
    String addUser(@RequestBody User user);

    @GetMapping(value = "yanZhengMa")
    String yanZhengMa(@RequestParam("userName") String userName);

    @GetMapping(value = "tologin")
    String tologin(@RequestBody UserVo userVo);
}
