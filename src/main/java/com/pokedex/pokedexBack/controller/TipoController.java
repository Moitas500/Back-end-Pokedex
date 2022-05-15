package com.pokedex.pokedexBack.controller;

import com.pokedex.pokedexBack.entity.Pokemon;
import com.pokedex.pokedexBack.entity.Tipo;
import com.pokedex.pokedexBack.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TipoController {
    @Autowired
    private TipoService tipoService;

    @RequestMapping(value = "tipo", method = RequestMethod.GET)
    public List<Tipo> readTipos(){
        return tipoService.readTipos();
    }

    @RequestMapping(value = "tipoId", method = RequestMethod.GET)
    public Optional<Tipo> readTipoId(@RequestParam(value = "id") Integer tipoId){
        return tipoService.readTipo(tipoId);
    }

    @RequestMapping(value = "createTipo", method = RequestMethod.POST)
    public String createTipo(@RequestBody Tipo tipo){
        return tipoService.createTipo(tipo);
    }

    @RequestMapping(value = "updateTipo", method = RequestMethod.PUT)
    public String updateTipo(@RequestBody Tipo tipo){
        return tipoService.updateTipo(tipo);
    }

}
