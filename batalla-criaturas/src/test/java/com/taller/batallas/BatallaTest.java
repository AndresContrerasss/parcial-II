package com.taller.batallas;

import com.taller.batallas.armas.Arma;
import com.taller.batallas.criaturas.Criatura;
import com.taller.batallas.criaturas.Dragon;
import com.taller.batallas.criaturas.Guerrero;
import com.taller.batallas.criaturas.Mago;
import com.taller.batallas.interfaces.Magico;
import com.taller.batallas.interfaces.Volador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    // Prueba 9: simularBatalla termina y la criatura más fuerte queda viva
    @Test
    public void prueba09_simularBatallaTerminaConUnGanador() {
        Dragon dragon = new Dragon("Smaug", 100, 20, "Escamas rojas");
        dragon.equiparArma(new Arma("Garra de Acero", 6));
        Guerrero guerrero = new Guerrero("Conan", 30, 5, "espada");

        Main.simularBatalla(dragon, guerrero);

        assertTrue(dragon.estaViva());
        assertFalse(guerrero.estaViva());
        // El guerrero muere en el primer golpe, por eso no contraataca
        assertEquals(100, dragon.getSalud());
    }

    // Prueba 10: polimorfismo e interfaces (Volador / Magico)
    @Test
    public void prueba10_polimorfismoEInterfaces() {
        Criatura dragon = new Dragon("Smaug", 100, 20, "Escamas rojas");
        Criatura mago = new Mago("Merlin", 80, 18);
        Criatura guerrero = new Guerrero("Conan", 110, 15, "espada");

        assertTrue(dragon instanceof Volador);
        assertTrue(mago instanceof Magico);
        assertFalse(guerrero instanceof Volador);
        assertFalse(guerrero instanceof Magico);

        // Misma llamada atacar(), distinto comportamiento según el tipo real
        mago.atacar(guerrero);
        assertEquals(92, guerrero.getSalud()); // 110 - 18
    }
}
