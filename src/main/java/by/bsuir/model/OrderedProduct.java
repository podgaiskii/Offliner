package by.bsuir.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ordered_products")
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "product_id")
    private int productID;

    public OrderedProduct() { }

    public OrderedProduct(int userID, int productID) {
        this.userID = userID;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProduct that = (OrderedProduct) o;
        return id == that.id &&
                userID == that.userID &&
                productID == that.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, productID);
    }

    @Override
    public String toString() {
        return "OrderedProduct {" +
                "id=" + id +
                ", userID=" + userID +
                ", productID=" + productID +
                " }";
    }
}
