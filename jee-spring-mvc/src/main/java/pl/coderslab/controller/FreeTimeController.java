package pl.coderslab.controller;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Controller
public class FreeTimeController {
//    LocalDateTime currentTime = LocalDateTime.now();
    LocalDateTime currentTime = LocalDateTime.of(2022, 11, 27, 18, 5, 55);
    DayOfWeek dayOfWeek = currentTime.getDayOfWeek();
    int currentHour = currentTime.getHour();

    @GetMapping("/show-calendar")
    @ResponseBody
    public String showCalendar() {
        if (String.valueOf(dayOfWeek).equals("SUNDAY") ||(String.valueOf(dayOfWeek).equals("SATURDAY"))) {
            return "DAY OFF";
        } else if (currentHour >= 9 && currentHour <= 17) {
            return "Busy, don't call";
        } else {
            return "Free time";
        }

    }
}
