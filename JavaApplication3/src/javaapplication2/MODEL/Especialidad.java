
package javaapplication2.MODEL;

public class Especialidad {
    
    private String idEspecialidad;
    private String nombre;
    private String estado;
    
    public Especialidad(){
    }
    
    public Especialidad(
            String idEspecialidad, 
            String nombre, 
            String estado){
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    //GETTERS
    public String getIdEspecialidad()   {return idEspecialidad;}
    public String getNombre()           {return nombre;}
    public String getEstado()           {return estado;}
    
    //SETTERS
    public void setIdEspecialidad(String idEspecialidad)    {this.idEspecialidad = idEspecialidad;}
    public void setNombre(String nombre)                    {this.nombre = nombre;}
    public void setEstado(String estado)                    {this.estado = estado;}
}

