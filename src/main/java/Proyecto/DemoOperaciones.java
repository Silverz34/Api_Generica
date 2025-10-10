package Proyecto;

import java.util.Comparator;

public class DemoOperaciones {
    public static void main(String[] args) {
        // Crear recetas usando el constructor vacío + setters
        Receta r1 = new Receta();
        r1.setNombreReceta("Tacos");
        r1.setLikes(25);

        Receta r2 = new Receta();
        r2.setNombreReceta("Brownies");
        r2.setLikes(125);

        Receta r3 = new Receta();
        r3.setNombreReceta("Sopa");
        r3.setLikes(40);

        Receta[] recetas = { r1, r2, r3 };

        // Ejemplo 1: Receta más popular (más likes)
        Receta masPopular = AnalisisReceta.max(
                recetas,
                Comparator.comparingInt(Receta::getLikes)
        );
        System.out.println("Receta más popular: " + masPopular.getNombreReceta());

        // Ejemplo 2: Promedio de likes (extrae likes del arreglo de recetas)
        Integer[] likes = new Integer[recetas.length];
        for (int i = 0; i < recetas.length; i++) {
            likes[i] = recetas[i] != null ? recetas[i].getLikes() : 0;
        }
        double promedio = EstadisticasReceta.promedio(likes);
        System.out.println("Promedio de me gusta: " + promedio);
    }
}
