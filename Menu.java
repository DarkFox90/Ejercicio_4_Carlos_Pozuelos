//vista

//cambié la clase a abstracta para que funcione como molde y no funcional por si sola
public abstract class Menu {
    //no utilicé scanner por que no estoy seguro si se puede utilizar scanner en clases que no son main

    //devuelve el menú en string para pasarlo en main
    public abstract String mostrarMenu();

    //devuelve la opcion seleccionada para no usar scanner y en main se pasa el valor
    public abstract int mostrarOpcion(int opcion);

    //ejecuta las acciones
    public abstract void ejecutarOpcion(int opcion, Combatiente actual, Combatiente objetivo);

}
