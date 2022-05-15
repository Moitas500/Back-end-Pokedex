package com.pokedex.pokedexBack.service;

import com.pokedex.pokedexBack.entity.Tipo;
import com.pokedex.pokedexBack.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Transactional
    public String createTipo(Tipo tipo){
        try {
            if (!tipoRepository.existsByNombre(tipo.getNombre())){
                tipo.setId(null == tipoRepository.findMaxId()? 0 : tipoRepository.findMaxId() + 1);
                tipoRepository.save(tipo);
                return "Tipo fue creado correctamente";
            } else {
                return "El tipo existe actualmente en la base de datos";
            }
        } catch (Exception e){
            throw e;
        }
    }

    public List<Tipo> readTipos(){ return tipoRepository.findAll(); }

    public Optional<Tipo> readTipo(Integer tipoId){
        return tipoRepository.findById(tipoId);
    }

    @Transactional
    public String updateTipo(Tipo tipo){
        if (tipoRepository.existsByNombre(tipo.getNombre())){
            try {
                List<Tipo> pokemons = tipoRepository.findByNombre(tipo.getNombre());
                pokemons.stream().forEach(t -> {
                    Tipo tipoQueSeActualiza = tipoRepository.findById(t.getId()).get();
                    tipoQueSeActualiza.setNombre(tipo.getNombre());
                });
                return "Tipo actualizado correctamente.";
            } catch (Exception e){
                throw e;
            }
        } else {
            return "Tipo no existe en la base datos";
        }
    }
}
