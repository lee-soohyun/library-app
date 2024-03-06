package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitServiceV2 {
    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void  saveFruit(FruitCreateRequest request) {
        Fruit fruit = fruitRepository.save(new Fruit(request.getName(), request.getPrice(), request.getSold(), request.getWarehousingDate()));
    }

    public List<FruitResponse> getFruit() {
        return fruitRepository.findAll().stream()
                .map(FruitResponse::new)
                .collect(Collectors.toList());
    }

    public void updateFruit(FruitUpdateRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        fruit.updateName(request.getName());
        fruitRepository.save(fruit);
    }

    public FruitCountResponse countFruit(String name) {
        long count = fruitRepository.findAllByName(name).stream().count();
        return new FruitCountResponse(count);
    }

    public List<FruitResponse> listFruit(String option, long price) {
        List<Fruit> fruits;
        if (option.equals("GTE")) {
            fruits = fruitRepository.findAllByPriceGreaterThanEqualAndIsSold(price, false);
        } else if (option.equals("LTE")) {
            fruits = fruitRepository.findAllByPriceLessThanEqualAndIsSold(price, false);
        } else {
            throw new IllegalArgumentException();
        }

        return fruits.stream()
                .map(FruitResponse::new)
                .collect(Collectors.toList());
    }

}
