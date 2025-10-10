package Proyecto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class buscarRecetaTest {

    @Test
    void buscarRecetasPorTitulo_coincidenciaParcial_eIgnoraMayusculas() {
        Receta[] recetas = {
                new Receta(1, "Pasta Alfredo", 50, 10, 30, "comida", ""),
                new Receta(2, "Pastel de Chocolate", 70, 20, 60, "postre", ""),
                new Receta(3, "Hotcakes", 15, 2, 15, "desayuno", "")
        };

        Receta[] resultado = buscarReceta.buscarRecetas(recetas, "past", Receta::getNombreReceta);


        assertNotNull(resultado);
        assertEquals(2, resultado.length, "Debería encontrar 2 recetas que contienen 'past'");
        assertEquals("Pasta Alfredo", resultado[0].getNombreReceta());
        assertEquals("Pastel de Chocolate", resultado[1].getNombreReceta());
    }

    @Test
    void buscarRecetasPorTitulo_sinCoincidencias_devuelveArregloVacio() {
        Receta[] recetas = {
                new Receta(1, "Hotcakes", 15, 2, 15, "desayuno", "")
        };

        Receta[] resultado = buscarReceta.buscarRecetas(recetas, "pasta", Receta::getNombreReceta);

        assertNotNull(resultado);
        assertEquals(0, resultado.length, "Si no hay coincidencias debe devolver un arreglo vacío");
    }

    @Test
    void buscarRecetasPorTitulo_queryNull_devuelveArregloVacio() {
        Receta[] recetas = {
                new Receta(1, "Pasta Alfredo", 50, 10, 30, "comida", "")
        };

        Receta[] resultado = buscarReceta.buscarRecetas(recetas, null, Receta::getNombreReceta);

        assertNotNull(resultado);
        assertEquals(0, resultado.length, "Si el texto de búsqueda es null, devuelve vacío");
    }

    @Test
    void buscarRecetasPorTitulo_arregloVacio_devuelveArregloVacio() {
        Receta[] recetas = new Receta[0];

        Receta[] resultado = buscarReceta.buscarRecetas(recetas, "pasta", Receta::getNombreReceta);

        assertNotNull(resultado);
        assertEquals(0, resultado.length, "Con un arreglo vacío, el resultado también debe ser vacío");
    }
}
