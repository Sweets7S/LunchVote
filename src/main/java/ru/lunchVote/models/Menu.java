package ru.lunchVote.models;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

// Sweets
@Entity
@Table(name = "MENU")
@ToString
@NoArgsConstructor
public class Menu {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "NAME_FIRST")
    private String nameFirst;
    @Column(name = "NAME_SECOND")
    private String nameSecond;
    @Column(name = "NAME_DESSERT")
    private String nameDessert;
    @Column(name = "NAME_DRINK")
    private String nameDrink;

    @Column(name = "PRICE_FIRST")
    private int priceFirst;
    @Column(name = "PRICE_SECOND")
    private int priceSecond;
    @Column(name = "PRICE_DESSERT")
    private int priceDessert;
    @Column(name = "PRICE_DRINK")
    private int priceDrink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond;
    }

    public String getNameDessert() {
        return nameDessert;
    }

    public void setNameDessert(String nameDessert) {
        this.nameDessert = nameDessert;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public int getPriceFirst() {
        return priceFirst;
    }

    public void setPriceFirst(int priceFirst) {
        this.priceFirst = priceFirst;
    }

    public int getPriceSecond() {
        return priceSecond;
    }

    public void setPriceSecond(int priceSecond) {
        this.priceSecond = priceSecond;
    }

    public int getPriceDessert() {
        return priceDessert;
    }

    public void setPriceDessert(int priceDessert) {
        this.priceDessert = priceDessert;
    }

    public int getPriceDrink() {
        return priceDrink;
    }

    public void setPriceDrink(int priceDrink) {
        this.priceDrink = priceDrink;
    }
}
