package javaapplication2.SERVICE;

 import javaapplication2.MODEL.Contratos;
import javaapplication2.DAO.ContratosDAO;

import java.sql.Date;
import java.util.List;


public class ContratoService {
    ContratosDAO dao = new ContratosDAO();
    
    
    public String generarId() {
        return dao.generarId();
    }
    
    public boolean insertar(Contratos c){
    return dao.insertar(c);
}

    
    public List<Contratos> listar (){
        return dao.listar();
    }
    
    
// PARA ACTUALZIAR SOLO ESTOS DATOS    
    public void actualizarFechaInicio(String idContrato, Date FechaInicio){
        dao.actualizarFechaInicio(idContrato, FechaInicio);
    }
    public void actualizarFechaFin(String idContrato, Date FechaFin){
        dao.actualizarFechaFin(idContrato, FechaFin);
    }
    public void actualizarRol(String idContrato, String Rol){
        dao.actualizarRol(idContrato, Rol);
    }
    public void actualizarEstado(String idContrato, String Estado){
        dao.actualizarEstado (idContrato, Estado);
    }
    
    
//PARA ELIMINAR  
    public void eliminar (String idContrato){
        dao.eliminar(idContrato);
    }
    
    
// PARA LISTAR NUEVO   
    public List<Object[]> listarConEmpleado(){
    return dao.listarConEmpleado();
    }
}
