package com.group.libraryapp.domain.fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Optional<Fruit> findByName(String name);

    List<Fruit> findAllByName(String name);

    List<Fruit> findAllByPriceGreaterThanEqualAndIsSold(long price,boolean isSold);
    List<Fruit> findAllByPriceLessThanEqualAndIsSold(long price,boolean isSold);
}
