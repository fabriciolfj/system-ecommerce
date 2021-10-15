package com.github.fabriciolfj.shoppingcart.adatpter.in.controller;

import com.github.fabriciolfj.shoppingcart.adatpter.in.controller.dto.CartRequestDTO;
import com.github.fabriciolfj.shoppingcart.adatpter.in.controller.mapper.CartMapper;
import com.github.fabriciolfj.shoppingcart.application.in.CartCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static reactor.core.publisher.Mono.just;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartCreate cartCreate;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@Valid @RequestBody final CartRequestDTO dto) {
        return just(dto)
                .map(CartMapper.INSTANCE::toDomain)
                .flatMap(cartCreate::execute)
                .log();
    }
}
