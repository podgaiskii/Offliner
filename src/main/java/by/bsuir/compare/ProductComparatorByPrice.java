package by.bsuir.compare;

import by.bsuir.model.Product;

import java.util.Comparator;

public class ProductComparatorByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }

}
