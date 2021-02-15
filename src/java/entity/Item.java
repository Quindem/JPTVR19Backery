/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alebro
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private double price;
    private int quantity;
    private long itemTypeID;
    private ArrayList<String> conf;

    public Item() {
    }

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getItemType() {
        return itemTypeID;
    }

    public void setItemType(long itemTypeID) {
        this.itemTypeID = itemTypeID;
    }

    public ArrayList<String> getConf() {
        return conf;
    }

    public void setConf(ArrayList<String> conf) {
        this.conf = conf;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", itemTypeID=" + itemTypeID + ", conf=" + conf + '}';
    }
    
    
    
    

    
    
    
    
    
}
