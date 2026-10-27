package com.taller.batallas;

import com.taller.batallas.criaturas.Dragon;
import com.taller.batallas.criaturas.Guerrero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DragonTest {

    // Prueba 7: el dragón ataca con el doble de su fuerza
    @Test
    public void prueba07_dragonCausaDobleDeFuerza() {
        Dragon dragon = new Dragon("Smaug", 100, 20, "Escamas rojas");
        Guerrero objetivo = new Guerrero("Victima", 100, 5, "espada");

        dragon.atacar(objetivo);

        assertEquals(60, objetivo.getSalud()); // 100 - (20 * 2)
    }

    // Prueba 8: la salud nunca baja de 0, aunque el daño sea mayor
    @Test
    public void prueba08_saludNuncaEsNegativa() {
        Dragon dragon = new Dragon("Smaug", 30, 20, "Escamas rojas");

        dragon.defender(500);

        assertEquals(0, dragon.getSalud());
        assertFalse(dragon.estaViva());
    }
}
