package com.pokedex.pokedexBack.repository;

import com.pokedex.pokedexBack.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    public boolean existsByNombre(String nombre);

    public List<Pokemon> findByNombre(String nombre);

    public List<Pokemon> findByNombreStartsWith(String nombre);

    @Query("select max(p.id) from Pokemon p")
    public Integer findMaxId();
}
