package by.bsuir.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "return_orders")
public class ReturnOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "client_id")
    private int clientID;

    @Column(name = "product_id")
    private int productID;

    @Column(name = "date")
    private Date date;

    @Column(name = "reason")
    private String reason;

    public ReturnOrder() {
        this.date = null;
    }

    public ReturnOrder(int clientID, int productID, Date date) {
        this.clientID = clientID;
        this.productID = productID;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnOrder that = (ReturnOrder) o;
        return id == that.id &&
                clientID == that.clientID &&
                productID == that.productID &&
                Objects.equals(date, that.date) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientID, productID, date, reason);
    }

    @Override
    public String toString() {
        return "ReturnOrder{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", productID=" + productID +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}
