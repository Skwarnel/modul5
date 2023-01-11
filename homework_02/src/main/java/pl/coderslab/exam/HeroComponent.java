package pl.coderslab.exam;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class HeroComponent {
    List<Hero> heroList = new ArrayList<>();

    public List<Hero> getHeroList() {
        return heroList;
    }

    public HeroComponent() {
        Hero hero1 = new Hero();
        Hero hero2 = new Hero();
        Hero hero3 = new Hero();
        Hero hero4 = new Hero();
        Hero hero5 = new Hero();
        Hero hero6 = new Hero();

        hero1.setName("butman");
        hero1.setPhoneNumber("555");
        hero1.setDateOfBirth(LocalDate.of(2020, 12, 10));
        hero1.setPower(200L);

        hero2.setName("hurkules");
        hero2.setPhoneNumber("5123");
        hero2.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero2.setPower(500L);

        hero3.setName("suiderman");
        hero3.setPhoneNumber("765-D");
        hero3.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero3.setPower(2L);

        hero4.setName("guerro");
        hero4.setPhoneNumber("3");
        hero4.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero4.setPower(-10L);

        hero5.setName("tuzeusz");
        hero5.setPhoneNumber("123");
        hero5.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero5.setPower(300L);

        hero6.setName("Bulzebub");
        hero6.setPhoneNumber("1");
        hero6.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero6.setPower(59L);

        heroList.add(hero1);
        heroList.add(hero2);
        heroList.add(hero3);
        heroList.add(hero4);
        heroList.add(hero5);
        heroList.add(hero6);
    }

    Hero hero;

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public void addHero(Hero hero) {
        heroList.add(hero);
    }

    private static final HashMap<String, String> phoneBookEntries = new HashMap<>();

    public Optional<String> findHeroByPhoneNumber(String phoneNumber) {
        return heroList.stream()
                .filter(s -> s.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .map(Hero::toString);
    }
}