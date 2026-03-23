public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // 1. Método para insertar números en el árbol
    public void insertar(int valor) {
        raiz = insertarNodo(raiz, valor);
    }

    private NodoArbol insertarNodo(NodoArbol raiz, int valor) {
        if (raiz == null) {
            raiz = new NodoArbol(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.nodoIzq = insertarNodo(raiz.nodoIzq, valor); // Menores a la izquierda
        } else if (valor > raiz.valor) {
            raiz.nodoDer = insertarNodo(raiz.nodoDer, valor); // Mayores a la derecha
        }

        return raiz;
    }

    public void inorden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        inordenRecursivo(raiz);
        System.out.println(); // Salto de línea al final
    }

    private void inordenRecursivo(NodoArbol raiz) {
        if (raiz != null) {
            inordenRecursivo(raiz.nodoIzq);       // Visitar subárbol izquierdo
            System.out.print(raiz.valor + " ");     // Visitar nodo raíz
            inordenRecursivo(raiz.nodoDer);         // Visitar subárbol derecho
        }
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NodoArbol raiz, int valor) {
        // Caso base: la raíz es nula o la llave está en la raíz
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }

        // Si el valor es mayor que la raíz, buscamos en el subárbol derecho
        if (raiz.valor < valor) {
            return buscarRecursivo(raiz.nodoDer, valor);
        }

        // Si el valor es menor, buscamos en el subárbol izquierdo
        return buscarRecursivo(raiz.nodoIzq, valor);
    }
}
