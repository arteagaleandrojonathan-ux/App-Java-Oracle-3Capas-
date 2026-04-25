package javaapplication2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Date; 
import javax.swing.JOptionPane;

import javaapplication2.CONFIG.Conexion;
import javaapplication2.MODEL.Contratos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratosDAO {
    
    public String generarId() {

    String id = "CON0000001";
    String sql = "SELECT MAX(idContrato) FROM CONTRATOS_HA_E";

    try {
        Connection con = Conexion.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String ultimo = rs.getString(1);

            if (ultimo != null) {
                int numero = Integer.parseInt(ultimo.substring(3)) + 1;
                id = String.format("CON%07d", numero);
            }
        }

    } catch (Exception e) {
        System.out.println("Error generar ID: " + e);
    }

    return id;
}
    
    public  boolean  insertar (Contratos esp){
        
        String sql = "INSERT INTO CONTRATOS_HA_E VALUES  (?,?,?,?,?,?)";
        boolean resultado = false;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, esp.getidContrato());
            ps.setString(2, esp.getidEmpleado());
            ps.setDate(3, new java.sql.Date(esp.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(esp.getFechaFin().getTime()));
            ps.setString(5, esp.getRol());
            ps.setString(6, esp.getEstado());
            
            int filas = ps.executeUpdate();
            resultado = filas > 0;
            resultado = true; 
            System.out.println("Agregado Correctamente");   
                     
        } catch(SQLException e){

        // 🔥 AQUÍ VA TU VALIDACIÓN
        if (e.getMessage().contains("ORA-02291")) {
            JOptionPane.showMessageDialog(null, "ID DE EMPLEADO NO VALIDO");
        } else {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
        }
       return resultado;  
    }
    
    
    public List<Object[]> listarConEmpleado() {

    List<Object[]> lista = new ArrayList<>();

    String sql = "SELECT DISTINCT c.idContrato, e.nombres, e.apepaterno, e.apematerno, " +
                 "c.fechaInicio, c.fechaFin, c.rol, c.estado " +
                 "FROM CONTRATOS_HA_E c " +
                 "LEFT JOIN EMPLEADOS_HA_E e ON c.idEmpleado = e.idEmpleado " +             
                 "ORDER BY TO_NUMBER(SUBSTR(c.idContrato,4))";

    try {
        Connection con = Conexion.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3) + " " + rs.getString(4),
                rs.getDate(5),
                rs.getDate(6),
                rs.getString(7),
                rs.getString(8)
            });
        }

    } catch (Exception e) {
        System.out.println("Error: " + e);
    }

    return lista;
}
  public List<Contratos> listar (){

    List<Contratos> lista = new ArrayList<>();

    String sql = "SELECT * FROM CONTRATOS_HA_E ORDER BY TO_NUMBER(SUBSTR(idContrato,4))";

    try {
        Connection con = Conexion.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Contratos c = new Contratos();

            c.setidContrato(rs.getString("idContrato"));
            c.setidEmpleado(rs.getString("idEmpleado"));
            c.setFechaInicio(rs.getDate("fechaInicio"));
            c.setFechaFin(rs.getDate("fechaFin"));
            c.setRol(rs.getString("rol"));
            c.setEstado(rs.getString("estado"));

            lista.add(c);
        }

    } catch (Exception e) {
        System.out.println("Error: " + e);
    }

    return lista;
}  
      
 //ACTUALIZAR ALGUOS PARAMETROS DE CONTRATOS (FEHCA INICIO, FECHA FIN , ROL Y ESTADO)
    public void actualizarFechaInicio (String idContrato, Date FechaInicio){
        String sql = "UPDATE  CONTRATOS_HA_E SET FechaInicio = ? WHERE idContrato = ?";
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDate  (1, FechaInicio);
            ps.setString(2, idContrato);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
        }catch (SQLException e){
            System.out.println("ERROR: " + e);
        }   
    } 
    
    public void actualizarFechaFin (String idContrato, Date FechaFin){
        String sql = "UPDATE  CONTRATOS_HA_E SET FechaFin = ? WHERE idContrato = ?";
         try{
             Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDate  (1, FechaFin);
            ps.setString(2, idContrato);
            
            ps.executeUpdate();
            System.out.println("Actualizado Correctamente");
         }catch(SQLException e){
             System.out.println("ERROR: " + e);
         }
        
    } 
    public void actualizarRol (String idContrato, String Rol){
        String sql = "UPDATE  CONTRATOS_HA_E SET Rol = ? WHERE idContrato = ?";
         try{
             Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString  (1, Rol);
            ps.setString(2, idContrato);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
         }catch(SQLException e){
             System.out.println("ERROR: " + e);
         }
        
    } 
    public void actualizarEstado (String idContrato, String Estado){
        String sql = "UPDATE  CONTRATOS_HA_E SET Estado = ? WHERE idContrato = ?";
         try{
             Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString  (1, Estado);
            ps.setString(2, idContrato);
            
            ps.executeUpdate();
            
            System.out.println("Actualizado Correctamente");
            
         }catch(SQLException e){
             System.out.println("ERROR: " + e);
         }
        
    } 
    
    
    
 // PARA ELIMINAR 
    public void eliminar (String idContrato){
        String sql = "UPDATE CONTRATOS_HA_E SET Estado = 'ANULADO' WHERE idContrato = ?";
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString (1, idContrato);
            
            ps.executeUpdate();
            System.out.println("Eliminado Correctamente");
            
        }catch(SQLException e){
            System.out.println("ERROR: " + e);
        }
        
    } 
}
//