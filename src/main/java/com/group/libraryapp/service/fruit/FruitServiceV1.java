package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.fruit.response.FruitResponse;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.repository.fruit.FruitJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceV1 {

    private final FruitJdbcRepository fruitJdbcRepository;

    public FruitServiceV1(FruitJdbcRepository fruitJdbcRepository) {
        this.fruitJdbcRepository = fruitJdbcRepository;
    }

    public void saveFruit(FruitCreateRequest request) {
        fruitJdbcRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice(), request.getSold());
    }

    public List<FruitResponse> getFruit() {
        return fruitJdbcRepository.getFruit();
    }

    public void updateFruit(FruitUpdateRequest request) {
        if(fruitJdbcRepository.isFruitNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        fruitJdbcRepository.updateFruit(request.getName(), request.getId());
    }

    public void countFruit(FruitCreateRequest request) {
        fruitJdbcRepository.countFruit(request.getSold(), request.getId());
    }

}
