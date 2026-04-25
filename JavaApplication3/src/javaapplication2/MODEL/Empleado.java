package javaapplication2.MODEL;

public class Empleado {
    private String idEmpleado;
    private String tipoDOI;
    private String numDOI;
    private String apePaterno;
    private String apeMaterno;
    private String nombres;
    private String email;
    private String telefono;
    private String telefonoEmergencia;
    private int estado;
    
    public Empleado() {
    }
    
    public Empleado(
            String idEmpleado, 
            String tipoDOI, 
            String numDOI, 
            String apePaterno, 
            String apeMaterno, 
            String nombres, 
            String email, 
            String telefono, 
            String telefonoEmergencia, 
            int estado){
        this.idEmpleado = idEmpleado;
        this.tipoDOI = tipoDOI;
        this.numDOI = numDOI;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombres = nombres;
        this.email = email;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
        this.estado = estado;
    }
    
    /*GETTERS*/
    public String getIdEmpleado()           {return idEmpleado;}    
    public String getTipoDOI()              {return tipoDOI;}   
    public String getNumDOI()               {return numDOI;}
    public String getApePaterno()           {return apePaterno;}  
    public String getApeMaterno()           {return apeMaterno;}   
    public String getNombres()              {return nombres;}   
    public String getEmail()                {return email;}
    public String getTelefono()             {return telefono;}    
    public String getTelefonoEmergencia()   {return telefonoEmergencia;}    
    public int getEstado()                  {return estado;}
    
    /*SETTERS*/
    public void setIdEmpleado(String idEmpleado)                    {this.idEmpleado = idEmpleado;}   
    public void setTipoDOI(String tipoDOI)                          {this.tipoDOI = tipoDOI;}
    public void setNumDOI(String numDOI)                            {this.numDOI = numDOI;}
    public void setApePaterno(String apePaterno)                    {this.apePaterno = apePaterno;}
    public void setApeMaterno(String apeMaterno)                    {this.apeMaterno = apeMaterno;}
    public void setNombres(String nombres)                          {this.nombres = nombres;}
    public void setEmail(String email)                              {this.email = email;}
    public void setTelefono(String telefono)                        {this.telefono = telefono;}
    public void setTelefonoEmergencia(String telefonoEmergencia)    {this.telefonoEmergencia = telefonoEmergencia;}
    public void setEstado(int estado)                               {this.estado = estado;}
}
