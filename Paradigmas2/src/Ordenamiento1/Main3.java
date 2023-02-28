package Ordenamiento1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main3 {
    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Pedro", "Picapiedra", 40));
        listaPersonas.add(new Persona("Pablo", "Mármol", 30));
        listaPersonas.add(new Persona("Vilma", "De Picapiedra", 35));
        listaPersonas.add(new Persona("Betty", "Mármol", 25));
        listaPersonas.add(new Persona("Tony", "Stark", 56));
        listaPersonas.add(new Persona("Bella", "Stark", 56));
        listaPersonas.add(new Persona("Bella", "Stark", 12));
        // imprime los elementos del objeto list
        System.out.println("Elementos desordenados: ");
        listaPersonas.forEach(System.out::println);
        System.out.println();
        // Ordenamos por edad
        Collections.sort(listaPersonas, new ComparadorEdad());
        System.out.println("Elementos de la lista ordenados por edad:");
        listaPersonas.forEach(System.out::println);
        System.out.println();
        // Ordenamos por nombre
        Collections.sort(listaPersonas, new ComparadorNombre());
        System.out.println("Elementos de la lista ordenados por nombre:");
        listaPersonas.forEach(System.out::println);
        System.out.println();
        // Ordenamos por edad y nombre
        Collections.sort(listaPersonas, new ComparadorEdadNombre());
        System.out.println("Elementos de la lista ordenados por edad y nombre:");
        listaPersonas.forEach(System.out::println);
        System.out.println();
        // Ordenamos por nombre y edad
        Collections.sort(listaPersonas, new ComparadorNombreEdad());
        System.out.println("Elementos de la lista ordenados por nombre y edad:");
        listaPersonas.forEach(System.out::println);
        System.out.println();
    }
}
