package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitResponse;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.service.fruit.FruitServiceV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final JdbcTemplate jdbcTemplate;
    private final FruitServiceV2 fruitService;

    public FruitController(JdbcTemplate jdbcTemplate, FruitServiceV2 fruitService) {
        this.jdbcTemplate = jdbcTemplate;
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest requset) {
        fruitService.saveFruit(requset);
    }

    @GetMapping("/api/v1/fruit/stat")
    public List<FruitResponse> getFruit() {
        return fruitService.getFruit();
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse countFruit(@RequestParam String name) {
        return fruitService.countFruit(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitResponse> listFruit(@RequestParam String option, long price) {
        return fruitService.listFruit(option, price);
    }
}
