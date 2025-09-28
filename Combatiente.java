//modelo
public class Combatiente {
    public String nombre;
    public int puntosVida;
    public int poderAtaque;

    public Combatiente(String nombre, int puntosVida, int poderAtaque) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.poderAtaque = poderAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void Atacar(Combatiente oponente) {
        oponente.reducirVida(this.poderAtaque);
    }

    public void reducirVida(int cantidad) {
        this.puntosVida -= cantidad;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
    }
}
