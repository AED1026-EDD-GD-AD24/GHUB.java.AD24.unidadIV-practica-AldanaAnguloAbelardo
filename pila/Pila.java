package pila;

public class Pila<T> {
    // Atributo cabeza que apunta al tope de la pila
    private Nodo<T> cabeza;

    // Almacena el total de elementos de la pila
    private int tamanio;
    
    // Metodos
    public Pila () {
        cabeza = null;
        tamanio = 0;
    }

    // Metodo que devuelva el total de elementos de la pila
    public int getTamanio () {
        return tamanio;
    }

    // Verificar si la pila es vacia
    public boolean esVacia () {
        return (cabeza == null);
    }

    // Apilar un elemento nuevo
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void apilar (T valor) {
        // Crear un nuevo nodo
        Nodo<T> nuevo = new Nodo<>(valor);
        // Fijar valor dentro del nodo
        nuevo.setValor(valor);
        if (this.esVacia()) {
            cabeza = nuevo;
        } else {
            // Se enlaza el campo siguiente de "nuevo" con la cabeza
            nuevo.setSiguiente(cabeza);
            // La nueva cabeza de la pila pasa a ser el "nuevo"
            cabeza = nuevo;
        }
        // Incrementamos el tamaño de la pila
        tamanio++;
    }


    // Elimina un elemento del tope de la pila

    public void retirar () {
        if(!esVacia()) {
            cabeza = cabeza.getSiguiente();
            tamanio --;
        }
    }

    public T cima () {
        if (!esVacia()) {
            return cabeza.getValor();
        } else {
            return null;
        }
    }

    public boolean buscar(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(valor)) { 
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

}