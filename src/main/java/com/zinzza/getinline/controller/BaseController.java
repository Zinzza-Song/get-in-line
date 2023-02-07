package com.zinzza.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    // 시작 페이지 매핑
    @GetMapping("/")
    public String root() {
        return "index";
    }

}
