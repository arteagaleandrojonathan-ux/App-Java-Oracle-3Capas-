
package javaapplication2.CONFIG;

public class EmpleadoCombo {
    private String idEmpleado;
    private String nombre;
    private String apellido;

    public EmpleadoCombo(String idEmpleado, String nombre, String apellido) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido; // Esto es lo que se mostrará en el JComboBox
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
    
}