/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alebro
 */
@Entity
public class User implements Serializable{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, surname, phone, email;
    private double money;
    private String login, password;
    private long roleID;

    public User() {
    }

    public User(String login, String password, String name, String surname, String phone, String email, double money, long roleID) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.money = money;
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", money=" + money + ", login=" + login + ", password=" + password + ", roleID=" + roleID + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.surname);
        hash = 43 * hash + Objects.hashCode(this.phone);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.money) ^ (Double.doubleToLongBits(this.money) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.login);
        hash = 43 * hash + Objects.hashCode(this.password);
        hash = 43 * hash + (int) (this.roleID ^ (this.roleID >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (Double.doubleToLongBits(this.money) != Double.doubleToLongBits(other.money)) {
            return false;
        }
        if (this.roleID != other.roleID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
   
}
