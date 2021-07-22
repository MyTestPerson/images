package com.images.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;

@Controller
public class Image {


    @Autowired
    ServletContext servletContext;



    @ResponseBody()
    @GetMapping(value = "/image4")
    public Resource getImage4() {

        return new ServletContextResource(servletContext, "/WEB-INF/image/jackson.jpg");

    }


    @ResponseBody
    @GetMapping(value = "/image5")
    public ResponseEntity<Resource> getImage5() {

        HttpHeaders headers = new HttpHeaders();
        Resource resource = new ServletContextResource(servletContext, "/WEB-INF/image/jackson.jpg");

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);

    }



}
