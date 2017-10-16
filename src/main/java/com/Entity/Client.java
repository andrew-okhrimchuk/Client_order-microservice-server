package com.Entity;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client implements Serializable{
 //   private static final long serialVersionUID = 1L;

    @Getter
    @Setter
   // @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id1")
    private BigInteger id1;

    @Getter
    @Setter
    @Column
    private String surname;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column //(name = "date_of_birth")
    private Date dateOfBirth;

    @Getter
    @Setter
    @Column
    private String sex;

    //@OneToMany(cascade = CascadeType.ALL)
  //  @PrimaryKeyJoinColumn
 //   private Order order;

    //@OneToMany(mappedBy="book_id", cascade=CascadeType.ALL)
    //private List<Order> book;

    public Client() {
    }

    public BigInteger getId1() {
        return id1;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setId1(BigInteger id1) {
        this.id1 = id1;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
