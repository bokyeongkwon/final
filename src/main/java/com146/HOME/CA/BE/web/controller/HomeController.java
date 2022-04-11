package com146.HOME.CA.BE.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class HomeController {

  @RequestMapping("/")
  public String home(HttpServletRequest request){
    log.info("info={}","home()호출됨");

//  임시 메인.
    return "home";
  }



}