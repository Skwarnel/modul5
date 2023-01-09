package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/workers")
    public String workersAction(Model mod) {
        Random random = new Random();
        String num = "";
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
        mod.addAttribute("num", rowNo);
        mod.addAttribute("first", firstName);
        mod.addAttribute("last", lastName);
        mod.addAttribute("number", number);
        mod.asMap().forEach((k, v) -> logger.info(k + ": " + v));
        return "workers";
    }

    @RequestMapping("/modelValues")
    @ResponseBody
    public String getAllFromMap(Model model) {
        model.addAttribute("num", "rowNo");
        model.addAttribute("first", "firstName");
        model.addAttribute("last", "lastName");
        model.addAttribute("number", 1);
        model.asMap().forEach((k, v) -> logger.info(k + ": " + v));
        return model.asMap().toString();
    }
}
