package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.coderslab.interfaces.CustomerLogger;
import pl.coderslab.interfaces.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {
    CustomerLogger customerLogger;
    List<Customer> customersDataBase = new ArrayList<>();

    public MemoryCustomerRepository() {
    }

    @Autowired
    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerLogger.log();
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerLogger.log();
    }

    @Override
    public List<Customer> getClients() {
        customerLogger.log();
        return customersDataBase;
    }

    public void setCustomersDataBase(List<Customer> customersDataBase) {
        this.customersDataBase = customersDataBase;
    }

    public CustomerLogger getCustomerLogger() {
        return customerLogger;
    }

    public void setCustomerLogger(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    public List<Customer> getCustomersDataBase() {
        return customersDataBase;
    }
}
