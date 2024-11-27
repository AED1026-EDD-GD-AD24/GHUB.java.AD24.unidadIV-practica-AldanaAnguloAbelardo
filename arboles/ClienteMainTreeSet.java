package arboles;

import java.util.TreeSet;
import java.util.Iterator;

public class ClienteMainTreeSet {
    
    public static void main(String[] args) {
        
        TreeSet<Integer> t = new TreeSet<>();

        if (t.isEmpty())
            System.out.println("El arbol esta vacio.");
        
        // Añadir algunos elementos
        t.add(5);
        t.add(3);
        t.add(9);
        t.add(2);
        t.add(3);

        // Buscar un elemento
        System.out.println(t.contains(5));
        System.out.println(t.contains(12));
        System.out.println();

        // Eliminar elemento

        t.remove(5);
        System.out.println(t.contains(5));

        for (Iterator<Integer> it = t.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        TreeSet<Estudiante> t1 = new TreeSet<>();

        // Añadir unos elementos
        Estudiante e1 = new Estudiante(5, "Belisario");
        Estudiante e2 = new Estudiante(2, "Daniel");
        Estudiante e3 = new Estudiante(3, "Armida");
        Estudiante e4 = new Estudiante(4, "Felipe");
        t1.add(e1);
        t1.add(e2);
        t1.add(e3);
        t1.add(e4);

        System.out.println(t1.contains(new Estudiante(4, "Felipe")));
        System.out.println(t1.contains(new Estudiante(3, "Juana")));
        System.out.println();

        for (Iterator<Estudiante> it = t1.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }


}
