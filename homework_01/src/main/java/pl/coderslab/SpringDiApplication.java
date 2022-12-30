package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.Customer;
import pl.coderslab.beans.MemoryCustomerRepository;
import pl.coderslab.beans.SimpleCustomerLogger;
import pl.coderslab.interfaces.CustomerLogger;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SimpleCustomerLogger simpleCustomerLogger = ctx.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
        simpleCustomerLogger.log();
        MemoryCustomerRepository repo = ctx.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
        Customer customer = new Customer();
        System.out.println(customer);
        System.out.println(repo);
        repo.addCustomer(customer);
        System.out.println(repo.getClients());
        repo.addCustomer(customer);
        System.out.println(repo.getClients());
        repo.addCustomer(customer);
        System.out.println(repo.getClients());
    }
}
