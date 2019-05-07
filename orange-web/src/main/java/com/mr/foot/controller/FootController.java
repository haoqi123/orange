package com.mr.foot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DELL on 2019/5/6.
 */
@RestController
public class FootController {
    @RequestMapping("footList")
    public ModelAndView footList(){
        ModelAndView mv = new ModelAndView("/foot/foot");
        return mv;
    }
}
