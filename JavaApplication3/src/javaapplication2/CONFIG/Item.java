package javaapplication2.CONFIG;

public class Item {
    private String id;
    private String nombre;

    public Item(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // El toString es lo que el ComboBox usará para mostrar el texto
    @Override
    public String toString() {
        return nombre;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
