package com.mr.login.service.impl;

import com.mr.commont.login.User;

import com.mr.login.mapper.UserMapper;
import com.mr.login.service.UserService;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 师利梅 on 2019/5/6.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册账号
     * @param user
     * @return
     */
    @Override
    public ResultVo addUser(User user) {
        userMapper.addUser(user);
        return ResultVo.success("增加成功！");
    }
}
