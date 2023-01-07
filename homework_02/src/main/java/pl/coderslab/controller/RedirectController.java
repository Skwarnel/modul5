package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping("/first")
    public String firstDisplay() {
        return "first";
    }

    @RequestMapping("/second")
    public String secondDisplay() {
        return "redirect: third";
    }

    @RequestMapping("/third")
    public String thirdDisplay() {
        return "third";
    }
}
