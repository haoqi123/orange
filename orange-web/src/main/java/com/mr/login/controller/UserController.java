package com.mr.login.controller;

        import com.mr.commont.login.User;
        import com.mr.commont.login.UserVo;
        import com.mr.login.service.UserService;
        import org.apache.logging.log4j.message.ReusableMessage;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import java.util.List;


/**
 * Created by 师利梅 on 2019/5/5.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //打开登录页面
    @RequestMapping("login")
    public ModelAndView tologin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login/login");
        return mv;
    }

    //去注册页面
    @RequestMapping("register")
    public ModelAndView toregister(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login/register");
        return mv;
    }

    //验证码
    @RequestMapping("yanZhengMa")
    public String yanZhengMa(String userName){
        return userService.yanZhengMa(userName);
    }

    //注册
    @RequestMapping("addUser")
    public String addUser( User user){
        System.out.println(user);
        return userService.addUser(user);
    }

    @RequestMapping("tologin")
    public String tologin(UserVo userVo){
        return userService.tologin(userVo);
    }

    //去首页
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }


}
