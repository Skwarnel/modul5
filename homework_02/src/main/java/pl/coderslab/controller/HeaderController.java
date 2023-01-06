package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HeaderController {
    @RequestMapping("/showUserAgent")
    public String showUserAgent(@RequestHeader("user-agent") String userAgentData, HttpServletRequest req) {
        req.setAttribute("userAgent", userAgentData);
        return "userAgent";
    }

    @RequestMapping("/showAgent/{value}")
    public String showAgent(@RequestHeader("user-agent") String userAgentData, @PathVariable(required = false) String value) {
        return "userAgent";
    }

    @RequestMapping("/helloRequestParam")
    @ResponseBody
    public String helloRequest(@RequestParam(name="addressBarParam", required = false) String paramName) {
        System.out.println(paramName);
        return "My param = " + paramName;
    }
}
