package pl.coderslab.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
//        hero.setDateOfBirth(dateOfBirth);
        String dateOfBirthStr = "654";
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
}
