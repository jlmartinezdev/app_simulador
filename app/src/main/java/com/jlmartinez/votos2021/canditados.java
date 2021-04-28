package com.jlmartinez.votos2021;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class canditados {
    public String nombre;
    public String partido;
    public String partido_abv;
    public String lista;
    public int foto;

    public canditados(String nom, String par, String lista, String par_abv, int foto) {
        this.nombre= nom;
        this.partido= par;
        this.partido_abv= par_abv;
        this.lista= lista;
        this.foto= foto;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getPartido(){
        return this.partido;
    }
    public String  getLista(){
        return this.lista;
    }
    public int getFoto(){
        return this.foto;
    }
    public String getPartido_abv(){
        return this.partido_abv;
    }


}
