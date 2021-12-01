package ru.geekbrains.daos.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.daos.OrderDao;
import ru.geekbrains.models.Customer;
import ru.geekbrains.models.Product;
import ru.geekbrains.services.SessionFactoryUtilsService;

import java.util.List;

@Component("OrderDao")
public class OrderDaoImpl implements OrderDao {

    SessionFactoryUtilsService factory;

    @Override
    public List<Product> getAllProductsByCustomerId(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT o.product FROM Order o WHERE o.customer.id =: id")
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Customer> getAllCustomersByProductId(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("SELECT o.customer FROM Order o WHERE o.product.id =: id")
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public Integer getCostOfGoodsByCustomerAndProductId(Long customerId, Long productId) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Integer productCost = session.createQuery("SELECT o.product.cost FROM Order o WHERE o.customer.id =: customerId AND o.product.id =: productId", Integer.class)
                    .setParameter("customerId", customerId)
                    .setParameter("productId", productId)
                    .getSingleResult();
            session.getTransaction().commit();
            return productCost;
        }
    }

    @Autowired
    public void setFactory(SessionFactoryUtilsService factory) {
        this.factory = factory;
    }
}
