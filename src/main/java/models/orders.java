package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class orders {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @ManyToOne(targetEntity=customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private customer customer_id;

    @ManyToOne(targetEntity=product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private product product_id;

    private String order_address;
    private java.sql.Date delivery_date;
    private java.sql.Date order_date;
    private String status;
    private double order_price;

    public orders(customer customer_id,  product product_id, String address, java.sql.Date delivery_date, java.sql.Date order_date, String status, double price) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.order_address = address;
        this.delivery_date = delivery_date;
        this.order_date = order_date;
        this.status = status;
        this.order_price = price;
    }

    public orders() {}

    public int get_id() {
        return order_id;
    }

    public void set_id(int id) {
        this.order_id = id;
    }

    public String get_address() {
        return order_address;
    }

    public void set_address(String address) {
        this.order_address = address;
    }

    public java.sql.Date get_delivery_date() {
        return delivery_date;
    }

    public void set_delivery_date(java.sql.Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public java.sql.Date get_order_date() {
        return order_date;
    }

    public void set_order_date(java.sql.Date order_date) {
        this.order_date = order_date;
    }

    public String get_status() {
        return status;
    }

    public void set_status(String status) {
        this.status = status;
    }

    public double get_price() {
        return order_price;
    }

    public void set_price(double price) {
        this.order_price = price;
    }

    public customer get_customer_id() {
        return customer_id;
    }

    public void set_customer_id(customer id) {
        this.customer_id = id;
    }

    public product get_product_id() {
        return product_id;
    }

    public void set_product_id(product id) {
        this.product_id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        orders order = (orders) o;
        return order_id == order.order_id &&
                Double.compare(order.order_price, order_price) == 0 &&
                product_id.equals(order.product_id) &&
                customer_id.equals(order.customer_id) &&
                order_address.equals(order.order_address) &&
                delivery_date.equals(order.delivery_date) &&
                status.equals(order.status) &&
                order_date.equals(order.order_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, order_id, customer_id, order_address, delivery_date, status, order_date, order_price);
    }
}
