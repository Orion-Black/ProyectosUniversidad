package Ordenamiento1.TareaColeccionLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

import java.util.LinkedList;
import java.util.Scanner;

public class PracticaLinkedList {
    static LinkedList<String> listaLenguajesDeProgramacion = new LinkedList<>();

    public static void main(String[] args) {
        int flag = 0;
        Scanner entrada = new Scanner(System.in);
        String lenguaje, lenguajeA, lenguajeB;
        System.out.println("Programa desarrollado por: Jesus Gonzalez Becerril");
        listaLenguajesDeProgramacion.add("C++");
        while (flag != 5) {
            menu();
            flag = entrada.nextInt();
            entrada.nextLine();
            switch (flag) {
                case 1:
                    System.out.println("-Añadir elemento uwu-");
                    System.out.print("Nombre del lenguaje: ");
                    lenguaje = entrada.nextLine();
                    listaLenguajesDeProgramacion.add(lenguaje);
                    System.out.println("Hecho...");
                    break;
                case 2:
                    System.out.println("-Añadir elemento al final uwu-");
                    System.out.print("Nombre del lenguaje: ");
                    lenguajeA = entrada.nextLine();
                    listaLenguajesDeProgramacion.addLast(lenguajeA);
                    System.out.println("Hecho...");
                    break;
                case 3:
                    System.out.println("-Añadir elemento al principio uwu-");
                    System.out.print("Nombre del lenguaje: ");
                    lenguajeB = entrada.nextLine();
                    listaLenguajesDeProgramacion.addFirst(lenguajeB);
                    System.out.println("Hecho...");
                    break;
                case 4:
                    System.out.println("-Mostrar lista de lenguajes uwu-");
                    mostrarLista(listaLenguajesDeProgramacion);
                    break;
                case 5:
                    System.out.println("Adios...");
                    System.exit(0);
                default:
                    System.out.println("Opcion Invalida... Reintente");
            }
        }
    }

    private static void menu() {
        System.out.println("________________________________");
        System.out.println("Lenguajes de programacion 2021");
        System.out.println("________________________________");
        System.out.println("1.-Añadir elemento");
        System.out.println("2.-Añadir elemento al final");
        System.out.println("3.-Añadir elemento al principio");
        System.out.println("4.-Mostrar lista de lenguajes");
        System.out.println("5.-Salir...");
        System.out.print("Ingresa la opcion deseada: ");
    }

    private static void mostrarLista(LinkedList<String> lista) {
        System.out.printf("%nLista de lenguajes de programacion: %n");
        for (String lenguaje : lista) {
            System.out.println("-" + lenguaje);
        }
    }
}