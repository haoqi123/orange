package com.mr.login.mapper;

import com.mr.commont.login.User;
import org.springframework.stereotype.Component;

/**
 * Created by 师利梅 on 2019/5/6.
 */
@Component
public interface UserMapper {
    void addUser(User user);
}
