package com.pokedex.pokedexBack.service;

import com.pokedex.pokedexBack.entity.Pokemon;
import com.pokedex.pokedexBack.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    public Pokemon createPokemon(Pokemon pokemon) throws Exception {
        try {
            if (!pokemonRepository.existsByNombre(pokemon.getNombre())){
                pokemonRepository.save(pokemon);
                return pokemon;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Pokemon> readPokemons(){
        return pokemonRepository.findAllByOrderByIdAsc();
    }

    public Optional<Pokemon> readPokemon(Integer pokemonId){
        return pokemonRepository.findById(pokemonId);
    }

    public List<Pokemon> readPokemonName(String pokemonNombre){
        return pokemonRepository.findByNombreStartsWith(pokemonNombre);
    }

    @Transactional
    public Pokemon updatePokemon(Pokemon pokemon) throws Exception {
        if (pokemonRepository.existsById(pokemon.getId())){
            try {
                Pokemon pokemonQueSeActualiza = pokemonRepository.findById(pokemon.getId()).get();
                pokemonQueSeActualiza.setNombre(pokemon.getNombre());
                pokemonQueSeActualiza.setAltura(pokemon.getAltura());
                pokemonQueSeActualiza.setPeso(pokemon.getPeso());
                pokemonQueSeActualiza.setUrlImg(pokemon.getUrlImg());
                pokemonQueSeActualiza.setTipo(pokemon.getTipo());
                return pokemonQueSeActualiza;
            } catch (Exception e){
                throw e;
            }
        } else {
            throw new Exception();
        }
    }

    @Transactional
    public Pokemon deletePokemon(Pokemon pokemon) throws Exception {
        if (pokemonRepository.existsById(pokemon.getId())){
            try {
                Optional<Pokemon> pokemons = pokemonRepository.findById(pokemon.getId());
                pokemons.stream().forEach(p -> {
                    pokemonRepository.delete(p);
                });
                return pokemon;
            } catch (Exception e){
                throw e;
            }
        } else {
            throw new Exception();
        }
    }
}
