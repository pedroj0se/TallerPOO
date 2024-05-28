
package parcialtres;

public class Blusa extends Componente {
    private boolean mangaLarga;

    public Blusa(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    // Getters y setters

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    // Método toString

    @Override
    public String toString() {
        return "Blusa{" +
                "Manga Larga=" + mangaLarga +
                "} " + super.toString();
    }
}
