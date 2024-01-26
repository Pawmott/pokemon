package com.poket.pokemon.entity;

import com.poket.pokemon.dto.PokemonRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pokemon {
    private Long id;
    private String name;
    private String contents;

    public void update(PokemonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }
}
