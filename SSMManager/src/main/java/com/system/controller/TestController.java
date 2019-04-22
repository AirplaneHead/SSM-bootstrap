package com.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description：测试Controller
 * Created by Administrator on 2017/8/15 0013.
 */
@Controller
@RequestMapping("/test")
public class TestController  {


    @GetMapping("/demo")
    public String dataGrid() {
        return "indeex";
    }

}
