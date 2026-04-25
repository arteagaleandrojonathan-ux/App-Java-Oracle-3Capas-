package javaapplication2.DAO;

import javaapplication2.MODEL.EmpleadoEspecialidad;
import javaapplication2.CONFIG.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoEspecialidadDAO {

    /*INSERT*/
    public boolean insertar(EmpleadoEspecialidad ee){
        String sql = "INSERT INTO EMPLEADO_ESPECIALIDAD_HA_E "
                + "(IDEMPLEADOESPECIALIDAD, IDEMPLEADO, IDESPECIALIDAD, ESTADO) "
                + "VALUES (?, ?, ?, ?)";

        try(Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)){

            ps.setString(1, ee.getIdEmpleadoEspecialidad());
            ps.setString(2, ee.getIdEmpleado());
            ps.setString(3, ee.getIdEspecialidad());
            ps.setString(4, ee.getEstado());

            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            return false;
        }
    }
    
    /*SELECT (1)*/
    public List<EmpleadoEspecialidad> listar(){
        List<EmpleadoEspecialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO_ESPECIALIDAD_HA_E "
                        + "WHERE ESTADO = 'EJERCE' ORDER BY TO_NUMBER (SUBSTR(IDEMPLEADOESPECIALIDAD, 5))";

        try(Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                lista.add(new EmpleadoEspecialidad(
                    rs.getString("IDEMPLEADOESPECIALIDAD"),
                    rs.getString("IDEMPLEADO"),
                    rs.getString("IDESPECIALIDAD"),
                    rs.getString("ESTADO")
                ));
            }
        }catch(SQLException e){}
        return lista;
    }

    /*DELETE*/
    public boolean eliminar(String id){
        String sql = "UPDATE EMPLEADO_ESPECIALIDAD_HA_E SET ESTADO = 'NO_EJERCE' WHERE IDEMPLEADOESPECIALIDAD = ?";

        try(
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ){
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al desactivar vínculo: " + e.getMessage());
            return false;
        }
    }
    
    /*SELECT (0)*/
    public List<EmpleadoEspecialidad> listarInactivos(){
        List<EmpleadoEspecialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO_ESPECIALIDAD_HA_E "
                        + "WHERE ESTADO = 'NO_EJERCE' ORDER BY TO_NUMBER (SUBSTR(IDEMPLEADOESPECIALIDAD, 5))";

        try(Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                lista.add(new EmpleadoEspecialidad(
                    rs.getString("IDEMPLEADOESPECIALIDAD"),
                    rs.getString("IDEMPLEADO"),
                    rs.getString("IDESPECIALIDAD"),
                    rs.getString("ESTADO")
                ));
            }
        }catch(SQLException e){}
        return lista;
    }
    
    /*REACTIVAR*/
    public boolean reactivar(String id){
        String sql = "UPDATE EMPLEADO_ESPECIALIDAD_HA_E SET ESTADO = 'EJERCE' WHERE IDEMPLEADOESPECIALIDAD = ?";

        try(
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ){
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al reactivar vínculo: " + e.getMessage());
            return false;
        }
    }
    
    /*LAST ID*/
    public String obtenerUltimoId() {
        String sql = "SELECT MAX(IDEMPLEADOESPECIALIDAD) FROM EMPLEADO_ESPECIALIDAD_HA_E";
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
}
