package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.impl.StudentDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/checktest2")
public class test2Controller {
    @CrossOrigin

    public String showResult() {
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Student> stu = sdi.findAllData();
       // Iterator it = stu.iterator();
        String re="";
        //while (it.hasNext()) {
         //   re=re+it.next().toString();
//
     //   }
        return re;
    }

}
