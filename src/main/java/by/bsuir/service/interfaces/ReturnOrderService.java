package by.bsuir.service.interfaces;

import by.bsuir.model.ReturnOrder;

import java.util.List;

public interface ReturnOrderService {

    void addReturnOrder(int userID, int productID);
    void deleteReturnOrder(int id);
    List<ReturnOrder> getAllReturnOrders();

}
