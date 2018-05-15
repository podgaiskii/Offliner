package by.bsuir.compare;

import by.bsuir.model.Product;

import java.util.Comparator;

public class ProductComparatorByYear implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getYear(), o1.getYear());
    }

}