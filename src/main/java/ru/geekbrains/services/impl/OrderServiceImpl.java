package ru.geekbrains.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.daos.OrderDao;
import ru.geekbrains.models.Customer;
import ru.geekbrains.models.Product;
import ru.geekbrains.services.OrderService;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao;

    @Override
    public List<Product> getAllProductsByCustomerId(Long id) {
        return orderDao.getAllProductsByCustomerId(id);
    }

    @Override
    public List<Customer> getAllCustomersByProductId(Long id) {
        return orderDao.getAllCustomersByProductId(id);
    }

    @Override
    public Integer getCostOfGoodsByCustomerAndProductId(Long customerId, Long productId) {
        return orderDao.getCostOfGoodsByCustomerAndProductId(customerId, productId);
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
