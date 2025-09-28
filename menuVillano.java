//modelo
public class MenuVillano extends Menu {
    
    //cambié el valor de retorno a string para mostrarlo en main
    @Override
    public String mostrarMenu() {
        return "1. Atacar\n2. Usar Habilidad Especial\n3. Pasar turno";
    }

    //cambie el valor de retorno a int para poder utilizarlo en main
    @Override   
    public int mostrarOpcion(int opcion) { 
        return opcion; //el valor lo genera main
    }

    @Override
    public void ejecutarOpcion(int opcion, Combatiente villano, Combatiente objetivo) {
        Villano v = (Villano) villano;
        switch (opcion) {
            case 1: //atacar
                v.atacar(objetivo);
                break;
            case 2: //usar habilidad
                v.usarHabilidadE(objetivo);
                break;
            case 3: //pasar turno
                v.usarTurno();
                break;
            default:
                //no hace nada
                break;
        }
    }
}
