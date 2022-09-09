package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {


    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/check2")
    public String check2() {
        return "checktest2";
    }
    @RequestMapping("/check3")
    public String check3() {
        return "checktest3";
    }
    @RequestMapping("/check4")
    public String check4() {
        return "checktest4";
    }
    @RequestMapping("/check5")
    public String check5() {
        return "checktest5";
    }
}
