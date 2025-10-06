package Proyecto;

public class Receta implements Comparable<Receta> {
    private int idReceta;
    private String nombreReceta;
    private int likes;
    private int favoritos;


    public Receta(int idReceta, String nombreReceta, int likes, int favoritos) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.likes = likes;
        this.favoritos = favoritos;
    }
    public int getFavoritos() {return favoritos;}
    public void setFavoritos(int favoritos) {this.favoritos = favoritos;}
    public int setLikes() {return this.likes;}
    public int getLikes() {return likes;}
    public String getNombreReceta() {return nombreReceta;}
    public void setNombreReceta(String nombreReceta) {this.nombreReceta = nombreReceta;}
    public int getIdReceta() {return idReceta;}
    public void setIdReceta(int idReceta) {this.idReceta = idReceta;}

    public int compareTo(Receta otraReceta) {
        return Integer.compare(otraReceta.favoritos, this.favoritos);
    }

    @Override
    public String toString() {
        return "R{" + idReceta + ", Name "+ nombreReceta + ", likes "+ likes + ", fav " + favoritos + '}';
    }
}
