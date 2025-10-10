package Proyecto;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;


public class buscarReceta {
    public static <T> T[] buscarRecetas(T[] original, String query, Function<T, String> toText) {
        if (original == null || original.length == 0 || query == null || toText == null) {

            return original == null
                    ? (T[]) new Object[0]
                    : (T[]) Array.newInstance(original.getClass().getComponentType(), 0);
        }

        String q = query.toLowerCase();

        // contamos cuantos coinciden
        int count = 0;
        for (T e : original) {
            if (e != null) {
                String txt = toText.apply(e);
                if (txt != null && txt.toLowerCase().contains(q)) {
                    count++;
                }
            }
        }

        // copiamos arreglo y le agregamos uno
        @SuppressWarnings("unchecked")
        T[] resultado = (T[]) Array.newInstance(original.getClass().getComponentType(), count);

        int i = 0;
        for (T e : original) {
            if (e != null) {
                String txt = toText.apply(e);
                if (txt != null && txt.toLowerCase().contains(q)) {
                    resultado[i++] = e;
                }
            }
        }
        return resultado;
    }
}

