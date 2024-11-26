package arboles;

public class ArbolBinarioBusqueda extends ArbolBinario{
    public ArbolBinarioBusqueda(){
        super();

    }
    public ArbolBinarioBusqueda(Nodo raiz){
        super(raiz);

    }
    /**
     * Inserta un nodo en el arbol binario
     * @param valor
     */
    public void inserta(Object valor) throws Exception{
        Comparable dato = (Comparable)valor;
        Nodo nuevo = new Nodo();
        nuevo.setValor(dato);
        if(raiz == null)
           raiz = nuevo;
        else{
            // anterior: refenencia al padre de aux
            Nodo anterior = null;
            //aux: auxiliar que va recorriendo los nodos, desde la raiz
            Nodo aux  = raiz;
            while (aux != null){
                anterior = aux;
                if (dato.esMenor(aux.getValor()))
                  aux = aux.getIzquierdo();
                else if (dato.esMayor(aux.getValor()))
                   aux = aux.getDerecho();
                else
                  throw new Exception("Dato Duplicado");
            }
            if(dato.esMenor(anterior.getValor()))
               anterior.setIzquierdo(nuevo);
            else
               anterior.setDerecho(nuevo);
        }
    }
    /**
     * insertar 2 es la interfaz de la operacion, llama al metodo
     * insertarRecursivo que realiza la operacion y devuelve la raiz del nuevo 
     * arbol. A este metodo interno se le pasa la raiz actual, a partir
     * de la cual se describe el camino de busqueda, y al final se enlaza
     * 
     */
    public void insertar2(Object valor) throws Exception{
        Comparable dato = (Comparable) valor;
        raiz = insertarRec(raiz,dato);
    }

    private Nodo insertarRec(Nodo raizSub, Comparable dato) throws Exception{
        if (raizSub == null){
            //caso base, termina la recursividad
            raizSub = new Nodo(dato);
        }
        else{
            if (dato.esMenor(raizSub.getValor())){
                Nodo iz = insertarRec(raizSub.getIzquierdo(), dato);
                raizSub.setIzquierdo(iz);
            }
            else{
                if (dato.esMayor(raizSub.getValor())){
                    Nodo dr = insertarRec(raizSub.getDerecho(), dato);
                    raizSub.setDerecho(dr);
                }
                else{
                    throw new Exception("Dato Duplicado");
                }
            }
        }
        return raizSub;

    }

    /**
     * 
     * @param valor, valor a buscar
     * @return el nodo encontrado
     */
    public Nodo buscar(Object valor){
        Comparable dato = (Comparable)valor;
        if (raiz == null)
           return raiz;
        else{
            //aux: auxiliar que va recorriendo los nodos, de la la raiz
            Nodo aux = raiz;
            while (aux !=null){
                if (dato.esIgual(aux.getValor()))
                   return aux;
                if (dato.esMenor(aux.getValor()))
                   aux = aux.getIzquierdo();
                else 
                   aux = aux.getDerecho();
                   
            }
            return null;
        }
    }

    /**
     * Interfaz de buscar que invoca al metodo recuersivo localizar
     * @param buscado, valor buscado
     * @return Nodo buscado o null si no lo encuentra
     */
    public Nodo buscar2(Object buscado){
        Comparable dato = (Comparable)buscado;
        if (raiz == null)
          return null;
        else
           return localizar(raiz,dato);
    }

    /**
     * Version recursiva
     * @param raizSub
     * @param buscado
     * @return Nodo buscado si lo encuentra, si no retorna null
     */

    private Nodo localizar(Nodo raizSub, Comparable buscado){
        if (raizSub == null)
           return null;
        else if (buscado.esIgual(raizSub.getValor()))
            return raizSub;
        else if (buscado.esMenor(raizSub.getValor()))
            return localizar(raizSub.getIzquierdo(), buscado);
        else 
            return localizar(raizSub.getDerecho(), buscado);

    }
    public boolean eliminar(Object valor){
        Comparable dato = (Comparable)valor;
        //Buscar el nodo a eliminar y su antecesor
        Nodo antecesor = null; //antecesor del nodo a eliminar
        //aux: auxiliar que va recorriendo los nodos, desde la raiz
        Nodo aux = raiz;
        while (aux !=null){
            if (dato.esIgual(aux.getValor())){
                break;
            }
            antecesor = aux;
            if (dato.esMenor(aux.getValor()))
                aux = aux.getIzquierdo();
            else 
                aux = aux.getDerecho();
            

        }
        if (aux == null){
            return false;
        }
        //si llega a este punto, el nodo a eliminar existe y es aux y su antecesor es antecesor
        //Exainar cada caso
        //1. si tiene menos de dos hijos, incluso una hoja
        if (aux.getIzquierdo() == null) //solo tiene hijo derecho
            if(((Comparable) aux.getValor()).esMenor(antecesor.getValor()))
                antecesor.setIzquierdo(aux.getDerecho());
               
            else
                antecesor.setDerecho(aux.getDerecho());
        else if (aux.getDerecho()==null)//solo tiene hijo izquierdo
            if(((Comparable) aux.getValor()).esMenor(antecesor.getValor()))
                 antecesor.setIzquierdo(aux.getIzquierdo());
            else
                 antecesor.setDerecho(aux.getIzquierdo());
        else 
            //El nodo a eliminar tiene rama izquierda y rama derecha
            reemplazarPorMayorIzquierdo(aux);
        aux =null;
        return true;


    }
    /**
     * Reemplaza el nodo actual por el mayor del la rama izquierda
     * 
     * @param act nodo Actual o nodo a eliminar que tiene rama izquierda y rama derecha
     */
    
    public void reemplazarPorMayorIzquierdo(Nodo act) {

        Nodo mayor = act;
        Nodo ant = act;

        mayor = act.getIzquierdo();
        // Buscar el mayor de la rama izquierda
        // Ant siempre va a ser el antecesor de mayor

        while (mayor.getDerecho() != null) {
            ant = mayor;
            mayor = mayor.getDerecho();

        }

        act.setValor(mayor.getValor()); // Reemplazo
        // Reajuste

        if (ant == act)
            ant.setIzquierdo(mayor.getIzquierdo());
        else
            ant.setDerecho(mayor.getIzquierdo());
    }


    
}