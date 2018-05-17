package by.bsuir.service;

import by.bsuir.compare.ProductComparatorByPrice;
import by.bsuir.compare.ProductComparatorByPriceReversed;
import by.bsuir.compare.ProductComparatorByYear;
import by.bsuir.dao.ProductDao;
import by.bsuir.model.Product;
import by.bsuir.service.interfaces.OrderedProductService;
import by.bsuir.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    private OrderedProductService orderedProductService;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setOrderedProductService(OrderedProductService orderedProductService) {
        this.orderedProductService = orderedProductService;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDao.add(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDao.delete(id);
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return productDao.getById(id);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    @Transactional
    public List<Product> getAllProductsOfUser(int userID) {
        return productDao.getProducts(orderedProductService.getAllOrderedProductsOfUser(userID));
    }

    @Override
    @Transactional
    public List<Product> getAllProductsOfType(String type) {
        return productDao.getAllProductsOfType(type);
    }

    @Override
    @Transactional
    public List<Product> sortProducts(String productType, String sortingType) {
        List<Product> productList = productDao.getAllProductsOfType(productType);
        if (sortingType.equals("year")) {
            productList.sort(new ProductComparatorByYear());
        } else if (sortingType.equals("price")) {
            productList.sort(new ProductComparatorByPriceReversed());
        } else {
            productList.sort(new ProductComparatorByPrice());
        }
        return productList;
    }
}
