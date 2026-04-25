package javaapplication2.SERVICE;

 import javaapplication2.MODEL.HorarioEspecial;
import javaapplication2.DAO.HorarioEspecialDAO;

import java.sql.Date;

public class HorarioEspecialService {
    HorarioEspecialDAO dao = new HorarioEspecialDAO();
    
   public void insertar (HorarioEspecial esp){
        dao.insertar(esp);
        
    }
    
    public void listar (){
        dao.listar();
    }
   
    
    // ACTUALIZAR LOS 4 PARAMETROS
    public void actualizarTipo(String idHorarioEspecial, String Tipo){
         dao.actualizarTipo(idHorarioEspecial, Tipo);
    }
    public void actualizarFechaInicio(String idHorarioEspecial, Date FechaInicio){
         dao.actualizarFechaInicio(idHorarioEspecial, FechaInicio);
    }
    public void actualizarFechaFin(String idHorarioEspecial, Date FechaFin){
         dao.actualizarFechaFin(idHorarioEspecial, FechaFin);
    }
    public void actualizarEstado(String idHorarioEspecial, int Estado){
         dao.actualizarEstado(idHorarioEspecial, Estado);
    }
    
    //ELIMINAR 
    public void eliminar(String idHorarioEspecial){
         dao.eliminar(idHorarioEspecial);
    }
}
