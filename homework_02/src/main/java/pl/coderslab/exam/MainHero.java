package pl.coderslab.exam;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainHero {
    public static void main(String[] args) {
        HeroComponent heroComponent = new HeroComponent();
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

        System.out.println(hero2.compareTo(hero1));
        System.out.println("================");

        heroComponent.addHero(hero1);
        heroComponent.addHero(hero2);
        heroComponent.addHero(hero3);
        heroComponent.addHero(hero4);
        heroComponent.addHero(hero5);
        heroComponent.addHero(hero6);

        heroComponent.heroList.stream()
                .filter(u -> u.getName().length() > 2)
                .filter(u -> Objects.nonNull(u.getPower()))
                .filter(u -> u.getName().charAt(1) == 'u' && u.getPower() < 1)
                .map(u -> u.getName())
                .forEach(u -> System.out.println(u));

        System.out.println("================");

        heroComponent.heroList.stream()                .sorted(Hero::compareTo)
                .map(k -> k.getName())
                .forEach(u -> System.out.println(u));

        System.out.println("================");

        heroComponent.heroList.stream()
                .map(u -> u.getName().charAt(0))
                .forEach(u -> System.out.println(u));

        System.out.println("================");

        heroComponent.heroList.stream()
                .map(k -> k.getName())
                .map(w -> w.toUpperCase())
                .forEach(z -> System.out.println(z));

        System.out.println("================");

        String toCheck = heroComponent.heroList.stream()
                .map(k -> k.getName())
                .collect(Collectors.joining("-"));

        System.out.println(toCheck);
        System.out.println("\nFINAL SOLUTION\n");

        String result = heroComponent.heroList.stream()
                .filter(u -> u.getName().length() > 2)
                .filter(u -> Objects.nonNull(u.getPower()))
                .filter(u -> u.getName().charAt(1) == 'u' && u.getPower() > 5)
                .sorted(Hero::compareTo)
                .map(h -> h.getName().toUpperCase())
                .map(n -> String.valueOf(n.charAt(0)))
                .collect(Collectors.joining("-"));

        System.out.println(result);
        System.out.println("================");

        System.out.println(heroComponent.findHeroByPhoneNumber("555"));
        System.out.println(heroComponent.findHeroByPhoneNumber("5123"));
        System.out.println(heroComponent.findHeroByPhoneNumber("765-D"));
        System.out.println(heroComponent.findHeroByPhoneNumber("3"));
        System.out.println(heroComponent.findHeroByPhoneNumber("123"));
        System.out.println(heroComponent.findHeroByPhoneNumber("1"));
        System.out.println(heroComponent.findHeroByPhoneNumber("Grzegorz"));


    }
}
