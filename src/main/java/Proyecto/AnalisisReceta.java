package Proyecto;

import java.util.Comparator;
import java.util.Objects;

/**
 * Clase que analiza un arreglo genérico para encontrar el elemento máximo.
 * Demuestra el uso de <T extends Comparable<T>> y Comparator<? super T>.
 */
public final class AnalisisReceta {

    private AnalisisReceta() {}

    /**
     * Método genérico que obtiene el máximo valor según el orden natural de los elementos.
     * @param <T> Tipo genérico que implementa Comparable.
     * @param array Arreglo de elementos a analizar.
     * @return El elemento máximo o null si el arreglo está vacío o es nulo.
     */
    public static <T extends Comparable<T>> T max(T[] array) {
        if (array == null || array.length == 0) return null;

        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            T actual = array[i];
            if (actual == null) continue;
            if (max == null || actual.compareTo(max) > 0) {
                max = actual;
            }
        }
        return max;
    }

    /**
     * Versión con Comparator: permite definir el criterio de comparación manualmente.
     * Ideal para comparar recetas por número de "likes".
     * @param <T> Tipo de elemento del arreglo.
     * @param array Arreglo a analizar.
     * @param comparator Criterio de comparación.
     * @return El elemento máximo o null si el arreglo está vacío o es nulo.
     */
    public static <T> T max(T[] array, Comparator<? super T> comparator) {
        if (array == null || array.length == 0) return null;
        Objects.requireNonNull(comparator, "El comparador no puede ser nulo.");

        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            T actual = array[i];
            if (actual == null) continue;
            if (max == null || comparator.compare(actual, max) > 0) {
                max = actual;
            }
        }
        return max;
    }
}
