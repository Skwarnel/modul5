package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.*;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SimpleCustomerLogger simpleCustomerLogger = context.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
        simpleCustomerLogger.log();
        System.out.println("===================");
        MemoryCustomerRepository memoryCustomerRepository = context.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
        FileCustomerLogger fileCustomerLogger = context.getBean("fileCustomerLogger", FileCustomerLogger.class);
        Customer customer = new Customer();
        memoryCustomerRepository.addCustomer(customer);
        String fileName = "filePath";
        System.out.println(memoryCustomerRepository.getCustomers());
        System.out.println("=========================");
        memoryCustomerRepository.removeCustomer(customer);
        System.out.println("=========================");
        System.out.println(memoryCustomerRepository.getCustomers());
        System.out.println("=========================");
        memoryCustomerRepository.addCustomer(customer);
        fileCustomerLogger.setFileName(fileName);
        System.out.println(memoryCustomerRepository.getCustomers());

    }
}