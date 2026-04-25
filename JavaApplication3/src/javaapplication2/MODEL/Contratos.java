package javaapplication2.MODEL;

import java.sql.Date;


public class Contratos {
    private String idContrato;
    private String idEmpleado;
    private Date FechaInicio;
    private Date FechaFin;
    private String Rol;
    private String Estado; 
    
    public Contratos(){}    
    public Contratos (String idContrato, String idEmpleado,Date FechaInicio,Date FechaFin, String Rol, String Estado){
        this.idContrato = idContrato;
        this.idEmpleado = idEmpleado;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Rol = Rol;
        this.Estado = Estado;
    }
    
//ID CONTRATO
    public String getidContrato (){
        return idContrato;
    }
    public void setidContrato (String idContrato){
        this.idContrato = idContrato;
    }
       
   
// ID EMPLEADO
    public String getidEmpleado (){
        return idEmpleado;
    }
    public void setidEmpleado (String idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    
    
// FECHA DE INCIIO
    public Date getFechaInicio (){
        return FechaInicio;
    }
    public void setFechaInicio (Date FechaInicio){
        this.FechaInicio = FechaInicio;
    }
    
    
// FECHA FIN
    public Date getFechaFin (){
        return FechaFin;
    }
    public void setFechaFin (Date FechaFin){
        this.FechaFin = FechaFin;
    }

    
// ROL
    public String getRol (){
        return Rol;
    }
    public void setRol(String Rol){
        this.Rol = Rol;
    }
    
    
    
// ESTADO
    public String getEstado (){
        return Estado;
    }
    public void setEstado(String Estado){
        this.Estado = Estado;
    } 
    
    
}
