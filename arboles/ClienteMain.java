package arboles;

public class ClienteMain {

    public static void main(String[] args) {
        
        // Crear un arbol binario vacio
        ArbolBinario ab = new ArbolBinario();

        // Insertar algunos nodos a nuestro arbol
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Nodo nodoE = new Nodo("E");
        Nodo nodoF = new Nodo("F");
        Nodo nodoG = new Nodo("G");

        ab.setRaiz(nodoA);
        ab.getRaiz().setIzquierdo(nodoB);
        ab.getRaiz().setDerecho(nodoC);
        nodoB.setIzquierdo(nodoD);
        nodoB.setDerecho(nodoE);
        nodoC.setIzquierdo(nodoF);
        nodoC.setDerecho(nodoG);

        // Recursivo
        System.out.println("Recorrido en preorden recursivo");
        ab.preorden();
        System.out.println("\n Recorrido en inorden recursivo");
        ab.inorden();
        System.out.println("\n Recorrido en postorden recursivo");
        ab.postorden();
        System.out.println();

        // Iterativo
        System.out.println("Recorrido en preorden iterativo");
        ab.preordenIteratvio();
        System.out.println("\n Recorrido en inorden iterativo");
        ab.inordenIterativo();
        System.out.println("\n Recorrido en postorden iterativo");
        ab.postordenIterativo();
        System.out.println();
        
    }
}
