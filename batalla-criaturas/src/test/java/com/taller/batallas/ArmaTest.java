package com.taller.batallas;

import com.taller.batallas.armas.Arma;
import com.taller.batallas.criaturas.Guerrero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmaTest {

    // Prueba 1: el constructor guarda correctamente nombre y daño adicional
    @Test
    public void prueba01_armaGuardaNombreYDanio() {
        Arma arma = new Arma("Espada Legendaria", 5);

        assertEquals("Espada Legendaria", arma.getNombre());
        assertEquals(5, arma.getDanioAdicional());
    }

    // Prueba 2: atacarConArma resta al objetivo exactamente el daño adicional
    @Test
    public void prueba02_atacarConArmaReduceSaludDelObjetivo() {
        Arma arma = new Arma("Garra de Acero", 6);
        Guerrero objetivo = new Guerrero("Objetivo", 50, 10, "espada");

        arma.atacarConArma(objetivo);

        assertEquals(44, objetivo.getSalud());
    }
}
