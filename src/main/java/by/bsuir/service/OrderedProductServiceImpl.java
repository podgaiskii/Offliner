package by.bsuir.service;

import by.bsuir.dao.OrderedProductDao;
import by.bsuir.dao.ProductDao;
import by.bsuir.model.OrderedProduct;
import by.bsuir.model.Product;
import by.bsuir.service.interfaces.OrderedProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderedProductServiceImpl implements OrderedProductService {

    private OrderedProductDao orderedProductDao;
    private ProductDao productDao;

    public void setOrderedProductDao(OrderedProductDao orderedProductDao) {
        this.orderedProductDao = orderedProductDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<OrderedProduct> getAllOrderedProductsOfUser(int userID) {
        return orderedProductDao.getAllOrderedProductsOfUser(userID);
    }

    @Override
    @Transactional
    public void addProductInBasket(int userID, int productID) {
        orderedProductDao.add(new OrderedProduct(userID, productID));
    }

    @Override
    @Transactional
    public void deleteProductFromBasket(int orderedProductID) {
        orderedProductDao.delete(orderedProductID);
    }

    @Override
    @Transactional
    public void clearUserBasket(int userID) {
        for (OrderedProduct op : orderedProductDao.getAllOrderedProductsOfUser(userID)) {
            orderedProductDao.delete(op.getId());
        }
    }

    @Override
    @Transactional
    public double getTotalBasketPrice(int userID) {
        double totalPrice = 0;
        for (Product p : productDao.getAllProductsOfUser(userID)) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }

}
