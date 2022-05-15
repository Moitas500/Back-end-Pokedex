package com.pokedex.pokedexBack.repository;

import com.pokedex.pokedexBack.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
    public boolean existsByNombre(String Nombre);
    public List<Tipo> findByNombre(String Nombre);

    @Query("select max(p.id) from Tipo p")
    public Integer findMaxId();
}
