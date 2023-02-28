package Ordenamiento1;

import java.util.Comparator;

public class ComparadorEdadNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        if (persona1.getEdad() > persona2.getEdad()) return 1;
        else if (persona1.getEdad() < persona2.getEdad()) return -1;
        else return persona1.getNombre().compareTo(persona2.getNombre());
    }
}

