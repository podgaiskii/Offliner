package by.bsuir.service;

import by.bsuir.dao.OrderDao;
import by.bsuir.dao.ProductDao;
import by.bsuir.model.Order;
import by.bsuir.model.Product;
import by.bsuir.service.interfaces.OrderService;
import by.bsuir.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private ProductDao productDao;
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

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
        for (Product p : productService.getAllProductsOfUser(userID)) {
            if (price != 0) {
                basket.append(", ");
            }
            basket.append(p.getType()).append(' ')
                    .append(p.getManufacturer()).append(' ')
                    .append(p.getModel());
            price += p.getPrice();
        }
        orderDao.add(new Order(userID, basket.toString(), new java.sql.Date(new Date().getTime()), price));
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
