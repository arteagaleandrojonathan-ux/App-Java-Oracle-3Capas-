package javaapplication2.MODEL;


public class EmpleadoEspecialidad {
    
    private String idEmpleadoEspecialidad;
    private String idEmpleado;
    private String idEspecialidad;
    private String estado;
    
    public EmpleadoEspecialidad(){
    }
    
    public EmpleadoEspecialidad(
            String idEmpleadoEspecialidad, 
            String idEmpleado, 
            String idEspecialidad, 
            String estado){
        this.idEmpleadoEspecialidad = idEmpleadoEspecialidad;
        this.idEmpleado = idEmpleado;
        this.idEspecialidad = idEspecialidad;
        this.estado = estado;
    }
    
    //GETTERS
    public String getIdEmpleadoEspecialidad()   {return idEmpleadoEspecialidad;}
    public String getIdEmpleado()               {return idEmpleado;}
    public String getIdEspecialidad()           {return idEspecialidad;}
    public String getEstado()                   {return estado;}
    
    //SETTERS
    public void setIdEmpleadoEspecialidad(String idEmpleadoEspecialidad)    {this.idEmpleadoEspecialidad = idEmpleadoEspecialidad;}
    public void setIdEmpleado(String idEmpleado)                              {this.idEmpleado = idEmpleado;}
    public void setIdEspecialidad(String idEspecialidad)                     {this.idEspecialidad = idEspecialidad;}
    public void setEstado (String estado)                                   {this.estado = estado;}

    public Object getIdEmpleadoespecialidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

