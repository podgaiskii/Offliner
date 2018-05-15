package by.bsuir.dao;

import by.bsuir.model.ReturnOrder;
import org.springframework.stereotype.Repository;

@Repository
public class ReturnOrderDao extends AbstractDao<ReturnOrder> {

    @Override
    protected Class getEntityClass() {
        return ReturnOrder.class;
    }
}
