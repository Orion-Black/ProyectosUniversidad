package Ordenamiento1;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        return persona1.getNombre().compareTo(persona2.getNombre());
    }
}
