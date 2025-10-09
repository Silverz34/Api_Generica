package Proyecto;
import java.util.function.Predicate;
import java.lang.reflect.Array;

public class filtroReceta{

    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] original, Predicate<T> condicion){
        if(original== null || original.length == 0){ return original;}
        T[] filtre = (T[]) Array.newInstance(original.getClass().getComponentType(), original.length);
        int count = 0;
        for(T item: original){
            if(condicion.test(item)){
                filtre[count++] = item;
            }
        }
        if (count == 0) {return (T[]) Array.newInstance(original.getClass().getComponentType(), 0);}

        T[] result = (T[]) Array.newInstance(original.getClass().getComponentType(), count);
        System.arraycopy(filtre, 0, result, 0, count);

        return result;
    }


}
