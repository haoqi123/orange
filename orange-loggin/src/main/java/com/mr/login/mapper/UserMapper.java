package com.mr.login.mapper;

import com.mr.commont.login.User;
import com.mr.commont.login.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 师利梅 on 2019/5/6.
 */
@Mapper
public interface UserMapper {
    //注册
    void addUser(User user);

    //登录
    User tologin(UserVo userVo);

    //资料
    User selectUser(String userName);
}
