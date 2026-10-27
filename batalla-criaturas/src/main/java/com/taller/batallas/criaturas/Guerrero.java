package com.taller.batallas.criaturas;

import com.taller.batallas.armas.Arma;

public class Guerrero extends Criatura {

    private String tipoArma;
    private Arma arma;

    public Guerrero(String nombre, int salud, int fuerza, String tipoArma) {
        super(nombre, salud, fuerza);
        this.tipoArma = tipoArma;
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " ha equipado el arma: " + arma.getNombre());
    }

    public void desequiparArma() {
        System.out.println(nombre + " ha desequipado su arma.");
        this.arma = null;
    }

    @Override
    public void atacar(Criatura objetivo) {
        System.out.println(nombre + " ataca con su " + tipoArma + " y causa " + fuerza + " de daño.");
        objetivo.defender(fuerza);

        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    @Override
    public void defender(int danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " recibe " + danio + " de daño. Salud restante: " + salud);
    }

    public String getTipoArma() {
        return tipoArma;
    }
}