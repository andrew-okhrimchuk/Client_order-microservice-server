package com.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order1")
public class Order implements Serializable {
   // private static final long serialVersionUID = 1L;




    //@NotNull
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private BigInteger id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "tIN2")
    private Client client;

    @Getter
    @Setter
    @Column
    private boolean status;

    @Getter
    @Setter
    @Column
    private double amount;

    @Getter
    @Setter
    @Column
    private Date date;

    @Getter
    @Setter
    @Column
    private String currency;

    public Order() {}

    public BigInteger getId() {
        return id;
    }



    public boolean isStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
