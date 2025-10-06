package Proyecto;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Predicate;

public class RecetaProcesoTest {
    private Receta[] setupData(){
        return new Receta[]{
                new Receta(101,"pollo asado", 5, 50, 60, "comida", "pollo, verduras, sal"),
                new Receta(102, "Boneless BBQ", 15, 120, 30, "Snack", "pollo,BBQ"),
                new Receta(103, "papas a la fracesa", 2, 10, 30, "Snack", "papas, sal,huevo,harina,aceite"),
                new Receta(104, "helado de napolitano",  8, 80, 120, "Postre","leche,vainilla, chocolate"),
        };
    }

    private final RecetaProceso<Receta> proceso = new RecetaProceso<>();
    @Test
    void testSorting(){
        Receta[] recipes = setupData();
        Receta[] sorted = proceso.sort(recipes);

        System.out.println("--- ORDEN REAL DEL ARREGLO ---");
        System.out.println(java.util.Arrays.toString(sorted));
        System.out.println("-----------------------------");

        for(int i = 0; i < sorted.length - 1; i++){
            Receta actual = sorted[i];
            Receta siguiente = sorted[i + 1];
            assertTrue(actual.getFavoritos() >= siguiente.getFavoritos());
        }
        assertEquals(120, sorted[0].getFavoritos(), "El mayor favorito debe estar al inicio.");
        assertEquals(10, sorted[sorted.length - 1].getFavoritos(), "El menor favorito debe estar al final.");
    }

    @Test
    void testSortingEmpty() {
        Receta[] empty = {};
        Receta[] sorted = proceso.sort(empty);
        assertNotNull(sorted, "El arreglo ordenado no debe ser nulo.");
        assertEquals(0, sorted.length, "El arreglo ordenado debe ser vacío.");
    }

    //filtrado x time
    @Test
    void testFilterTime(){
        Receta[] recipes = setupData();
        Predicate<Receta> isQuick = r -> r.getTiempoPreparacion() <= 30;
        Receta[] filtred = filtroReceta.filter(recipes, isQuick);
        assertEquals(2,filtred.length,"estas recetas son rapidas");
    }

    @Test
    void testFilterTag(){
        Receta[] recipes = setupData();
        Predicate<Receta> isSnack = r -> r.getTags().contains("Snack");
        Receta[] filtred  = filtroReceta.filter(recipes, isSnack);
        assertEquals(2,filtred.length,"estas recetas son snacks");
    }
}
