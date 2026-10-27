package com.taller.batallas;

import com.taller.batallas.criaturas.Guerrero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CriaturaTest {

    @Test
    public void pruebaEstaViva() {
        Guerrero guerrero = new Guerrero("Prueba", 50, 10, "espada");
        assertTrue(guerrero.estaViva());
    }

    @Test
    public void pruebaDefenderReduceSalud() {
        Guerrero guerrero = new Guerrero("Prueba", 50, 10, "espada");
        guerrero.defender(20);
        assertEquals(30, guerrero.getSalud());
    }

    @Test
    public void pruebaCriaturaMuere() {
        Guerrero guerrero = new Guerrero("Prueba", 30, 10, "espada");
        guerrero.defender(40);
        assertFalse(guerrero.estaViva());
    }
}