package com.orderprocessing.models;

import javax.persistence.*;
import java.util.Date;

/* This Entity will be used by JPA to enable insertions
* */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    public Integer order_id;

    @Column(name = "customer_id")
    public Integer customer_id;

    @Column(name = "payment_id")
    public Integer payment_id;

    @Column(name = "order_date_created")
    public String order_date_created;

    @Column(name = "order_date_modified")
    public String order_date_modified;

    @Column(name = "order_delivery_method")
    public String order_delivery_method;

    public Order(int order_id, int customer_id, int payment_id, String order_date_created, String order_date_modified, String order_delivery_method) {
        this.customer_id = customer_id;
        this.customer_id = customer_id;
        this.payment_id = payment_id;
        this.order_date_created = order_date_created;
        this.order_date_modified = order_date_modified;
        this.order_delivery_method = order_delivery_method;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(order_id));
        sb.append(", " + customer_id);
        sb.append(", " + payment_id);
        sb.append(", " + order_date_created);
        sb.append(", " + order_date_modified);
        sb.append(", " + order_delivery_method);

        return sb.toString();
    }
}
