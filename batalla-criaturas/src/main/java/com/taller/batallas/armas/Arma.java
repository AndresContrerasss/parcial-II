package com.taller.batallas.armas;

import com.taller.batallas.criaturas.Criatura;

public class Arma{

    private String nombre;
    private int danioAdicional;

    public Arma(String nombre, int danioAdicional) {
        this.nombre = nombre;
        this.danioAdicional = danioAdicional;
    }

    public void atacarConArma(Criatura objetivo) {
        System.out.println("El arma " + nombre + " causa " + danioAdicional + " puntos de daño adicional.");
        objetivo.defender(danioAdicional);
    }

    public int getDanioAdicional() {
        return danioAdicional;
    }

    public String getNombre() {
        return nombre;
    }
}