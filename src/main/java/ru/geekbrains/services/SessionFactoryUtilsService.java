package ru.geekbrains.services;

import org.hibernate.Session;

public interface SessionFactoryUtilsService {
    public void init();

    public void shutdown();

    public Session getSession();
}
