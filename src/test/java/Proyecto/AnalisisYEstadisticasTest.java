package Proyecto;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

public class AnalisisYEstadisticasTest {

    private Receta receta(String nombre, int likes) {
        Receta r = new Receta();
        r.setNombreReceta(nombre);
        r.setLikes(likes);
        return r;
    }

    @Test
    void max_devuelveMasPopular_porLikes() {
        Receta[] recetas = {
                receta("Tacos", 25),
                receta("Brownies", 125),
                receta("Sopa", 40)
        };
        Receta top = AnalisisReceta.max(recetas, Comparator.comparingInt(Receta::getLikes));
        assertNotNull(top);
        assertEquals("Brownies", top.getNombreReceta());
        assertEquals(125, top.getLikes());
    }

    @Test
    void max_manejaNulos_yArregloVacio() {
        Receta[] recetas = { receta("A", 10), null, receta("B", 20) };
        Receta top = AnalisisReceta.max(recetas, Comparator.comparingInt(Receta::getLikes));
        assertEquals("B", top.getNombreReceta());

        Receta[] vacio = {};
        assertNull(AnalisisReceta.max(vacio, Comparator.comparingInt(Receta::getLikes)));
    }

    @Test
    void promedio_basico_yBordes() {
        Integer[] likes = { 25, null, 40, 125 }; // null se ignora
        double p = EstadisticasReceta.promedio(likes);
        // (25 + 40 + 125) / 3 = 63.333...
        assertTrue(p > 63.3 && p < 63.4);

        assertEquals(0.0, EstadisticasReceta.promedio(new Integer[0]));  // vacío
        assertEquals(0.0, EstadisticasReceta.promedio(new Integer[]{ null, null })); // solo nulos
    }
}
