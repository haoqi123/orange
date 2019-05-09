package com.mr.login.service;

import com.mr.commont.login.User;
import com.mr.commont.login.UserVo;
import com.mr.utils.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 师利梅 on 2019/5/6.
 */
public interface UserService {
    ResultVo addUser(User user);

    String yanZhengMa(String userName);

    ResultVo tologin(UserVo userVo);
}
