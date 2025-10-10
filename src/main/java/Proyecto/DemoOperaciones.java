package Proyecto;

import java.util.Comparator;

public class DemoOperaciones {
    public static void main(String[] args) {
        // --- Crear recetas con constructor vacío + setters ---
        Receta r1 = new Receta();
        r1.setNombreReceta("Tacos");
        r1.setLikes(25);
        r1.setTiempoPreparacion(20);

        Receta r2 = new Receta();
        r2.setNombreReceta("Brownies");
        r2.setLikes(125);
        r2.setTiempoPreparacion(60);

        Receta r3 = new Receta();
        r3.setNombreReceta("Sopa");
        r3.setLikes(40);
        r3.setTiempoPreparacion(35);

        Receta[] recetas = { r1, r2, r3 };

        System.out.println("=== DEMO DE OPERACIONES ===\n");

        // 1) Agregar una receta
        Receta nueva = new Receta();
        nueva.setNombreReceta("Ensalada");
        nueva.setLikes(45);
        nueva.setTiempoPreparacion(15);

        recetas = agregarReceta.agregar(recetas, nueva);
        System.out.println("[Agregar] Se agregó: " + nueva.getNombreReceta());
        for (Receta r : recetas) System.out.println(" - " + r.getNombreReceta());

        // 2) Búsqueda por nombre (tercer parámetro: cómo convertir a texto)
        System.out.println("\n=== Búsqueda (contiene 'a') ===");
        Receta[] busqueda = buscarReceta.buscarRecetas(recetas, "a", Receta::getNombreReceta);
        for (Receta r : busqueda) System.out.println("Coincidencia: " + r.getNombreReceta());

        // 3) Filtro: tiempo de preparación < 50
        System.out.println("\n=== Filtro (tiempo < 50) ===");
        Receta[] filtradas = filtroReceta.filter(recetas, r -> r.getTiempoPreparacion() < 50);
        for (Receta r : filtradas)
            System.out.println(r.getNombreReceta() + " (" + r.getTiempoPreparacion() + " min)");

        // 4) Análisis: receta con más likes
        System.out.println("\n=== Receta más popular ===");
        Receta masPopular = AnalisisReceta.max(recetas, Comparator.comparingInt(Receta::getLikes));
        System.out.println("Más popular: " + masPopular.getNombreReceta() + " con " + masPopular.getLikes() + " likes");

        // 5) Estadísticas: promedio de likes
        System.out.println("\n=== Estadísticas ===");
        Integer[] likes = new Integer[recetas.length];
        for (int i = 0; i < recetas.length; i++) likes[i] = recetas[i].getLikes();
        double prom = EstadisticasReceta.promedio(likes);
        System.out.println("Promedio de likes: " + prom);
    }
}
