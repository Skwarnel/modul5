package pl.coderslab.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    SimpleCustomerLogger simpleCustomerLogger() {
        return new SimpleCustomerLogger();
    }

    String fileName = "Config App file name";
    @Bean
    FileCustomerLogger fileCustomerLogger() {
        return new FileCustomerLogger(fileName);
    }

    @Bean
    public CustomerRepository memoryCustomerRepository() {
        return new MemoryCustomerRepository(fileCustomerLogger());
    }
}
