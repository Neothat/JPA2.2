package ru.geekbrains.daos;

import ru.geekbrains.models.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
