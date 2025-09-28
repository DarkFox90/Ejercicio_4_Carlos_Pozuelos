//controlador

/*
 * Universidad del Valle de Guatemala
 * Programacion Orientada a Objetos
 * Ejercicio 4: juego RPG de herencia
 * fecha de creación: 28 de septiembre de 2025
 * ultima modificación: 28 de septiembre de 2025
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        //aqui se crean los heroes a utilizar
        System.out.println("elige el rol que deseas: ");
        System.out.println("1. Guerrero (mas vida y ataque)");
        System.out.println("2. explorador (menos vida y mas items)");
        int opcionDeRol = sc.nextInt();

        ArrayList<Item> inventario = new ArrayList<>();
        Heroe heroe;

        if(opcionDeRol == 1) {
            heroe = new Heroe("jugador1", 100, 50, 15, "Guerrero", inventario);
            heroe.agregarItem(new Item("mini", "curacion", 15));
        } else {
            heroe = new Heroe("jugador2", 90, 20, 5, "explorador", inventario);
            heroe.agregarItem(new Item("mini", "curacion", 30));
            heroe.agregarItem(new Item("mini", "curacion", 30));
        }
    }

}
