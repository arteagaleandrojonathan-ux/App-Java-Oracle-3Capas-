package javaapplication2.DAO;

import javaapplication2.MODEL.Especialidad;
import javaapplication2.CONFIG.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAO {
    
    //INSERT
    public boolean insertar(Especialidad esp){
        String sql = "INSERT INTO ESPECIALIDADES_HA_E (IDESPECIALIDAD, NOMBRE, ESTADO) VALUES (?, ?, ?)";
        
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
            ){
            
            ps.setString(1, esp.getIdEspecialidad());
            ps.setString(2, esp.getNombre());
            ps.setString(3, esp.getEstado());
            
            int filas = ps.executeUpdate();
            return filas > 0;
            
        }catch (SQLException e){
            System.err.println("Error al insertar especialidad: " + e.getMessage());
            return false;
        }
    }
    
    //SELECT (1)
    public List<Especialidad> listar(){
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM ESPECIALIDADES_HA_E WHERE ESTADO = 'ACTIVA' ORDER BY TO_NUMBER (SUBSTR(IDESPECIALIDAD,4))";
        
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
            ){
            while (rs.next()){
                Especialidad esp = new Especialidad();
                esp.setIdEspecialidad(rs.getString("IDESPECIALIDAD"));
                esp.setNombre(rs.getString("NOMBRE"));
                esp.setEstado(rs.getString("ESTADO"));
                lista.add(esp);
            }
        }catch (SQLException e){
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    //UPDATE
    public boolean actualizar(Especialidad esp) {
        // Quitamos el ESTADO de la consulta SQL
        String sql = "UPDATE ESPECIALIDADES_HA_E SET NOMBRE = ? WHERE IDESPECIALIDAD = ?";

        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ) {
            ps.setString(1, esp.getNombre());
            ps.setString(2, esp.getIdEspecialidad());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar nombre: " + e.getMessage());
            return false;
        }
    }
    
    //DELETE
    public boolean eliminar(String id) {
        // Ya no usamos DELETE FROM, usamos UPDATE para cambiar el estado
        String sql = "UPDATE ESPECIALIDADES_HA_E SET ESTADO = 'INACTIVA' WHERE IDESPECIALIDAD = ?";

        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al desactivar especialidad: " + e.getMessage());
            return false;
        }
    }
    
    //BUSCAR
    public boolean existeNombre(String nombre){
        String sql = "SELECT 1 FROM ESPECIALIDADES_HA_E WHERE UPPER(NOMBRE) = UPPER(?)";
        
        try (Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)){
            
           ps.setString(1, nombre);
           try (ResultSet rs = ps.executeQuery()) {
               return rs.next();
           }
       } catch (SQLException e){
           System.err.println("Error al verificar nombre: " + e.getMessage());
           return false;
       }
    }
    
    //BUSCAR NOMBRE AL ACTUALIZAR
    public boolean existeNombreParaActualizar(String nombre, String idActual) {
        //Buscar si hay otra especialidad que ya use ese nombre, ignora el ID de esta fila;
        String sql = "SELECT COUNT(*) FROM ESPECIALIDADES_HA_E WHERE NOMBRE = ? AND ID_ESPECIALIDAD <> ?";

        try (Connection cn = Conexion.getConexion();
           PreparedStatement ps = cn.prepareStatement(sql)) {

           ps.setString(1, nombre);
           ps.setString(2, idActual);

           try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()) return rs.getInt(1) > 0;
           }
       } catch (SQLException e) { 
           System.err.println("Error en existeNombreParaActualizar: " + e.getMessage()); 
       }
       return false;
    }
    
    //REACTIVAR
    public boolean reactivar(String id) {
        String sql = "UPDATE ESPECIALIDADES_HA_E SET ESTADO = 'ACTIVA' WHERE IDESPECIALIDAD = ?";
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al reactivar: " + e.getMessage());
            return false;
        }
    }

    //SELECT (0)
    public List<Especialidad> listarInactivos() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM ESPECIALIDADES_HA_E WHERE ESTADO = 'INACTIVA' ORDER BY IDESPECIALIDAD ASC";
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
            ){
            while (rs.next()){
                Especialidad esp = new Especialidad();
                esp.setIdEspecialidad(rs.getString("IDESPECIALIDAD"));
                esp.setNombre(rs.getString("NOMBRE"));
                esp.setEstado(rs.getString("ESTADO"));
                lista.add(esp);
            }
        }catch (SQLException e){
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    //SELECT COMBOBOX
    public List<Especialidad> listarParaCombo() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT IDESPECIALIDAD, NOMBRE FROM ESPECIALIDADES_HA_E WHERE ESTADO = 'ACTIVA'";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Especialidad esp = new Especialidad();
                esp.setIdEspecialidad(rs.getString("IDESPECIALIDAD"));
                esp.setNombre(rs.getString("NOMBRE"));
                lista.add(esp);
            }
        } catch (SQLException e) {
            System.err.println("Error combo especialidad: " + e.getMessage());
        }
        return lista;
    }
    
    //LAST ID
    public String obtenerUltimoId() {
        String sql = "SELECT MAX(IDESPECIALIDAD) FROM ESPECIALIDADES_HA_E";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar último ID: " + e.getMessage());
        }
        return null;
    } //Evita el problema de generar ID duplicado;
    
    //BUSCAR POR NOMBRE
    public Especialidad buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM ESPECIALIDADES_HA_E WHERE TRIM(UPPER(NOMBRE)) = TRIM(UPPER(?))";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Especialidad esp = new Especialidad();
                    esp.setIdEspecialidad(rs.getString("IDESPECIALIDAD"));
                    esp.setNombre(rs.getString("NOMBRE"));
                    esp.setEstado(rs.getString("ESTADO"));
                    return esp;
                }
            }
        } catch (SQLException e) { 
            System.err.println("Error en buscarPorNombre: " + e.getMessage()); 
        }
        return null; // Si no existe
    }
}