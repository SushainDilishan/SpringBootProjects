package com.sushain.orderService.model;

import com.sushain.orderService.model.sharedmodel.Product;
import com.sushain.orderService.model.sharedmodel.User;
import sun.jvm.hotspot.oops.Instance;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Date orderDate;
    Date recieveDate;
    String Notes;

    @Transient
    List<Product> products;

    @Transient
    List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(Date recieveDate) {
        this.recieveDate = recieveDate;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

