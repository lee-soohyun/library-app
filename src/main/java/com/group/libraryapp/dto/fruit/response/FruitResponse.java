package com.group.libraryapp.dto.fruit.response;

import com.group.libraryapp.domain.fruit.Fruit;

import java.time.LocalDate;

public class FruitResponse {
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean isSold;
    private long id;

    public FruitResponse(String name, LocalDate warehousingDate,
                         long price, boolean isSold, long id) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
        this.id = id;
    }

    public FruitResponse(Fruit fruit) {
        this.name = getName();
        this.warehousingDate = getWarehousingDate();
        this.price = getPrice();
        this.isSold = getSold();
        this.id = getId();
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public boolean getSold() {
        return isSold;
    }

    public long getId() {
        return id;
    }
}
