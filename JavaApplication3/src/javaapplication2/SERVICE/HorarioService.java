package javaapplication2.SERVICE;

 import javaapplication2.MODEL.Horarios;
import javaapplication2.DAO.HorariosDAO;

import java.util.List;
import java.sql.Time;

public class HorarioService {
    HorariosDAO dao = new HorariosDAO();
    
    public List<Object[]> listarConNombres() {
        return dao.listarConNombres();
    }

    public List<Horarios> listar() {
        return dao.listar();
    }

    public boolean insertar(Horarios h) {
        return dao.insertar(h);
    }

    public String generarId() {
        return dao.generarId();
    }

    // PARA ACTUALZIAR SOLO ESTOS DATOS    
    public void actualizarHoraInicio(String idHorario, Time HoraInicio){
        dao.actualizarHoraInicio(idHorario, HoraInicio);
    }
    public void actualizarHoraFin(String idHorario, Time HoraFin){
        dao.actualizarHoraFin(idHorario, HoraFin);
    }
    public void actualizarDiaSemana(String idHorario, String DiaSemana){
        dao.actualizarDiaSemana(idHorario, DiaSemana);
    }
    
//PARA ELIMINAR  
    public void eliminar (String idHorario){
        dao.eliminar(idHorario);
    }
}
