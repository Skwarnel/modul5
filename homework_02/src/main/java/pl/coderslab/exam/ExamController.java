package pl.coderslab.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ExamController {
    HeroComponent heroComponent;

    public ExamController(HeroComponent heroComponent) {
        this.heroComponent = heroComponent;
    }

    @GetMapping("/add-hero")
    public String showForm() {
        return "hero";
    }

    @PostMapping("/add-hero")
    public String createHero(@RequestParam String heroName, @RequestParam Long heroPower, @RequestParam String dateOfBirth, @RequestParam String phoneNumber, HttpServletRequest req) {
        Hero hero = new Hero();
        hero.setName(heroName);
        hero.setPower(heroPower);
        hero.setDateOfBirth(LocalDate.of(Integer.parseInt(dateOfBirth.substring(0, 4)), Integer.parseInt(dateOfBirth.substring(6, 7)), Integer.parseInt(dateOfBirth.substring(9, 10))));
        hero.setPhoneNumber(phoneNumber);
        heroComponent.addHero(hero);
        req.setAttribute("heroName", heroName);
        req.setAttribute("heroPower", heroPower);
        req.setAttribute("dateOfBirth", dateOfBirth);
        req.setAttribute("phoneNumber", phoneNumber);

        return "hero";
    }

    @GetMapping("/showAllHeros")
    @ResponseBody
    public String showHeros() {
        return heroComponent.getHeroList().toString();
    }

    @GetMapping("/hero-list")
    public String chooseHeros(HttpServletRequest req) {
        Map<String, Integer> herosMap = heroComponent.getHeroList().stream()
                .filter(u -> u.getDateOfBirth().getYear() < 2000)
                .collect(Collectors.toMap(h -> h.getName(), u -> Period.between(u.getDateOfBirth(), LocalDate.now()).getYears()));
        req.setAttribute("herosMap", herosMap.entrySet());
        return "heros";
    }

    @ResponseBody
    @GetMapping("/add-cookies")
    public String createCookies(HttpServletResponse resp) {
        Cookie cookie1 = new Cookie("userExam", "JanExam");
        Cookie cookie2 = new Cookie("uidExam", "ccb1b154-c4ff_Exam");
        Cookie cookie3 = new Cookie("IDE_exam", "IntelliJ_Exam");
        cookie1.setMaxAge(10 * 60);
        cookie2.setMaxAge(60 * 60 * 24 * 10);
        cookie3.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        return "cookiesSet";
    }

    @GetMapping("/showAllCookies")
    public String showAllCookies(HttpServletRequest req) {
        Cookie c1 = WebUtils.getCookie(req, "userExam");
        Cookie c2 = WebUtils.getCookie(req, "uidExam");
        Cookie c3 = WebUtils.getCookie(req, "IDE_exam");
        req.setAttribute("item1", c1);
        req.setAttribute("item2", c2);
        req.setAttribute("item3", c3);

        return "all-cookies";
    }
}
