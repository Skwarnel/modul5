package pl.coderslab.interfaces;

import pl.coderslab.beans.Customer;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getClients();
}
