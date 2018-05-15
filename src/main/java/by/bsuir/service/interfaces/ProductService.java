package by.bsuir.service.interfaces;

import by.bsuir.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getAllProductsOfUser(int userID);
    List<Product> getAllProductsOfType(String type);
    List<Product> sortProducts(String productType, String sortingType);

}
