package com.zinzza.getinline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice(basePackageClasses = BaseController.class)
public class BaseController implements ErrorController {

    // 시작 페이지 매핑
    @GetMapping("/")
    public String root() {
        return "index";
    }

    // 에러 표시 페이지 매핑
    @RequestMapping("/error")
    public String error() {
        return "error";
    }

}
