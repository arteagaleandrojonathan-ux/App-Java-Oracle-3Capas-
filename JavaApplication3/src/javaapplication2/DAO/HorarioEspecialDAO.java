
package javaapplication2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import java.sql.Date;

import javaapplication2.CONFIG.Conexion;
import javaapplication2.MODEL.HorarioEspecial;


public class HorarioEspecialDAO {
    public void insertar(HorarioEspecial esp){
        String sql = "INSERT INTO HORARIO_ESPECIAL_HA_E VALUES (?,?,?,?,?,?)";
        
        try{
            Connection con =  Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, esp.getidHorarioEspecial());
            ps.setString(2, esp.getidEmpleado());
            ps.setString(3, esp.getTipo());
            ps.setDate  (4, esp.getFechaInicio());
            ps.setDate  (5, esp.getFechaFin());
            ps.setInt   (6, esp.getEstado());
            
            ps.executeUpdate();
            System.out.println("Agregado Correctamente");
            
        }catch(SQLException e){
            System.out.println("ERROR: " + e);
        }
        
    }
    
     public void listar(){
        
        String sql = "SELECT * FROM HORARIO_ESPECIAL_HA_E ORDER BY TO_NUMBER (SUBSTR(idHorarioEspecial,4))";
        
        try{
            Connection con =  Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            var f = ps.executeQuery();
            while (f.next()){
                String id  = f.getString("idHorarioEspecial");
                String ide = f.getString("idEmpleado");
                String tp  = f.getString("Tipo");
                Date  fi   = f.getDate("FechaInicio");
                Date  ff   = f.getDate("FechaFin");
                int Estado = f.getInt("Estado");
                System.out.println(id + " " + ide + " " + tp + " " + fi + " " + ff + " " + Estado);
            }
            
        }catch(SQLException e){
            System.out.println("ERROR: " + e);
        }
    }
     
    // ACTUALIZAR SOLO ESTOS 4 PARAMETROS    
    public void actualizarTipo(String idHorarioEspecial, String Tipo){
        String sql = "UPDATE  HORARIO_ESPECIAL_HA_E SET Tipo = ? WHERE idHorarioEspecial = ?";
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString (1, Tipo);
            ps.setString (2, idHorarioEspecial);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
        }catch (SQLException e){
            System.out.println("ERROR: " + e);
        }  
    }
    
    public void actualizarFechaInicio(String idHorarioEspecial, Date FechaInicio){
        String sql = "UPDATE  HORARIO_ESPECIAL_HA_E SET FechaInicio = ? WHERE idHorarioEspecial = ?";
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDate(1, FechaInicio);
            ps.setString (2, idHorarioEspecial);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
        }catch (SQLException e){
            System.out.println("ERROR: " + e);
        }  
    }
    
    public void actualizarFechaFin(String idHorarioEspecial, Date FechaFin){
        String sql = "UPDATE  HORARIO_ESPECIAL_HA_E SET FechaFin = ? WHERE idHorarioEspecial = ?";
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDate (1, FechaFin);
            ps.setString (2, idHorarioEspecial);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
        }catch (SQLException e){
            System.out.println("ERROR: " + e);
        }  
    }
    
    public void actualizarEstado(String idHorarioEspecial, int Estado){
        String sql = "UPDATE  HORARIO_ESPECIAL_HA_E SET Estado = ? WHERE idHorarioEspecial = ?";
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt (1, Estado);
            ps.setString (2, idHorarioEspecial);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
        }catch (SQLException e){
            System.out.println("ERROR: " + e);
        }  
    }
    
    
    public void eliminar(String idHorarioEspecial){
        String sql = "DELETE FROM HORARIO_ESPECIAL_HA_E WHERE idHorarioEspecial = ? ";
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString (1, idHorarioEspecial);
            
            ps.executeUpdate();
            System.out.println("Eliminado Correctamente");
            
        }catch(SQLException e){
            System.out.println("ERROR: " + e);
        }
        
    }
    

}
