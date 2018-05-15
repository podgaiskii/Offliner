package by.bsuir.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "basket")
    private String basket;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private double price;

    public Order() {
        this.basket = null;
        this.date = null;
    }

    public Order(int userID, String basket, Date date, double price) {
        this.userID = userID;
        this.basket = basket;
        this.date = date;
        this.price = price;
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

    public String getBasket() {
        return basket;
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                userID == order.userID &&
                Double.compare(order.price, price) == 0 &&
                Objects.equals(basket, order.basket) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, basket, date, price);
    }

    @Override
    public String toString() {
        return "Order {" +
                "id=" + id +
                ", userID=" + userID +
                ", basket='" + basket + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                " }";
    }
}
