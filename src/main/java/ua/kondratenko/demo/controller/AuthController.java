package ua.kondratenko.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/success")
    public String getSuccessPage() {
        return "success";
    }

}