package ru.geekbrains.daos;

import ru.geekbrains.models.Customer;
import ru.geekbrains.models.Product;

import java.util.List;

public interface OrderDao {
    List<Product> getAllProductsByCustomerId(Long id);

    List<Customer> getAllCustomersByProductId(Long id);

    Integer getCostOfGoodsByCustomerAndProductId(Long customerId, Long productId);
}
