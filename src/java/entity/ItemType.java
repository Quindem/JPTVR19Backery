/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pupil
 */
@Entity
public class ItemType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    public ItemType() {
    }

    public ItemType( String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return name;
    }

    public void setType(String type) {
        this.name = type;
    }

    @Override
    public String toString() {
        return "ItemType{" + "id=" + id + ", type=" + name + '}';
    }
    
    
   
}
