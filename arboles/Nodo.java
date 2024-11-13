package arboles;

public class Nodo {

    private Object valor;
    private Nodo derecho;
    private Nodo izquierdo;

    public Nodo() {
        this.valor = null;
        this.derecho = null;
        this.izquierdo = null;
    }

    public Nodo (Object valor) {
    this.valor = valor;
    this.derecho = null;
    this.izquierdo = null;

    }

    public Object getValor() {
        return valor;
    }

    public void setValor (Object valor) {
        this.valor = valor;
    }

    public Nodo getDerecho() {
        return derecho;

    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
        public Nodo getIzquierdo() {
        return izquierdo;

    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }
    
}

