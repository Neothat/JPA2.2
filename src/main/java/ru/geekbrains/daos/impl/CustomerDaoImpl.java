package ru.geekbrains.daos.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.daos.CustomerDao;
import ru.geekbrains.models.Customer;
import ru.geekbrains.services.SessionFactoryUtilsService;

import java.util.List;

@Component("CustomerDao")
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactoryUtilsService factory;

    @Override
    public Customer getCustomerById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Customer customer = session.createQuery("SELECT c FROM Customer c WHERE id = :id", Customer.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("SELECT c FROM Customer c").getResultList();
            return customers;
        }
    }

    @Autowired
    public void setFactory(SessionFactoryUtilsService factory) {
        this.factory = factory;
    }
}
