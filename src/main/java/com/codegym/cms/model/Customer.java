package com.codegym.cms.model;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity //khai bao Entity, ket noi voi table Customer
@Table(name = "customers")
@NamedQueries({@NamedQuery(name="findAllCustomers",query = "select c from Customer c"),@NamedQuery(name = "findById",query = "select c from Customer c where id=:id")})
public class Customer {

    @Id //Khai bao Id la khoa chinh
    @GeneratedValue(strategy= GenerationType.AUTO) //tu sinh ra Id, khong can nguoi dung nhap
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}