package by.bsuir.service;

import by.bsuir.dao.OrderDao;
import by.bsuir.dao.ProductDao;
import by.bsuir.model.Order;
import by.bsuir.model.Product;
import by.bsuir.service.interfaces.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private ProductDao productDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void addBasket(int userID) {
        StringBuilder basket = new StringBuilder();
        double price = 0D;
        for (Product p : productDao.getAllProductsOfUser(userID)) {
            if (price != 0) {
                basket.append(", ");
            }
            basket.append(p.getType()).append(p.getManufacturer()).append(p.getModel());
            price += p.getPrice();
        }
        orderDao.add(new Order(userID, basket.toString(), Date.valueOf(new java.util.Date().toString()), price));
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        orderDao.delete(id);
    }
}
