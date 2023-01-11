package pl.coderslab.exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainHero {
    public static void main(String[] args) {
        List<Hero> heroList = new ArrayList<>();

        Hero hero1 = new Hero();
        Hero hero2 = new Hero();
        Hero hero3 = new Hero();
        Hero hero4 = new Hero();
        Hero hero5 = new Hero();
        Hero hero6 = new Hero();

        hero1.setName("Butman");
        hero1.setPhoneNumber("555");
        hero1.setDateOfBirth(LocalDate.of(2020, 12, 10));
        hero1.setPower(200L);

        hero2.setName("Hurkules");
        hero2.setPhoneNumber("5123");
        hero2.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero2.setPower(500L);

        hero3.setName("Suiderman");
        hero3.setPhoneNumber("5123");
        hero3.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero3.setPower(2L);

        hero4.setName("Gueroj");
        hero4.setPhoneNumber("5123");
        hero4.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero4.setPower(-10L);

        hero5.setName("Tuzeusz");
        hero5.setPhoneNumber("5123");
        hero5.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero5.setPower(300L);

        hero6.setName("Bulzebub");
        hero6.setPhoneNumber("5123");
        hero6.setDateOfBirth(LocalDate.of(2018, 10, 2));
        hero6.setPower(59L);

        System.out.println(hero2.compareTo(hero1));
        System.out.println("================");

        heroList.add(hero1);
        heroList.add(hero2);
        heroList.add(hero3);
        heroList.add(hero4);
        heroList.add(hero5);
        heroList.add(hero6);

        heroList.stream()
                .filter(u -> u.getName().length() > 2)
                .filter(u -> Objects.nonNull(u.getPower()))
                .filter(u -> u.getName().charAt(1) == 'u' && u.getPower() < 1)
                .map(u -> u.getName())
                .forEach(u -> System.out.println(u));

        System.out.println("================");

        heroList.stream()
                .sorted(Hero::compareTo)
                .map(k -> k.getName())
                .forEach(u -> System.out.println(u));

        System.out.println("================");

        heroList.stream()
                .map(u -> u.getName().charAt(0))
                .forEach(u -> System.out.println(u));

        System.out.println("================");

        heroList.stream()
                .map(k -> k.getName())
                .map(w -> w.toUpperCase())
                .forEach(z -> System.out.println(z));

        System.out.println("================");

        String toCheck = heroList.stream()
                .map(k -> k.getName())
                .collect(Collectors.joining("-"));

        System.out.println(toCheck);
    }
}
