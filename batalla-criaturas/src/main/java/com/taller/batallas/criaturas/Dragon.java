package com.taller.batallas.criaturas;

import com.taller.batallas.armas.Arma;
import com.taller.batallas.interfaces.Volador;

public class Dragon extends Criatura implements Volador {

    private String escamas;
    private Arma arma;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
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
        int danio = fuerza * 2;
        System.out.println(nombre + " ataca con fuego y causa " + danio + " de daño.");
        objetivo.defender(danio);

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

    @Override
    public void volar() {
        System.out.println(nombre + " está volando por el cielo.");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " ha aterrizado.");
    }

    public String getEscamas() {
        return escamas;
    }
}