package Proyecto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AgregarRecetaTest {

    @Test
    void agregar_enArregloNull_creaArregloCon1Receta() {
        Receta[] recetas = null;
        Receta nueva = new Receta(1, "Hotcakes", 10, 3, 15, "desayuno", "harina,huevo,leche");

        Receta[] out = agregarReceta.agregar(recetas, nueva);

        assertNotNull(out);
        assertEquals(1, out.length);
        assertEquals("Hotcakes", out[0].getNombreReceta());
        assertEquals(15, out[0].getTiempoPreparacion());
    }

    @Test
    void agregar_recetaNull_retornaOriginalSinCambios() {
        Receta[] recetas = new Receta[0];

        Receta[] out =agregarReceta.agregar(recetas, null);

        assertSame(recetas, out);
        assertEquals(0, out.length);
    }

    @Test
    void agregar_variasRecetas_seAgreganAlFinal() {
        Receta[] recetas = new Receta[0];

        recetas = agregarReceta.agregar(recetas,
                new Receta(1, "A", 5, 0, 10, "desayuno", "x"));
        recetas = agregarReceta.agregar(recetas,
                new Receta(2, "B", 8, 0, 20, "comida", "y"));
        recetas = agregarReceta.agregar(recetas,
                new Receta(3, "C", 12, 1, 30, "cena", "z"));

        assertEquals(3, recetas.length);
        assertEquals("A", recetas[0].getNombreReceta());
        assertEquals("B", recetas[1].getNombreReceta());
        assertEquals("C", recetas[2].getNombreReceta());

        System.out.println(Arrays.toString(recetas));
    }

}
