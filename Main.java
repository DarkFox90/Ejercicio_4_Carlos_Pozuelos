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
            heroe.agregarItem(new Item("light armor", "aumentarDefensa", 2));
            heroe.agregarItem(new Item("guantelete", "aumentarAtaque", 2));
        }

        //creacion de villanos
        int cantidadEnemigos = rnd.nextInt(3) + 1;
        ArrayList<Villano> villanos = new ArrayList<>();

        for (int i = 1; i <= cantidadEnemigos; i++) {
            HabilidadEspecial hab = new HabilidadEspecial("fuego", 10 + rnd.nextInt(20)); //genera un numero aleatorio de poder para cada villano
            Villano v = new Villano("Villano" + i, 80 + rnd.nextInt(41), 10 + rnd.nextInt(6), 10, "lacayo", hab);
            Villano j = new Villano("Villano" + i, 150 + rnd.nextInt(41), 10 + rnd.nextInt(6), 10, "jefe", hab);
            villanos.add(v);
        }

        //creacion de menus para logica de juego
        MenuHeroe menuHeroe = new MenuHeroe();
        MenuVillano menuVillano = new MenuVillano();

        //iniciar la pelea
        System.out.println("\nEmpieza la batalla entre heroes y villanos");
        System.out.println(heroe.mostrarMensaje());
        for (Villano v : villanos) {
            System.out.println(v.mostrarMensaje());
        }

        //logica del combate
        while (heroe.getPuntosVida() > 0 && !villanos.isEmpty()) {
            System.out.println("\nestado de pelea");
            System.out.println(heroe.getNombre() + " HP: " + heroe.getPuntosVida());
            for(Villano v : villanos) {
                System.out.println(v.getNombre() + " HP: " + v.getPuntosVida());
            }

            //manejo de turnos 
            System.out.println("\nturno del heroe");
            System.out.println(menuHeroe.mostrarMenu());
            int opcionHeroe = sc.nextInt();

            if (opcionHeroe == 1 && !villanos.isEmpty()) {
                System.out.println("elige algun enemigo a atacar: ");
                for (int i = 0; i < villanos.size(); i++) {
                    System.out.println((i +1) + ". " + villanos.get(i).getNombre());
                }

                int indice = sc.nextInt() -1;
                if (indice >= 0 && indice < villanos.size()) {
                    menuHeroe.ejecutarOpcion(opcionHeroe, heroe, villanos.get(indice));
                } else {
                    menuHeroe.ejecutarOpcion(opcionHeroe, heroe, heroe);
                }
            }

            // limpiar area de pelea
            villanos.removeIf(v -> v.getPuntosVida() <= 0);
            if(villanos.isEmpty()) {
                System.out.println("Ganaron los heroes");
                break;
            }

            //turno de villanos
            for (Villano v : villanos) {
                if (heroe.getPuntosVida() <= 0) {
                    break;
                }
                System.out.println("\nturno de: " + v.getNombre() + ": ");
                System.out.println(menuVillano.mostrarMenu());
                int opcionVillano = sc.nextInt();
                menuVillano.ejecutarOpcion(opcionVillano, v, heroe);
            }

            if (heroe.getPuntosVida() <= 0) {
                System.out.println("perdieron los heroes");
                break;
            }
        }

        sc.close();
    }

}
