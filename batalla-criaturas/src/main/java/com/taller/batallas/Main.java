package com.taller.batallas;

import com.taller.batallas.armas.Arma;
import com.taller.batallas.criaturas.Criatura;
import com.taller.batallas.criaturas.Dragon;
import com.taller.batallas.criaturas.Guerrero;
import com.taller.batallas.criaturas.Mago;

public class Main {

    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n===== INICIO DE LA BATALLA =====");
        System.out.println(criatura1.getNombre() + " VS " + criatura2.getNombre());
        System.out.println();

        int turno = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("----- TURNO " + turno + " -----");

            criatura1.atacar(criatura2);

            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
            }

            System.out.println("Estado actual:");
            System.out.println(criatura1.getNombre() + " -> Salud: " + criatura1.getSalud());
            System.out.println(criatura2.getNombre() + " -> Salud: " + criatura2.getSalud());
            System.out.println();

            turno++;
        }

        System.out.println("===== FIN DE LA BATALLA =====");
        if (criatura1.estaViva()) {
            System.out.println("Ganador: " + criatura1.getNombre());
        } else {
            System.out.println("Ganador: " + criatura2.getNombre());
        }
    }

    public static void main(String[] args) {
        // Crear armas
        Arma espadaLegendaria = new Arma("Espada Legendaria", 5);
        Arma bastonMagico = new Arma("Bastón Mágico", 4);
        Arma garraDeAcero = new Arma("Garra de Acero", 6);

        // Crear criaturas
        Dragon dragon = new Dragon("Smaug", 100, 20, "Escamas rojas");
        Mago mago = new Mago("Merlin", 80, 18);
        Guerrero guerrero = new Guerrero("Conan", 110, 15, "espada");

        // Usar habilidades
        dragon.volar();
        dragon.aterrizar();

        mago.aprenderHechizo("Tormenta Arcana");
        mago.lanzarHechizo();

        // Equipar armas
        dragon.equiparArma(garraDeAcero);
        mago.equiparArma(bastonMagico);
        guerrero.equiparArma(espadaLegendaria);

        // Simulación de batalla
        simularBatalla(dragon, guerrero);

        // También podrías probar:
        // simularBatalla(mago, dragon);
        // simularBatalla(mago, guerrero);
    }
}
