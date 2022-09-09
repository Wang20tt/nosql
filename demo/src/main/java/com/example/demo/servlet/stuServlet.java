package com.example.demo.servlet;

import com.example.demo.Service.stuService;
import com.example.demo.entity.Student;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


    public class stuServlet extends BasicServlet {

        protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
            stuService sService = (stuService) context.getBean("sService");
            List<Student> stu = sService.findAllData();
            req.setAttribute("stu",stu);
            req.getRequestDispatcher("/check2.jsp").forward(req,resp);
        }

    }



