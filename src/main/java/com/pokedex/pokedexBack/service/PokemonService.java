package com.pokedex.pokedexBack.service;

import com.pokedex.pokedexBack.entity.Pokemon;
import com.pokedex.pokedexBack.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    public String createPokemon(Pokemon pokemon){
        try {
            if (!pokemonRepository.existsByNombre(pokemon.getNombre())){
                pokemon.setId(pokemonRepository.findMaxId() + 1);
                pokemonRepository.save(pokemon);
                return "Pokemon fue creado correctamente";
            } else {
                return "Pokemon existe actualmente en la base de datos";
            }
        } catch (Exception e){
            throw e;
        }
    }

    public List<Pokemon> readPokemons(){
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> readPokemon(Integer pokemonId){
        return pokemonRepository.findById(pokemonId);
    }

    public List<Pokemon> readPokemonName(String pokemonNombre){
        return pokemonRepository.findByNombreStartsWith(pokemonNombre);
    }

    @Transactional
    public String updatePokemon(Pokemon pokemon){
        if (pokemonRepository.existsByNombre(pokemon.getNombre())){
            try {
                List<Pokemon> pokemons = pokemonRepository.findByNombre(pokemon.getNombre());
                pokemons.stream().forEach(p -> {
                    Pokemon pokemonQueSeActualiza = pokemonRepository.findById(p.getId()).get();
                    pokemonQueSeActualiza.setNombre(pokemon.getNombre());
                    pokemonQueSeActualiza.setAltura(pokemon.getAltura());
                    pokemonQueSeActualiza.setPeso(pokemon.getPeso());
                    pokemonQueSeActualiza.seturlImg(pokemon.geturlImg());
                });
                return "Pokemon actualizado correctamente.";
            } catch (Exception e){
                throw e;
            }
        } else {
            return "Pokemon no existe en la base datos";
        }
    }

    @Transactional
    public String deletePokemon(Pokemon pokemon){
        if (pokemonRepository.existsByNombre(pokemon.getNombre())){
            try {
                List<Pokemon> pokemons = pokemonRepository.findByNombre(pokemon.getNombre());
                pokemons.stream().forEach(p -> {
                    pokemonRepository.delete(p);
                });
                return "Pokemon eliminado correctamente.";
            } catch (Exception e){
                throw e;
            }
        } else {
            return "Pokemon no existe en la base datos";
        }
    }
}
