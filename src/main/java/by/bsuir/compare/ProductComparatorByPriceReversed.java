package by.bsuir.compare;

import by.bsuir.model.Product;

public class ProductComparatorByPriceReversed extends ProductComparatorByPrice {

    @Override
    public int compare(Product o1, Product o2) {
        return super.compare(o2, o1);
    }

}