package pl.coderslab.exam;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HeroComponent {
    List<Hero> heroList = new ArrayList<>();

    public List<Hero> getHeroList() {
        return heroList;
    }

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