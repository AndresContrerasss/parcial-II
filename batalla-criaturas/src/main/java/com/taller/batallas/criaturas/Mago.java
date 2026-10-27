package com.taller.batallas.criaturas;

import com.taller.batallas.armas.Arma;
import com.taller.batallas.interfaces.Magico;

public class Mago extends Criatura implements Magico {

    private String hechizo;
    private Arma arma;

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
        this.hechizo = "Bola de energía";
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
        System.out.println(nombre + " usa magia y causa " + fuerza + " de daño.");
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

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza el hechizo: " + hechizo);
    }

    @Override
    public void aprenderHechizo(String hechizo) {
        this.hechizo = hechizo;
        System.out.println(nombre + " ha aprendido el hechizo: " + hechizo);
    }

    public String getHechizo() {
        return hechizo;
    }
}