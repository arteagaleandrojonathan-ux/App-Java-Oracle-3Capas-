package javaapplication2.MODEL;

import java.sql.Time;

public class Horarios {
    private String idHorario;
    private String idEmpleado;
    private String DiaSemana;
    private Time HoraInicio;
    private Time HoraFin;
    /** ACTIVO | INACTIVO | ANULADO (CHECK en Oracle) */
    private String estado;

    public Horarios() {
    }

    public Horarios(String idHorario, String idEmpleado, String DiaSemana, Time HoraInicio, Time HoraFin) {
        this.idHorario = idHorario;
        this.idEmpleado = idEmpleado;
        this.DiaSemana = DiaSemana;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
    }
    
 //PARA ID HORARIO   
    public String getidHorario(){
        return idHorario;
    }
    public void setidHorario(String idHorario){
        this.idHorario = idHorario;
    }
    
// PARA ID EMPLEADO
    public String getidEmpleado(){
        return idEmpleado;
    }
    public void setidEmpleado(String idEmpleado){
        this.idEmpleado = idEmpleado;
    }
      
// PARA DIA DE LA SEMANA
    public String getDiaSemana(){
        return DiaSemana;
    }
    public void setDiaSemana(String DiaSemana){
        this.DiaSemana = DiaSemana;
    }    
    
// PARA HORA DE INICIO
    public Time getHoraInicio(){
        return HoraInicio;
    }
    public void setHoraInicio(Time HoraInicio){
        this.HoraInicio = HoraInicio;
    } 
    
// PARA HORA CONCLUIDA
    public Time getHoraFin(){
        return HoraFin;
    }
    public void setHoraFin(Time HoraFin){
        this.HoraFin = HoraFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

