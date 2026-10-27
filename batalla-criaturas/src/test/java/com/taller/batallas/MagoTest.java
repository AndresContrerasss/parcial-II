package com.taller.batallas;

import com.taller.batallas.criaturas.Mago;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagoTest {

    // Prueba 6: el mago nace con un hechizo por defecto y puede aprender otro
    @Test
    public void prueba06_magoAprendeHechizo() {
        Mago mago = new Mago("Merlin", 80, 18);
        assertEquals("Bola de energía", mago.getHechizo());

        mago.aprenderHechizo("Tormenta Arcana");

        assertEquals("Tormenta Arcana", mago.getHechizo());
    }
}
