package com.poket.pokemon.controller;

import com.poket.pokemon.dto.PokemonRequestDto;
import com.poket.pokemon.dto.PokemonResponseDto;
import com.poket.pokemon.entity.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PokemonController {
    private final Map<Long, Pokemon> pList = new HashMap<>();

    @PostMapping("/pokedex")
    public PokemonResponseDto createPokemon(@RequestBody PokemonRequestDto pRequestDto) {
        Pokemon pokemon = new Pokemon();

        Long maxId = pList.size() > 0 ? Collections.max(pList.keySet()) + 1 : 1;
        pokemon.setId(maxId);

        pList.put(pokemon.getId(), pokemon);

        PokemonResponseDto pokemonResponseDto = new PokemonResponseDto(pokemon);

        return pokemonResponseDto;
    }

    @GetMapping("/pokedex")
    public List<PokemonResponseDto> getPokemon() {
        // TODO Stream 알아보기
        List<PokemonResponseDto> responseList = pList.values().stream().map(PokemonResponseDto::new).toList();

        return responseList;
    }

    // TODO Pathvariable 다시 들어보기
    @PutMapping("/pokedex/{id}")
    public Long updatePokemon(@PathVariable Long id, @RequestBody PokemonRequestDto requestDto) {
        if (pList.containsKey(id)) {
            Pokemon pokemon = pList.get(id);

            pokemon.update(requestDto);

            return pokemon.getId();
        } else {
            throw new IllegalArgumentException("포켓몬 없음");
        }
    }

    @DeleteMapping("/pokedex/{id}")
    public Long deletePokemon(@PathVariable Long id) {
        if (pList.containsKey(id)) {
            pList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("칮으시는 포켓몬은 존재하지 않습니다.");
        }
    }
}
