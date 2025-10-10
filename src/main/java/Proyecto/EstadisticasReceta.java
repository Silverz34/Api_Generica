package Proyecto;

/**
 * Clase que implementa operaciones de análisis numérico genéricas.
 * Demuestra el uso de <T extends Number>.
 */
public final class EstadisticasReceta {

    private EstadisticasReceta() {}

    /**
     * Calcula el promedio de un arreglo de valores numéricos.
     * @param <T> Tipo numérico (Integer, Double, etc.)
     * @param valores Arreglo de valores numéricos.
     * @return El promedio como double, o 0.0 si el arreglo es nulo o vacío.
     */
    public static <T extends Number> double promedio(T[] valores) {
        if (valores == null || valores.length == 0) return 0.0;

        double suma = 0.0;
        int count = 0;

        for (T v : valores) {
            if (v == null) continue;
            suma += v.doubleValue();
            count++;
        }

        return count == 0 ? 0.0 : (suma / count);
    }
}
