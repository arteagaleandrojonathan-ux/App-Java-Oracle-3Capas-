package javaapplication2.DAO;


import javaapplication2.MODEL.Empleado;
import javaapplication2.CONFIG.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    
    /*INSERT*/
    public boolean insertar (Empleado emp){
        String sql = "INSERT INTO EMPLEADOS_HA_E "
                        + "(IDEMPLEADO, TIPODOI, NUMDOI, "
                        + "APEPATERNO, APEMATERNO, NOMBRES, EMAIL, "
                        + "TELEFONO, TELEFONOEMERGENCIA, ESTADO) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
            ){
            
            ps.setString(1, emp.getIdEmpleado());
            ps.setString(2, emp.getTipoDOI());
            ps.setString(3, emp.getNumDOI());
            ps.setString(4, emp.getApePaterno());
            ps.setString(5, emp.getApeMaterno());
            ps.setString(6, emp.getNombres());
            ps.setString(7, emp.getEmail());
            ps.setString(8, emp.getTelefono());
            if (emp.getTelefonoEmergencia() != null) {
                ps.setString(9, emp.getTelefonoEmergencia());
            } else {
                ps.setNull(9, java.sql.Types.VARCHAR); 
            }
            ps.setInt(10, emp.getEstado());
            
            int filas = ps.executeUpdate();
            return filas > 0; /*Devuelve TRUE si inserta una fila*/
        }catch (SQLException e){
            System.err.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }
    
    /*SELECT (1)*/
    public List<Empleado> listar(){
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADOS_HA_E WHERE ESTADO = 1 ORDER BY TO_NUMBER (SUBSTR(IDEMPLEADO, 4))";
        
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
            ){
            while (rs.next()){
                Empleado esp = new Empleado();
                esp.setIdEmpleado(rs.getString("IDEMPLEADO"));
                esp.setTipoDOI(rs.getString("TIPODOI"));
                esp.setNumDOI(rs.getString("NUMDOI"));
                esp.setApePaterno(rs.getString("APEPATERNO"));
                esp.setApeMaterno(rs.getString("APEMATERNO"));
                esp.setNombres(rs.getString("NOMBRES"));
                esp.setEmail(rs.getString("EMAIL"));
                esp.setTelefono(rs.getString("TELEFONO"));
                esp.setTelefonoEmergencia(rs.getString("TELEFONOEMERGENCIA"));
                esp.setEstado(rs.getInt("ESTADO"));
                lista.add(esp);
            }
        }catch (SQLException e){
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    /*UPDATE*/
    public boolean actualizar(Empleado emp){
        String sql = "UPDATE EMPLEADOS_HA_E SET EMAIL = ?, TELEFONO = ?, TELEFONOEMERGENCIA = ? WHERE IDEMPLEADO= ?";
        
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ){
            ps.setString(1, emp.getEmail());
            ps.setString(2, emp.getTelefono());
            ps.setString(3, emp.getTelefonoEmergencia());
            ps.setString(4, emp.getIdEmpleado());
            
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    /*DELETE*/
    public boolean eliminar(String id){
        String sql = "UPDATE EMPLEADOS_HA_E SET ESTADO = 0 WHERE IDEMPLEADO = ?";
        
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ){
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.err.println("Error al desactivar empleado: " + e.getMessage());
            return false;
        }
    }
    
    /*BUSCAR*/
    public Empleado buscarPorId(String id){
        String sql = "SELECT * FROM EMPLEADOS_HA_E WHERE IDEMPLEADO = ?";

        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ){
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Empleado(
                    rs.getString("IDEMPLEADO"),
                    rs.getString("TIPODOI"),
                    rs.getString("NUMDOI"),
                    rs.getString("APEPATERNO"),
                    rs.getString("APEMATERNO"),
                    rs.getString("NOMBRES"),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFONO"),
                    rs.getString("TELEFONOEMERGENCIA"),
                    rs.getInt("ESTADO")
                );
            }

        } catch(SQLException e){
            System.err.println("Error al buscar empleado: " + e.getMessage());
        }

        return null;
    }
    
    /*SELECT (0)*/
    public List<Empleado> listarInactivos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADOS_HA_E WHERE ESTADO = 0 ORDER BY TO_NUMBER (SUBSTR(IDEMPLEADO, 4))";
        
        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
            ){
            while (rs.next()){
                Empleado esp = new Empleado();
                esp.setIdEmpleado(rs.getString("IDEMPLEADO"));
                esp.setTipoDOI(rs.getString("TIPODOI"));
                esp.setNumDOI(rs.getString("NUMDOI"));
                esp.setApePaterno(rs.getString("APEPATERNO"));
                esp.setApeMaterno(rs.getString("APEMATERNO"));
                esp.setNombres(rs.getString("NOMBRES"));
                esp.setEmail(rs.getString("EMAIL"));
                esp.setTelefono(rs.getString("TELEFONO"));
                esp.setTelefonoEmergencia(rs.getString("TELEFONOEMERGENCIA"));
                esp.setEstado(rs.getInt("ESTADO"));
                lista.add(esp);
            }
        }catch (SQLException e){
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    /*REACTIVAR*/
    public boolean reactivar(String id) {
        String sql = "UPDATE EMPLEADOS_HA_E SET ESTADO = 1 WHERE IDEMPLEADO = ?";
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
    
    /*SELECT COMBOBOX*/
    public List<Empleado> listarParaCombo() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT IDEMPLEADO, APEPATERNO, NOMBRES FROM EMPLEADOS_HA_E WHERE ESTADO = 1";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getString("IDEMPLEADO"));
                // Juntamos Apellido y Nombre para que sea fácil buscar
                emp.setNombres(rs.getString("APEPATERNO") + ", " + rs.getString("NOMBRES"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar combo empleados: " + e.getMessage());
        }
        return lista;
    }
    
    //LAST ID
    public String obtenerUltimoId() {
        String sql = "SELECT MAX(IDEMPLEADO) FROM EMPLEADOS_HA_E";
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
    
    //NUMDOI & TIPODOI
    public Empleado buscarPorDocumento(String tipoDOI, String numDOI) {

        String sql = "SELECT * FROM EMPLEADOS_HA_E WHERE TIPODOI = ? AND NUMDOI = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, tipoDOI);
            ps.setString(2, numDOI);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si lo encuentra, retorna el objeto completo para saber su ESTADO e ID
                    return new Empleado(
                        rs.getString("IDEMPLEADO"),
                        rs.getString("TIPODOI"),
                        rs.getString("NUMDOI"),
                        rs.getString("APEPATERNO"),
                        rs.getString("APEMATERNO"),
                        rs.getString("NOMBRES"),
                        rs.getString("EMAIL"),
                        rs.getString("TELEFONO"),
                        rs.getString("TELEFONOEMERGENCIA"),
                        rs.getInt("ESTADO")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por documento: " + e.getMessage());
        }
        return null;
    }
 
}

