package arbolbst_00000269541;

/**
 * Clase que implementa un Arbol Binario de Busqueda (BST)
 * para valores enteros.
 */
public class ArbolBST {
    private Nodo raiz;

    /**
     * Constructor que inicializa un arbol vacio.
     * La raiz es null.
     */
    public ArbolBST() {
        this.raiz = null;
    }
    
    public Nodo getRaiz () {
        return raiz;
    }
    
    /**
     * Inserta un nuevo valor en el arbol.
     * Utiliza un método auxiliar recursivo.
     * @param valor El valor a insertar.
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo auxiliar para insertar.
     * @param nodo El nodo actual (la raíz del subárbol actual).
     * @param valor El valor a insertar.
     * @return El nodo actualizado (la nueva raíz del subárbol, que podría ser el nuevo nodo).
     */
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } 
        else if (valor > nodo.getValor()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        } 
        else {
            System.out.println("Advertencia: No se insertó el valor " + valor + ". Los duplicados no están permitidos en este BST.");
        }
        return nodo;
    }
    
/**
     * Busca un valor en el arbol.
     * @param valor El valor a buscar.
     * @return true si el valor existe, false en caso contrario.
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo auxiliar para buscar.
     * @param nodo El nodo actual (la raíz del subárbol actual).
     * @param valor El valor a buscar.
     * @return true si se encuentra, false en caso contrario.
     */
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        
        if (valor == nodo.getValor()) {
            return true;
        }
        
        if (valor < nodo.getValor()) {
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } 
        else { 
            return buscarRecursivo(nodo.getDerecho(), valor);
        }
    }
    
    /**
     * Elimina un valor del arbol.
     * Utiliza un método auxiliar recursivo.
     * @param valor El valor a eliminar.
     */
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo auxiliar para eliminar.
     * @param nodo El nodo actual (la raíz del subárbol).
     * @param valor El valor a eliminar.
     * @return El nodo actualizado (la nueva raíz del subárbol).
     */
    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), valor));
        } 
        else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } 
            else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo(); 
            }
            int sucesorValor = encontrarMinimoValor(nodo.getDerecho());
            nodo.setValor(sucesorValor);
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesorValor));
        }

        return nodo;
    }
    
    /**
     * Encuentra el valor minimo en un subarbol.
     * Se mueve repetidamente al hijo izquierdo.
     * @param nodo La raiz del subarbol.
     * @return El valor minimo.
     */
    private int encontrarMinimoValor(Nodo nodo) {
        // Si no hay hijo izquierdo, este es el nodo más a la izquierda, por lo tanto el mínimo
        if (nodo.getIzquierdo() == null) {
            return nodo.getValor();
        } 
        else {
            return encontrarMinimoValor(nodo.getIzquierdo());
        }
    }

    /**
     * Realiza un recorrido inorden (Izq-Raiz-Der).
     * Imprime los valores en orden ascendente.
     */
    public void inorden() {
        System.out.print("Recorrido Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo auxiliar para inorden.
     * @param nodo El nodo actual.
     */
    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo()); 
            System.out.print(nodo.getValor() + " "); 
            inordenRecursivo(nodo.getDerecho()); 
        }
    }

    /**
     * Realiza un recorrido preorden (Raiz-Izq-Der).
     * Util para copiar el arbol.
     */
    public void preorden() {
        System.out.print("Recorrido Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo auxiliar para preorden.
     * @param nodo El nodo actual.
     */
    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + " "); 
            preordenRecursivo(nodo.getIzquierdo()); 
            preordenRecursivo(nodo.getDerecho()); 
        }
    }

    /**
     * Realiza un recorrido postorden (Izq-Der-Raiz).
     * Util para eliminar el arbol.
     */
    public void postorden() {
        System.out.print("Recorrido Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo auxiliar para postorden.
     * @param nodo El nodo actual.
     */
    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.getIzquierdo()); 
            postordenRecursivo(nodo.getDerecho()); 
            System.out.print(nodo.getValor() + " "); 
        }
    }

    /**
     * Calcula la altura del arbol.
     * @return La altura del arbol (-1 si esta vacio, 0 si solo tiene raiz).
     */
    public int altura() {
        return alturaRecursiva(raiz);
    }

    /**
     * Metodo recursivo para calcular altura.
     * @param nodo El nodo actual.
     * @return La altura del subarbol.
     */
    private int alturaRecursiva(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzq = alturaRecursiva(nodo.getIzquierdo());
        int alturaDer = alturaRecursiva(nodo.getDerecho());
        return Math.max(alturaIzq, alturaDer) + 1;
    }

    /**
     * Cuenta el numero total de nodos en el arbol.
     * @return El numero de nodos.
     */
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    /**
     * Metodo recursivo para contar nodos.
     * @param nodo El nodo actual.
     * @return El numero de nodos en el subarbol.
     */
    private int contarNodosRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosRecursivo(nodo.getIzquierdo()) + contarNodosRecursivo(nodo.getDerecho());
    }

    /**
     * Encuentra el valor minimo en el arbol.
     * @return El valor minimo.
     * @throws IllegalStateException si el arbol esta vacio.
     */
    public int encontrarMinimo() {
        if (raiz == null) {
            throw new IllegalStateException("El arbol esta vacio");
        }

        Nodo actual = raiz;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }

        return actual.getValor();
    }

    /**
     * Encuentra el valor maximo en el arbol.
     * @return El valor maximo.
     * @throws IllegalStateException si el arbol esta vacio.
     */
    public int encontrarMaximo() {
        if (raiz == null) {
            throw new IllegalStateException("El arbol esta vacio");
        }

        Nodo actual = raiz;
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho();
        }

        return actual.getValor();
    }

    /**
     * Verifica si el arbol esta vacio.
     * @return true si el arbol esta vacio, false en caso contrario.
     */
    public boolean esVacio() {
        return raiz == null;
    }  
}