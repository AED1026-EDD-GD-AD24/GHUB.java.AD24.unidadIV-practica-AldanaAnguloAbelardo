package arboles;

public class ClienteMainArbolesBinariosOrdenados {
    

    public static void main(String[] args) {
        
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        
        try {
        // Agrego unos elementos al arbol
        arbol.inserta(new Entero(10));
        arbol.inserta(new Entero(15));
        arbol.inserta(new Entero(30));
        arbol.inserta(new Entero(5));
        arbol.inserta(new Entero(2));
        arbol.inserta(new Entero(1));
        arbol.inserta(new Entero(15));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Recorridos

        System.out.println("\n Recorrido PreOrden");
        arbol.preorden();
        System.out.println("\n Recorrido InOrden");
        arbol.inorden();
        System.out.println("\n Recorrido PostOrden");
        arbol.postorden();
        System.out.println("\n Recorrido por Niveles");
        arbol.recorridoPorNiveles();
        System.out.println();
        System.out.println("\n Recorrido Jerarquico");
        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        // Busquedas

        Nodo aux = arbol.buscar(new Entero(30));
        if (aux == null)
            System.out.println("Elemento no encontrado.");
        else
            System.out.println("Elemento encontrado.");
            aux = arbol.buscar(new Entero(35));
            if (aux == null)
            System.out.println("Elemento no encontrado.");
        else
            System.out.println("Elemento encontrado.");

        // Eliminar

        arbol.eliminar(new Entero(1));
        System.out.println("\n Recorrido Jerarquico");
        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        arbol.eliminar(new Entero(15));
        System.out.println("\n Recorrido Jerarquico");
        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        arbol.eliminar(new Entero(10));
        System.out.println("\n Recorrido Jerarquico");
        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();
    }


}
