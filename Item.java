//modelo
public class Item {
    private String nombre;
    private String tipo;
    private int cantidad;

    public Item(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    //funcion que chequea que casos utilizar dependiendo del item usado
    public void usarItem(Combatiente objetivo) {
        switch (tipo) {
            case "curar":
                objetivo.reducirVida(-cantidad);
                break;
            case "aumentarAtaque":
                objetivo.aumentarAtaque(cantidad);
                break;
            case "aumetarDefensa":
                objetivo.aumentarDefensa(cantidad);
                break;
        }
    }
}
