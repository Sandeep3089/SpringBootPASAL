package com.sandeep.Pasal.rasan;


import javax.persistence.*;

@Entity
@Table
public class Rasan {
    @Id
    @SequenceGenerator(
            name = "rasan_sequence",
            sequenceName = "rasan_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rasan_sequence"
    )
    private int number;
    private String name;
    private int price;
    private int quantity;

    public Rasan() {

    }

    public Rasan(int number, String name, int price, int quantity) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Rasan(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Rasan{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
