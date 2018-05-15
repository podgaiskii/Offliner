package by.bsuir.dao;

import by.bsuir.model.OrderedProduct;
import by.bsuir.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderedProductDao extends AbstractDao<OrderedProduct> {

    @Override
    protected Class getEntityClass() {
        return OrderedProduct.class;
    }

    public List<OrderedProduct> getAllOrderedProductsOfUser(int userID) {
        Criteria criteria = getCurrentSession().createCriteria(OrderedProduct.class);
        return (List<OrderedProduct>) criteria.add(Restrictions.eq("user_id", userID)).list();
    }

}
