package Proyecto;
import java.util.Arrays;

public class agregarReceta {
    public static <T> T[] agregar(T[] original, T elemento) {
        if (elemento == null) return original; //Si la receta viene vacia no agregamos nadota
        if (original == null) { //si no hay arreglo pues hacemos uno nuevo
            T[] nuevo = (T[]) java.lang.reflect.Array.newInstance(elemento.getClass(), 1);
            nuevo[0] = elemento;
            return nuevo;
        }
        T[] copia = Arrays.copyOf(original, original.length + 1);
        copia[original.length] = elemento;
        return copia;
    }
}


