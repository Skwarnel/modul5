package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {
    List<Customer> customerList = new ArrayList<>();
    CustomerLogger customerLogger;

    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        System.out.println("Customer added");
        customerLogger.log();
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
        System.out.println("Customer removed");
        customerLogger.log();
    }

    @Override
    public List<Customer> getCustomers() {
        customerLogger.log();
        return customerList;
    }
}
