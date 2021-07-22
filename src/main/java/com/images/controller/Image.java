package com.images.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class Image {


    @Autowired
    ServletContext servletContext;


    @GetMapping(value = "/image1")
    public void getImage1(HttpServletResponse response) throws IOException {

        InputStream in = servletContext.getResourceAsStream("/WEB-INF/image/jackson.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


    @GetMapping(value = "/image2")
    public @ResponseBody byte[] getImage2() throws IOException {
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/image/jackson.jpg");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value = "/image3")
    public ResponseEntity<byte[]> getImage3() throws IOException {

        HttpHeaders headers = new HttpHeaders();

        InputStream in = servletContext.getResourceAsStream("/WEB-INF/image/jackson.jpg");
        byte[] media = IOUtils.toByteArray(in);

        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        return new ResponseEntity<>(media, headers, HttpStatus.OK);

    }


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
