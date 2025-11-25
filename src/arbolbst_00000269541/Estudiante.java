package arbolbst_00000269541;

/**
 * Representa a un estudiante con nombre y nota.
 * Implementa Comparable para permitir la ordenacion en el BST basada
 * en la nota (calificacion).
 */
public class Estudiante implements Comparable<Estudiante> {
    
    private String nombre;
    private int nota;

    /**
     * Constructor para la clase Estudiante.
     * Incluye una validacion simple para asegurar que la nota este en el rango [0, 100].
     * @param nombre Nombre del estudiante.
     * @param nota Nota obtenida por el estudiante.
     */
    public Estudiante(String nombre, int nota) {
        this.nombre = nombre;
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100.");
        }
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Define el criterio de ordenamiento del BST.
     * Compara dos objetos Estudiante basandose UNICAMENTE en la 'nota'.
     * @param otro El otro objeto Estudiante con el que comparar.
     * @return Un valor negativo, cero, o positivo si esta nota es menor,
     * igual o mayor que la nota del otro objeto.
     */
    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.nota, otro.nota);
    }
    
    /**
     * Retorna la representacion de cadena del Estudiante en el formato solicitado.
     * Formato: "nombre: nota"
     */
    @Override
    public String toString() {
        return nombre + ": " + nota;
    }
}