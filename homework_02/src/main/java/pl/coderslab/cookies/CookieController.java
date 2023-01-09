package pl.coderslab.cookies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {
    @RequestMapping("/addCookies")
    public void cookiesAdd(HttpServletResponse resp) {
        Cookie cookie1 = new Cookie("user", "Jan");
        Cookie cookie2 = new Cookie("uid", "ccb1b154-c4ff");
        Cookie cookie3 = new Cookie("IDE", "IntelliJ");
        Cookie cookie4 = new Cookie("myCookie", "Genius");
        cookie1.setMaxAge(60 * 10);
        cookie2.setMaxAge(60 * 60 * 24 * 10);
        cookie3.setMaxAge(60 * 60 * 24 * 31);
        cookie4.setMaxAge(15);

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.addCookie(cookie4);
    }

    @GetMapping("/all-cookies")
    public String showCookies(HttpServletRequest req) {
        Cookie c1 = WebUtils.getCookie(req, "user");
        Cookie c2 = WebUtils.getCookie(req, "uid");
        Cookie c3 = WebUtils.getCookie(req, "IDE");
        Cookie c4 = WebUtils.getCookie(req, "myCookie");

        List<Cookie> cookies = new ArrayList<>();

        cookies.add(c1);
        cookies.add(c2);
        cookies.add(c3);
        cookies.add(c4);

        req.setAttribute("cookies", cookies);
        return "showCookies";
    }
}
