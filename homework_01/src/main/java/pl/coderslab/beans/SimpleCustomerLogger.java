package pl.coderslab.beans;

import org.springframework.stereotype.Component;
import pl.coderslab.interfaces.CustomerLogger;

import java.time.LocalDateTime;

@Component
public class SimpleCustomerLogger implements CustomerLogger {
    public SimpleCustomerLogger() {
    }

    @Override
    public void log() {
        System.out.println(LocalDateTime.now() + ": Customer operation");
    }

}
