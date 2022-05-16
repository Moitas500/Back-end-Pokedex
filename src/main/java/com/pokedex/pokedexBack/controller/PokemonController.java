package com.pokedex.pokedexBack.controller;

import com.pokedex.pokedexBack.entity.Pokemon;
import com.pokedex.pokedexBack.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "OK";
    }

    @RequestMapping(value = "createPokemon", method = RequestMethod.POST)
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) throws Exception {
        return pokemonService.createPokemon(pokemon);
    }

    @RequestMapping(value = "readPokemons", method = RequestMethod.GET)
    public List<Pokemon> readPokemons(){
        return pokemonService.readPokemons();
    }

    @RequestMapping(value = "readPokemon", method = RequestMethod.GET)
    public Optional<Pokemon> readPokemon(@RequestParam(value = "id") Integer pokemonId){
        return pokemonService.readPokemon(pokemonId);
    }

    @RequestMapping(value = "readPokemonByName", method = RequestMethod.GET)
    public List<Pokemon> readPokemonName(@RequestParam(value = "name") String pokemonNombre){
        return pokemonService.readPokemonName(pokemonNombre);
    }

    @RequestMapping(value = "updatePokemon", method = RequestMethod.PUT)
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon) throws Exception {
        return pokemonService.updatePokemon(pokemon);
    }

    @RequestMapping(value = "deletePokemon", method = RequestMethod.DELETE)
    public Pokemon deletePokemon(@RequestBody Pokemon pokemon) throws Exception{
        return pokemonService.deletePokemon(pokemon);
    }
}
