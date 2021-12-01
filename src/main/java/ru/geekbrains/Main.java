package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.services.OrderService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean("OrderService", OrderService.class);
        System.out.println("===================");
        System.out.println(orderService.getAllCustomersByProductId(1L));
        System.out.println(orderService.getAllCustomersByProductId(2L));
        System.out.println("===================");
        System.out.println(orderService.getAllProductsByCustomerId(3L));
        System.out.println(orderService.getAllProductsByCustomerId(4L));
        System.out.println("===================");
        System.out.println(orderService.getCostOfGoodsByCustomerAndProductId(4L, 5L));
    }
}
