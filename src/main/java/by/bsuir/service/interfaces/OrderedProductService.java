package by.bsuir.service.interfaces;

import by.bsuir.model.OrderedProduct;

import java.util.List;

public interface OrderedProductService {

    List<OrderedProduct> getAllOrderedProductsOfUser(int userID);
    void addProductInBasket(int userID, int productID);
    void deleteProductFromBasket(int orderedProductID);
    void clearUserBasket(int userID);
    double getTotalBasketPrice(int userID);

}
