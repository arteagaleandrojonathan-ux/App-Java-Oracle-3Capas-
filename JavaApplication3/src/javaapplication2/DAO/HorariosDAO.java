package javaapplication2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet; 

import java.sql.Time;
          
import java.util.ArrayList;       
import java.util.List; 

import javaapplication2.CONFIG.Conexion;
import javaapplication2.MODEL.Horarios;

public class HorariosDAO {

    /** Lista horarios activos como entidades (para edición por id, etc.). */
    public List<Horarios> listar() {
        List<Horarios> lista = new ArrayList<>();
        String sql = "SELECT idHorario, idEmpleado, diaSemana, horaInicio, horaFin, estado"
                + " FROM HORARIOS_HA_E WHERE estado = 'ACTIVO' "
                + "ORDER BY TO_NUMBER(SUBSTR(idHorario, 2))";
        try (Connection cn = Conexion.getConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Horarios h = new Horarios();
                h.setidHorario(rs.getString(1));
                h.setidEmpleado(rs.getString(2));
                h.setDiaSemana(rs.getString(3));
                h.setHoraInicio(rs.getTime(4));
                h.setHoraFin(rs.getTime(5));
                h.setEstado(rs.getString(6));
                lista.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Error DAO listar Horarios: " + e);
        }
        return lista;
    }
    
    public String generarId() {

    String id = "H000000001";
    String sql = "SELECT MAX(idHorario) FROM HORARIOS_HA_E";

    try {
        Connection con = Conexion.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String ultimo = rs.getString(1);

            if (ultimo != null) {
                int numero = Integer.parseInt(ultimo.substring(1)) + 1;
                id = String.format("H%09d", numero);
            }
        }

    } catch (Exception e) {
        System.out.println("Error generar ID: " + e);
    }

    return id;
}
    
    
   // INSERTAR: estado ACTIVO | INACTIVO | ANULADO (CHECK Oracle)
    public boolean insertar(Horarios esp) {
        String sql = "INSERT INTO HORARIOS_HA_E (idHorario, idEmpleado, diaSemana, horaInicio, horaFin, estado) VALUES (?,?,?,?,?,?)";
        try (Connection cn = Conexion.getConexion();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, esp.getidHorario());
            ps.setString(2, esp.getidEmpleado());
            ps.setString(3, esp.getDiaSemana());
            ps.setTime(4, esp.getHoraInicio());
            ps.setTime(5, esp.getHoraFin());
            ps.setString(6, esp.getEstado() != null ? esp.getEstado() : "ACTIVO");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error DAO Insertar: " + e);
            return false;
        }
    }
    
    // LISTAR: columnas reales de EMPLEADOS_HA_E (NOMBRES, APEPATERNO, APEMATERNO) — igual criterio que ContratosDAO
    public List<Object[]> listarConNombres() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT h.idHorario, e.nombres, "
                + "TRIM(e.apepaterno || ' ' || NVL(e.apematerno, '')), "
                + "h.diaSemana, h.horaInicio, h.horaFin, h.estado, e.idempleado "
                + "FROM HORARIOS_HA_E h "
                + "JOIN EMPLEADOS_HA_E e ON h.idempleado = e.idempleado "
                + "WHERE h.estado = 'ACTIVO' "
                + "ORDER BY TO_NUMBER(SUBSTR(h.idHorario, 2))";
        try (Connection cn = Conexion.getConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getTime(5),
                    rs.getTime(6),
                    rs.getString(7),
                    rs.getString(8)
                });
            }
        } catch (SQLException e) {
            System.out.println("Error DAO Listar: " + e);
        }
        return lista;
    }

    // ELIMINAR LÓGICO: Cambia el estado en lugar de hacer DELETE
    public void eliminarLogico(String idHorario) {
        String sql = "UPDATE HORARIOS_HA_E SET estado = 'INACTIVO' WHERE idHorario = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idHorario);
            ps.executeUpdate();
            System.out.println("Estado cambiado a INACTIVO para: " + idHorario);
        } catch (SQLException e) {
            System.out.println("Error DAO Eliminar: " + e);
        }
    }

    // Actualizar día y horas del horario
    
    public void actualizarDiaSemana(String idHorario, String DiaSemana) {
        String sql = "UPDATE HORARIOS_HA_E SET diaSemana = ? WHERE idHorario = ?";
        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, DiaSemana);
            ps.setString(2, idHorario);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR actualizarDiaSemana: " + e);
        }
    }

    public void actualizarHoraInicio(String idHorario, Time HoraInicio) {
        String sql = "UPDATE HORARIOS_HA_E SET horaInicio = ? WHERE idHorario = ?";
        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTime(1, HoraInicio);
            ps.setString(2, idHorario);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR actualizarHoraInicio: " + e);
        }
    }

    public void actualizarHoraFin(String idHorario, Time HoraFin) {
        String sql = "UPDATE HORARIOS_HA_E SET horaFin = ? WHERE idHorario = ?";
        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTime(1, HoraFin);
            ps.setString(2, idHorario);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR actualizarHoraFin: " + e);
        }
    } 
    
  // PARA ELIMINAR 
    public void eliminar (String idHorario){
        String sql = "UPDATE HORARIOS_HA_E SET estado = 'ANULADO' WHERE idHorario = ?";
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString (1, idHorario);
            
            ps.executeUpdate();
            System.out.println("Eliminado Correctamente");
            
        }catch(SQLException e){
            System.out.println("ERROR: " + e);
        }
        
    } 
    
}   
