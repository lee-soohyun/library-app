package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20, name = "name")
    private String name;
    private Long price;
    private boolean isSold;
    private LocalDate warehousingDate;

    protected Fruit() {}

    public Fruit(String name, Long price,
                 boolean isSold, LocalDate warehousingDate) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("name(%s)은 존재하지 않습니다. 다시 입력해주세요.", name));
        }
        this.name = name;
        this.price = price;
        this.isSold = isSold;
        this.warehousingDate = warehousingDate;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateIsSold() {
        this.isSold = true;
    }

}
