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

    public void Atacar(Combatiente oponente) { //añadi combatiente para identeificar a quien se le baja la vida
        oponente.reducirVida(this.poderAtaque);
    }

    public void reducirVida(int cantidad) { //cambie poderAtaque por cantidad para que sea más facil de identificar cuanto daño
        this.puntosVida -= cantidad;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
    }
}
