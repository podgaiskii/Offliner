package by.bsuir.dao;

import by.bsuir.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends AbstractDao<Order> {

    @Override
    protected Class getEntityClass() {
        return Order.class;
    }

}
