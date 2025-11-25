package arbolbst_00000269541;

/**
 * Clase que implementa un Arbol Binario de Busqueda (BST) generico.
 * El tipo T debe implementar Comparable para permitir la ordenacion.
 */
public class ArbolBSTGenerico<T extends Comparable<T>> {
    private NodoGenerico<T> raiz;
    public ArbolBSTGenerico() {
        this.raiz = null;
    }
    
    /**
     * Inserta un nuevo valor en el arbol usando el metodo compareTo().
     * @param valor El valor generico a insertar.
     */
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoGenerico<T> insertarRecursivo(NodoGenerico<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoGenerico<>(valor);
        }
        int comparacion = valor.compareTo(nodo.getValor());

        if (comparacion < 0) { 
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } else if (comparacion > 0) { 
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        } else {
            System.out.println("Advertencia: No se insertó el valor duplicado.");
        }

        return nodo;
    }
    
    /**
     * Realiza un recorrido inorden (Izq-Raiz-Der) e imprime los valores.
     */
    public void inorden() {
        System.out.println("--- Recorrido Inorden de Estudiantes ---");
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(NodoGenerico<T> nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo()); 
            System.out.println(nodo.getValor()); 
            inordenRecursivo(nodo.getDerecho()); 
        }
    }
    
    public NodoGenerico<T> getRaiz() {
        return raiz;
    }
    
    /**
     * Encuentra el valor maximo en el arbol (el nodo mas a la derecha).
     * @return El valor T (Estudiante) con el valor mas alto.
     * @throws IllegalStateException si el arbol esta vacio.
     */
    public T encontrarMaximoGenerico() {
        if (raiz == null) {
            throw new IllegalStateException("El arbol esta vacio");
        }
        NodoGenerico<T> actual = raiz;
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho();
        }
        return actual.getValor();
    }
    
    /**
     * Recolecta todos los valores del arbol en una lista usando recorrido Inorden.
     * (Necesario para calcular promedio y rango en GestorEstudiantes).
     */
    public java.util.List<T> getAllValuesInorden() {
        java.util.List<T> lista = new java.util.ArrayList<>();
        collectInorden(raiz, lista);
        return lista;
    }

    private void collectInorden(NodoGenerico<T> nodo, java.util.List<T> lista) {
        if (nodo != null) {
            collectInorden(nodo.getIzquierdo(), lista);
            lista.add(nodo.getValor());
            collectInorden(nodo.getDerecho(), lista);
        }
    }
}