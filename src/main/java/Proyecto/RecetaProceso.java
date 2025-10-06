package Proyecto;
import java.util.Arrays;

public class RecetaProceso<T extends Comparable<T>>{

    public T[] sort(T[] array){
        if(array == null || array.length == 0){
            return array;
        }
        Arrays.sort(array);
        return array;
    }


}
