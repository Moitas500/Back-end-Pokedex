package com.pokedex.pokedexBack.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pokemon {

    @Id
    private int id;
    private String nombre;
    private double altura;
    private double peso;
    private String urlImg;

    @ManyToMany()
    @JoinTable(
            name = "tipo_id",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_id")
    )
    private Set<Tipo> tipo;

    public Pokemon() {
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Set<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(Set<Tipo> tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", urlImg='" + urlImg + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
