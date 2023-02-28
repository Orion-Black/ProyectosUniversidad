package Ordenamiento1;

import java.util.Comparator;

public class ComparadorNombreEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        //Primero comparanos el nombre
        if (persona1.getNombre().compareTo(persona2.getNombre())!=0)
            return persona1.getNombre().compareTo(persona2.getNombre());
        //Si los nombres son iguales entonces comparamos la edad
        if (persona1.getEdad() == persona2.getEdad()) return 0;
        else if (persona1.getEdad()> persona2.getEdad()) return 1;
        else return -1;
    }
}
