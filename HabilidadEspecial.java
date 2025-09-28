//modelo
public class HabilidadEspecial {
    private String tipo;
    private int poder;

    public HabilidadEspecial(String tipo, int poder) {
        this.tipo = tipo;
        this.poder = poder;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    //misma funcion que en item, aplica el efecto a uno mismo o a una persona 
    public void aplicarEfecto(Combatiente objetivo) {
        switch (tipo) {
            case "curar":
                objetivo.reducirVida(-poder); //cura restando el daño negativo
                break;
            case "quemar":
                objetivo.reducirVida(poder); // quemar al otro jugador
                break;
            default:
            //si no se reconoce el tipo no pasa nada
                break;
        }
    }
}
