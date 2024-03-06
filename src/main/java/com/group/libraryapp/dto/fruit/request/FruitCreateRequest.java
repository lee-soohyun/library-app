package com.group.libraryapp.dto.fruit.request;

import java.time.LocalDate;

public class FruitCreateRequest {
    private String name;
    private LocalDate warehousingDate;
    private Long price;
    private boolean isSold;
    private long id;

    public long getId() {
        return id;
    }

    public boolean getSold() {
        return isSold;
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

}
