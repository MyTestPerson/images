package com.securede.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Personal {


    @GetMapping(value = "/personal")
    public ModelAndView personalGet () {


        SecurityContext securityContext = SecurityContextHolder.getContext();

        ModelAndView modelAndView = new ModelAndView("/personal");

        modelAndView.addObject("msg", myMsg() + " " + securityContext.getAuthentication().
                getAuthorities().iterator().next().getAuthority());

        return modelAndView;

    }



    @Secured(value = {"ROLE_ADMIN"})
    private String myMsg() {

        return "Hello ";

    }

}
