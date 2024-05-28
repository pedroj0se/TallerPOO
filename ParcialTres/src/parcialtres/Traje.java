package parcialtres;

import java.util.ArrayList;

public class Traje {
    private ArrayList<Componente> piezas;
    private String nombre;

    // Constructor que inicializa una lista vacía de piezas
    public Traje(String nombre) {
        this.piezas = new ArrayList<>();
        this.nombre = nombre;
    }

    // Getters y setters

    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Componente> piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString

    @Override
    public String toString() {
        return "Traje{" +
                "piezas=" + piezas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
