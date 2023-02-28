import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PruebaList {

    public static void main(String[] args) {
        //Agregar varios colores a la lista
        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Negro");
        lista1.add("Amarillo");
        lista1.add("Verde");
        lista1.add("Azul");
        lista1.add("Violeta");
        lista1.add("Plateado");

        //Agrega varios colores a lista2
        LinkedList<String> lista2 = new LinkedList<>();
        lista2.add("Dorado");
        lista2.add("Blanco");
        lista2.add("Cafe");
        lista2.add("Azul");
        lista2.add("Gris");
        lista2.add("Plateado");

        //Concatenar las dos listas
        lista1.addAll(lista2);
        //Libera los recursos de lista2
        lista2=null;

        imprimirLista(lista1);

        //Convierte cada elemento de la lista en mayusculas
        convertirCadenasAMayusculas(lista1);
        imprimirLista(lista1);

        System.out.printf("%nEliminando elementos 4 a 6...%n");
        eliminarElementos(lista1,4,7);
        imprimirLista(lista1);
        imprimirListaInversa(lista1);
    }

    private static void imprimirLista(LinkedList<String> lista){
        System.out.printf("%nLista:%n");
        for (String color:lista) {
            System.out.printf("%s ", color);
        }
        System.out.println();
    }

    //Localiza los objetos String y los convierte a mayusculas
    private static void convertirCadenasAMayusculas(LinkedList<String> lista){
        ListIterator<String> iterador = lista.listIterator();
        while (iterador.hasNext()){
            String color = iterador.next();
            iterador.set(color.toUpperCase());
        }
    }

    private static void eliminarElementos (LinkedList<String> lista, int inicio, int fin){
        lista.subList(inicio, fin).clear();
    }

    private static void imprimirListaInversa (List<String> lista){
        ListIterator<String> iterador = lista.listIterator(lista.size());
        System.out.printf("%nLista Inversa:%n");
        while (iterador.hasPrevious()){
            System.out.printf("%s ",iterador.previous());
        }
    }
}
