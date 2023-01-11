package pl.coderslab.exam;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Hero implements Comparable<Hero>, Serializable {
    private String name;
    private Long power;
    private LocalDate dateOfBirth;

    private String phoneNumber;

    @Override
    public int compareTo(Hero o) {
        if (Objects.nonNull(o.power)) {
            return this.power.compareTo(o.power) * -1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
