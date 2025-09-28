//modelo
public class MenuHeroe extends Menu {
    
    //cambié el valor de retorno a string para mostrarlo en main
    @Override
    public String mostrarMenu() {
        return "1. Atacar\n2. Usar Item\n3. Pasar turno";
    }

    //cambie el valor de retorno a int para poder utilizarlo en main
    @Override
    public int mostrarOpcion(int opcion) {
        return opcion;
    }

    @Override
    public void ejecutarOpcion(int opcion, Combatiente heroe, Combatiente objetivo) {
        Heroe h = (Heroe) heroe;

        switch (opcion) {
            case 1: //atacar
                h.atacar(objetivo);
                break;
            case 2: //usar item
                if(!h.getItems().isEmpty()) {
                    Item item = h.getItems().get(0);
                    h.usarItem(item, h);
                }
                break;
            case 3: //pasa el turno
                h.usarTurno();
                break;
            default:
                //no hace nada
                break;  
        }
    }
}
