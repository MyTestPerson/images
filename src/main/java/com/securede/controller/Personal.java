package com.securede.controller;

import com.securede.service.MyMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Personal {

    @Autowired
    MyMethod myMethod;


    @GetMapping(value = "/personal")
    public ModelAndView personalGet () {


        ModelAndView modelAndView = new ModelAndView("/personal");

        modelAndView.addObject("msg", myMethod.myMsg() + " World !!!");

        return modelAndView;


    }

}
