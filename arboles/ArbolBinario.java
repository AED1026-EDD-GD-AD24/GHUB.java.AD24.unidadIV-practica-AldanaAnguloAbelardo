package arboles;

public class ArbolBinario {

    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;

    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;

    }

    public Nodo getRaiz() {
        return raiz;

    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;

    }

    public void preorden() {
        preorden(raiz);
    }

    private void preorden(Nodo aux) {

        if (aux != null) {
        visitar(aux);
        preorden(aux.getIzquierdo());
        preorden(aux.getDerecho());

        }

    }

    public void inorden() {
        inorden(raiz);

    }

    private void inorden(Nodo aux) {

        if (aux != null) {
        inorden(aux.getIzquierdo());
        visitar(aux);
        inorden(aux.getDerecho());

        }

    }

    public void postorden() {
        postorden(raiz);

    }

    private void postorden(Nodo aux) {

        if (aux != null) {
        postorden(aux.getIzquierdo());
        postorden(aux.getDerecho());
        visitar(aux);

        }

    }

    public void visitar(Nodo aux) {

        System.out.print(aux.getValor() + " ");

    }
}
