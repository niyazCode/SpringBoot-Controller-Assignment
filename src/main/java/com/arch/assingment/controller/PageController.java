package com.arch.assingment.controller;

import com.arch.assingment.instance.PageNotFound;
import com.arch.assingment.model.Data;
import com.arch.assingment.model.Page;
import com.arch.assingment.service.PageService;
import com.arch.assingment.util.CustomeMeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/user")
public class PageController {

    @Autowired
    PageService pageService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/getalluser")
    public List<Data> getUserData() {
        return pageService.retrieveAllUsers();
    }

    @GetMapping(value = "/getuserlist" ,produces = "application/json")
    public Page getUserData(@RequestParam(name = "page" , defaultValue = "1") String page) throws PageNotFound {
        return pageService.retrieveAllUsers(page);
    }

    @GetMapping(value = "/getuserlist")
    public Page getUserData2(@RequestParam(name = "page" , defaultValue = "1") String page) throws PageNotFound {
        return pageService.retrieveAllUsers(page);
    }
}
