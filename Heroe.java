//modelo

import java.util.ArrayList;
public class Heroe extends Combatiente {
    private String rol;
    private ArrayList<Item> inventario;

    public Heroe(String nombre, int puntosVida, int poderAtaque, int defensa, String rol, ArrayList<Item> inventario) {
        super(nombre, puntosVida, poderAtaque, defensa); //super para llamar al constructor padre
        this.rol = rol;
        this.inventario = new ArrayList<>();
    }

    public String getRol() {
        return rol;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    //añadi la fucion para que la mochila del heroe no estuviera vacía
    //añade un item al inventario
    public void agregarItem(Item item) {
        inventario.add(item);
    }

    //funcion que permite usar el item en uno mismo o en un oponente
    public void usarItem(Item item, Combatiente objetivo) {
        inventario.usar(objetivo);
        inventario.remove(item); //elimina el item al usarlo del inventario
    }

    public String usarTurno() {
        return "el heroe " + getNombre() + " acaba de realizar su turno";
    }

    @Override
    public String mostrarMensaje() {
        return "el heroe " + getNombre() + " rol: " + rol + " va a batallar con " + getPuntosVida() + " HP y " + getDefensa() + " DEF ";
    }
}
