//modelo
public class Combatiente {
    public String nombre;
    public int puntosVida;
    public int poderAtaque;
    public int defensa;

    public Combatiente(String nombre, int puntosVida, int poderAtaque, int defensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.poderAtaque = poderAtaque;
        this.defensa = defensa;
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

    public int getDefensa() {
        return defensa;
    }

    public void atacar(Combatiente oponente) { //añadi combatiente para identeificar a quien se le baja la vida
        oponente.reducirVida(this.poderAtaque);
    }

    public void reducirVida(int cantidad) { //cambie poderAtaque por cantidad para que sea más facil de identificar cuanto daño
        int dañoTotal = cantidad - this.defensa;
        if (dañoTotal < 0) {
            dañoTotal = 0; //evita que haya daño negativo
        }

        //se le resta a la vida el daño total hecho
        this.puntosVida -= dañoTotal;

        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
    }

    //añadí esta funcion para que despliegue un mensaje cuando va a empezar la pelea
    public String mostrarMensaje() {
        return nombre + " va a luchar con " + puntosVida + " HP y " + defensa + " DEF ";
    }

    //añadí metodos helpers para poder aumentar el ataque y defensa del personaje
    public void aumentarAtaque(int cantidad) {
        this.poderAtaque += cantidad;
    }

    public void aumentarDefensa(int cantidad) {
        this.defensa += cantidad;
    }
}
