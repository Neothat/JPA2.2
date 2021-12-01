package ru.geekbrains.daos;

import ru.geekbrains.models.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustomerById(Long id);

    List<Customer> getAllCustomer();
}
