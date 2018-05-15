package by.bsuir.service.interfaces;

import by.bsuir.model.Order;

import java.util.List;

public interface OrderService {

    void addBasket(int userID);
    List<Order> getAllOrders();
    void deleteOrder(int id);

}
