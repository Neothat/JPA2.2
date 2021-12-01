package ru.geekbrains.daos.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.daos.ProductDao;
import ru.geekbrains.models.Product;
import ru.geekbrains.services.SessionFactoryUtilsService;

import java.util.List;

@Component("ProductDao")
public class ProductDaoImpl implements ProductDao {

    SessionFactoryUtilsService factory;

    @Override
    public Product getProductById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("SELECT p FROM Product p WHERE id = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            return products;
        }
    }

    @Autowired
    public void setFactory(SessionFactoryUtilsService factory) {
        this.factory = factory;
    }
}
