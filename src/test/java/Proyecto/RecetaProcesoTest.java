package Proyecto;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Predicate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class RecetaProcesoTest {
    private Receta[] setupDataFromJson(){
        String filePath= "src/test/resources/recetas-test-data.json";
        ObjectMapper mapper= new ObjectMapper();
       try{
           return mapper.readValue(new File(filePath), Receta[].class);
       }catch(IOException e){
           e.printStackTrace();
           return new Receta[0];
       }
    }

    private final RecetaProceso<Receta> proceso = new RecetaProceso<>();
    @Test
    void testSorting(){
        Receta[] recipes = setupDataFromJson();
        Receta[] sorted = proceso.sort(recipes);

        System.out.println(java.util.Arrays.toString(sorted));
        assertEquals(15, sorted[0].getLikes());
        for(int i= 0; i < sorted.length-1; i++){
            assertTrue(sorted[i].getLikes() >= sorted[i+1].getLikes(), "El orden de los likes es incorrecto");
        }
    }

    //filtrado x time
    @Test
    void testFilterTime(){
        Receta[] recipes = setupDataFromJson();
        Predicate<Receta> isQuick = r -> r.getTiempoPreparacion() <= 30;
        Receta[] filtred = filtroReceta.filter(recipes, isQuick);
        System.out.println(java.util.Arrays.toString(filtred));
        assertEquals(3,filtred.length,"estas recetas son rapidas");
    }

    //filtrado por tipo de tag
    @Test
    void testFilterTag(){
        Receta[] recipes = setupDataFromJson();
        Predicate<Receta> isSnack = r -> r.getTags().contains("Snack");
        Receta[] filtred  = filtroReceta.filter(recipes, isSnack);
        System.out.println(java.util.Arrays.toString(filtred));
        assertEquals(2,filtred.length,"estas recetas son snacks");
    }
}
