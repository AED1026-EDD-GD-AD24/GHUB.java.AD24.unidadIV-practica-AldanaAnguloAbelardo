package arboles;

public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    public ArbolBinarioBusqueda(Nodo raiz) {
        super(raiz);
    }

    // Inserta un nodo en el arbol binario
    public void insertar(Object valor) throws Exception {

        Comparable dato = (Comparable) valor;

        Nodo nuevo = new Nodo();
        nuevo.setValor(dato);

        if (raiz == null)
            raiz = nuevo;
        else {

            // anterior: Este nodo anterior es una referencia al padre de AUX
            Nodo anterior = null;

            // Aux = auxiliar que va recorriendo los nodos, desde la raiz
            Nodo aux = raiz;

            while (aux != null) {
                anterior = aux;
                if (dato.esMenor(aux.getValor()))
                    aux = aux.getIzquierdo();
                else if (dato.esMayor(aux.getValor()))
                    aux = aux.getDerecho();
                else
                    throw new Exception("Dato duplicado.");
            }

            if (dato.esMenor(anterior.getValor()))
                anterior.setIzquierdo(nuevo);
            else
                anterior.setDerecho(nuevo);
        }

    }

    /*
     * Insertar interfaz de la operacion, llama al metodo insertarRecursivo que
     * realiza la operacio
     * y de vuelve la raiz del nuevo arbol. A este metodo interno se le pasa la raiz
     * actual, a partir de la cual
     * se describe el camino de busquda, y al final se enlaza
     */

    public void insertar2(Object valor) throws Exception {

        Comparable dato = (Comparable) valor;
        raiz = insertarRec(raiz, dato);

    }

    private Nodo insertarRec(Nodo raizSub, Comparable dato) throws Exception {
        if (raizSub == null) {

            // Caso base, termina la recursividad
            raizSub = new Nodo(dato);
        } else {
            if (dato.esMenor(raizSub.getValor())) {

                Nodo iz = insertarRec(raizSub.getIzquierdo(), dato);
                raizSub.setIzquierdo(iz);

            } else if (dato.esMayor(raizSub.getValor())) {

                Nodo dr = insertarRec(raizSub.getDerecho(), dato);
                raizSub.setDerecho(dr);

            } else {
                throw new Exception("Dato esta duplicado.");
            }
        }

        return raizSub;
    }

    /*
     * 
     *  @param, valor a buscar
     *  @return el nodo encontrado
     */

    public Nodo buscar(Object valor) {
        Comparable dato = (Comparable) valor;

        if (raiz == null)
            return raiz;
        else {
            // Aux es un auxiliar que va recorriendo el arbol desde la raiz
            Nodo aux = raiz;
            while (aux != null) {
                if (dato.esIgual(aux.getValor()))
                    return aux;
                else if (dato.esMenor(aux.getValor()))
                    aux = aux.getIzquierdo();
                else
                    aux = aux.getDerecho();
            }
        }
        return null;
    }

    /*
     * 
     * Interfaz de buscar que invoca al metodo recursivo localizar
     *  @param buscado, el valor buscado
     *  @return Nodo buscado o null si no lo encuentra
     */
    public Nodo buscar2 (Object buscado) {
        Comparable dato = (Comparable) buscado;

        if (raiz == null)
            return null;
        else
            return localizar(raiz, dato);
    }


    /*
     *  Version recursiva
     *  @param raizSUb
     *  @param buscado
     *  @return Nodo buscado si lo encuentra, si no returna null
     */
    
    private Nodo localizar (Nodo raizSub, Comparable buscado) {

        if (raizSub == null)
            return null;
        else if (buscado.esIgual(raizSub.getValor())) {
            return raizSub;
        } else if (buscado.esMenor(raizSub.getValor()))
            return localizar(raizSub.getIzquierdo(), buscado);
        else 
            return localizar(raizSub.getDerecho(), buscado);

    }
}