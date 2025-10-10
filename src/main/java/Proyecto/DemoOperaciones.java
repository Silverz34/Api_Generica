package Proyecto;
import java.util.Comparator;

public class DemoOperaciones {
    public static void main(String[] args) {
        Receta a=new Receta(); a.setNombreReceta("Tacos"); a.setLikes(25);
        Receta b=new Receta(); b.setNombreReceta("Brownies"); b.setLikes(125);
        Receta c=new Receta(); c.setNombreReceta("Sopa"); c.setLikes(40);
        Receta[] recetas = {a,b,c};

        Receta top = AnalisisReceta.max(recetas, Comparator.comparingInt(Receta::getLikes));
        System.out.println("Receta más popular: " + top.getNombreReceta());

        Integer[] likes = {25,125,40};
        System.out.println("Promedio de me gusta: " + EstadisticasReceta.promedio(likes));
    }
}
