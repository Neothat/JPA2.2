package ru.geekbrains.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.geekbrains.services.SessionFactoryUtilsService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "SessionFactoryUtilsService")
public class SessionFactoryUtilsServiceImpl implements SessionFactoryUtilsService {

    private SessionFactory factory;

    @Override
    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @Override
    @PreDestroy
    public void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

    @Override
    public Session getSession() {
        return factory.openSession();
    }
}
