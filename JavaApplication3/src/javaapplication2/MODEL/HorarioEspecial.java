
package javaapplication2.MODEL;

import java.sql.Date;
public class HorarioEspecial {
    private String idHorarioEspecial;
    private String idEmpleado;
    private String Tipo;
    private Date FechaInicio;
    private Date FechaFin;
    private int Estado;
    
    public HorarioEspecial(){}
    public HorarioEspecial(String idHorarioEspecial, String idEmpleado, String Tipo, Date FechaInicio, Date FechaFin, int Estado ){
        this.idHorarioEspecial = idHorarioEspecial;
        this.idEmpleado = idEmpleado;
        this.Tipo = Tipo;
        this.FechaInicio =FechaInicio;
        this.FechaFin = FechaFin;
        this.Estado = Estado;
    }
    
 //PARA ID HORARIO ESPECIAL  
    public String getidHorarioEspecial (){
        return idHorarioEspecial ;
    }
    public void setidHorarioEspecial (String idHorarioEspecial ){
        this.idHorarioEspecial  = idHorarioEspecial ;
    }
    
// PARA ID EMPLEADO
    public String getidEmpleado(){
        return idEmpleado;
    }
    public void setidEmpleado(String idEmpleado){
        this.idEmpleado = idEmpleado;
    }
      
// PARA TIPO DE HORARIO
    public String getTipo(){
        return Tipo;
    }
    public void setTipo(String Tipo){
        this.Tipo = Tipo;
    }    
    
// PARA FECHA DE INICIO
    public Date getFechaInicio(){
        return FechaInicio;
    }
    public void setFechaInicio(Date FechaInicio){
        this.FechaInicio = FechaInicio;
    } 
    
// PARA FECHA FIN
    public Date getFechaFin(){
        return FechaFin;
    }
    public void setFechaFin(Date FechaFin){
        this.FechaFin = FechaFin;
    }
// PARA EL ESTADO 
    public int getEstado(){
        return Estado;
    }
    public void setEstado(int Estado){
        this.Estado = Estado;
    }   
    
    
    
}
