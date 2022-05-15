package com.pokedex.pokedexBack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {

    @Id
    private int id;
    private String nombre;
    private double altura;
    private double peso;
    private String urlImg;

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

    public String geturlImg() {
        return urlImg;
    }

    public void seturlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", urlImg=" + urlImg +
                '}';
    }
}
