package com.taller.batallas;

import com.taller.batallas.armas.Arma;
import com.taller.batallas.criaturas.Guerrero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuerreroTest {

    // Prueba 3: sin arma, el ataque causa solo el valor de fuerza
    @Test
    public void prueba03_atacarSinArmaCausaSoloFuerza() {
        Guerrero atacante = new Guerrero("Conan", 100, 15, "espada");
        Guerrero objetivo = new Guerrero("Victima", 100, 5, "hacha");

        atacante.atacar(objetivo);

        assertEquals(85, objetivo.getSalud());
    }

    // Prueba 4: con arma equipada, el daño es fuerza + daño adicional del arma
    @Test
    public void prueba04_atacarConArmaSumaDanioAdicional() {
        Guerrero atacante = new Guerrero("Conan", 100, 15, "espada");
        Guerrero objetivo = new Guerrero("Victima", 100, 5, "hacha");
        atacante.equiparArma(new Arma("Espada Legendaria", 5));

        atacante.atacar(objetivo);

        assertEquals(80, objetivo.getSalud()); // 100 - (15 + 5)
    }

    // Prueba 5: al desequipar el arma se pierde el daño adicional
    @Test
    public void prueba05_desequiparArmaQuitaElBonus() {
        Guerrero atacante = new Guerrero("Conan", 100, 15, "espada");
        Guerrero objetivo = new Guerrero("Victima", 100, 5, "hacha");
        atacante.equiparArma(new Arma("Espada Legendaria", 5));
        atacante.desequiparArma();

        atacante.atacar(objetivo);

        assertEquals(85, objetivo.getSalud()); // solo fuerza
    }
}
