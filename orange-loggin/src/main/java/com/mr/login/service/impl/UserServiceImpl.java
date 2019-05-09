
package com.mr.login.service.impl;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.mr.commont.login.User;

import com.mr.commont.login.UserVo;
import com.mr.login.mapper.UserMapper;
import com.mr.login.service.UserService;
import com.mr.utils.MsgUtil;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
       Random r = new Random();
        user.setUserId(r.nextInt(100));
        user.setUserBirthday(new Date());
        user.setUserStatus(2);
        user.setUserSex(1);
        user.setUserLevel(2);
        userMapper.addUser(user);
        return ResultVo.success("成功");
    }

    //验证码
    @Override
    public String yanZhengMa(String userName) {
        return  MsgUtil.sendMsg(userName);
    }

    //登录
    @Override
    public ResultVo tologin(UserVo userVo) {
        //判断账号是否正确
        User user = userMapper.tologin(userVo);
        if(user == null){
            return ResultVo.error(500,"您的账号或者密码错误！");
        }else if(!user.getUserPhone().equals(userVo.getUserPhone())){
            //判断密码是否正确
            return ResultVo.error(500,"您的账号或者密码错误！");
        }
        return ResultVo.success("登陆成功！");
    }
}
