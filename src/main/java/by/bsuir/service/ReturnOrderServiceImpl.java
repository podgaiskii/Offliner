package by.bsuir.service;

import by.bsuir.dao.ReturnOrderDao;
import by.bsuir.model.ReturnOrder;
import by.bsuir.service.interfaces.ReturnOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {

    private ReturnOrderDao returnOrderDao;

    public void setReturnOrderDao(ReturnOrderDao returnOrderDao) {
        this.returnOrderDao = returnOrderDao;
    }

    @Override
    @Transactional
    public void addReturnOrder(int userID, int productID) {
        returnOrderDao.add(new ReturnOrder(userID, productID, Date.valueOf(new java.util.Date().toString())));
    }

    @Override
    @Transactional
    public void deleteReturnOrder(int id) {
        returnOrderDao.delete(id);
    }

    @Override
    @Transactional
    public List<ReturnOrder> getAllReturnOrders() {
        return returnOrderDao.getAll();
    }
}
