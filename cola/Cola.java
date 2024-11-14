package cola;

public class Cola<T> {

        private Nodo<T> cabeza;
        private Nodo<T> cola;
        private int tamanio;
    
        public Cola() {
            cabeza = null;
            cola = null;
            tamanio = 0;
        }
    
        public int getTamanio() {
            return tamanio;
        }
    
        public boolean esVacia() {
            return (cabeza == null);
        }
    
        public void encolar(T valor) {
            Nodo<T> nuevo = new Nodo<>();
    
            nuevo.setValor(valor);
    
            if (this.esVacia()) {
                // Cabeza y cola apuntan al mismo lugar
    
                cabeza = nuevo;
                cola = nuevo;
    
            } else {
                // Enlazar el campo siguiente con el nuevo
    
                cola.setSiguiente(nuevo);
                // La nueva cola pasa a ser nueva
                cola = nuevo;
    
            }
            tamanio++;
        }
    
        // Elimina el primer elemento de la cola
        public void desencolar() {
            // Si no es vacia
            if (!esVacia()) {
                // Verificar si hay un solo elemento
                if (cabeza == cola) {
                    cabeza = null;
                    cola = null;
                } else {
                    // Se elimina el primer elemento de la cola
                    // Desplazar la cabeza al siguiente nodo
                    cabeza = cabeza.getSiguiente();
                }
                tamanio--;
            }
        }
    
        public T frente() {
            if (!esVacia())
                return cabeza.getValor();
            else
                return null;
        }
    }