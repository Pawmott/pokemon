package com.poket.pokemon.dto;

import com.poket.pokemon.entity.Pokemon;
import lombok.Getter;

@Getter
public class PokemonResponseDto {
    private Long id;
    private String name;
    private String contents;

    public PokemonResponseDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.contents = pokemon.getContents();
    }
}
