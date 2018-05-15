package by.bsuir.dao;

import by.bsuir.model.OrderedProduct;
import by.bsuir.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends AbstractDao<Product> {

    @Override
    protected Class getEntityClass() {
        return Product.class;
    }

    public List<Product> getProducts(List<OrderedProduct> orderedProductList) {
        List<Product> productList = new ArrayList<>();
        Criteria criteria = getCurrentSession().createCriteria(Product.class);
        for (OrderedProduct op : orderedProductList) {
            productList.add((Product) criteria.add(Restrictions.eq("id", op.getProductID())).uniqueResult());
        }
        return productList;
    }

    public List<Product> getAllProductsOfUser(int userID) {
        return getProducts((new OrderedProductDao()).getAllOrderedProductsOfUser(userID));
    }

    public List<Product> getAllProductsOfType(String type) {
        Criteria criteria = getCurrentSession().createCriteria(Product.class);
        return (List<Product>) criteria.add(Restrictions.eq("type", type)).list();
    }

}
