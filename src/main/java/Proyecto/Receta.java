package Proyecto;

public class Receta implements Comparable<Receta> {
    private int idReceta;
    private String nombreReceta;
    private int likes;
    private int favoritos;
    private int tiempoPreparacion;
    private String tags;
    private String ingredientes;

    public Receta() {}
    public Receta(int idReceta, String nombreReceta, int likes, int favoritos, int tiempoPreparacion, String tags, String ingredientes) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.likes = likes;
        this.favoritos = favoritos;
        this.tags = tags;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = ingredientes;

    }

    public int getIdReceta() {return idReceta;}
    public void setIdReceta(int idReceta) {this.idReceta = idReceta;}
    public String getNombreReceta() {return nombreReceta;}
    public void setNombreReceta(String nombreReceta) {this.nombreReceta = nombreReceta;}
    public int getLikes() {return likes;}
    public void setLikes(int likes) {this.likes = likes;}
    public int getFavoritos() {return favoritos;}
    public void setFavoritos(int favoritos) {this.favoritos = favoritos;}
    public String getIngredientes() {return ingredientes;}
    public void setIngredientes(String ingredientes) {this.ingredientes = ingredientes;}
    public String getTags() {return tags;}
    public void setTags(String tags) {this.tags = tags;}
    public int getTiempoPreparacion() {return tiempoPreparacion;}
    public void setTiempoPreparacion(int tiempoPreparacion) {this.tiempoPreparacion = tiempoPreparacion;}

    @Override
    public int compareTo(Receta otraReceta) {
        return Integer.compare(otraReceta.likes, this.likes);
    }

    @Override
    public String toString() {
        return "R{" + idReceta + ", Name "+ nombreReceta + ", likes "+ likes + ", fav "
                + favoritos + ",tiempo "+ tiempoPreparacion + ", tag "+ tags + ", ingredientes" + ingredientes + "}";
    }
}
