//modelo
public class Villano extends Combatiente {
    private String rol;
    private HabilidadEspecial habilidadE;

    public Villano(String nombre, int puntosVida, int poderAtaque, int defensa, String rol, HabilidadEspecial habilidadE) {
        super(nombre, puntosVida, poderAtaque, defensa); //super de la clase combatiente
        this.rol = rol;
        this.habilidadE = habilidadE;
    }

    public HabilidadEspecial getHabilidadE() {
        return habilidadE;
    }

    public void usarHabilidadE(Combatiente objetivo) {
        habilidadE.aplicarEfecto(objetivo); //aplica el efecto de la habilidad al objetivo
    }

    public String usarTurno() {
        return "El villano " + getNombre() + " usó su turno.";
    }

    //muestra el mensaje si perdió y cuando entra a batalla
    @Override
    public String mostrarMensaje() {
        if (getPuntosVida() <= 0) {
            return "El villano " + getNombre() + " ha sido derrotado.";
        } else {
            return "El villano " + getNombre() + " entra en batalla con " 
                   + getPuntosVida() + " HP, " + getDefensa() + " DEF y su habilidad especial: " 
                   + habilidadE.getTipo() + ".";
        }
    }
}


