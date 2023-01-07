package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

@Controller
public class HelloController {
    @RequestMapping("/workers")
    public String workersAction(HttpServletRequest req) {
        Random random = new Random();
        String  num = "";
        int numInt = -1;
        String rowNo = "";
        String firstName = "";
        String lastName = "";
        String line = "";
        int number = random.nextInt(17) + 1;
        try {
            File file = new File("/home/griegoriens/module5/homework_02/target/workers.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String[] tokens = line.split(" ");
                num = tokens[0];
                num = num.replace(",", "");
                numInt = Integer.parseInt(num);
                if (numInt == number) {
                    rowNo = tokens[0];
                    firstName = tokens[1];
                    lastName = tokens[2];
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("num", rowNo);
        req.setAttribute("first", firstName);
        req.setAttribute("last", lastName);
        req.setAttribute("number", number);
        return "workers";
    }
}
