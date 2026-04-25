package javaapplication2.SERVICE;

import javaapplication2.DAO.EmpleadoEspecialidadDAO;
import javaapplication2.MODEL.EmpleadoEspecialidad;
import java.util.List;

public class EmpleadoEspecialidadService {

    private EmpleadoEspecialidadDAO dao = new EmpleadoEspecialidadDAO();

    //INSERTAR
    public String generarId() {
        String ultimoId = dao.obtenerUltimoId();

        if (ultimoId == null || ultimoId.isEmpty()) {
            return "EMES000001"; // Si la tabla está vacía;
        }
        
        int numeroActual = Integer.parseInt(ultimoId.substring(4));
        int siguienteNumero = numeroActual + 1;

        return String.format("EMES%06d", siguienteNumero);
    };
    
    public boolean insertar(EmpleadoEspecialidad ee) {
        if (ee.getIdEmpleado() == null || ee.getIdEspecialidad() == null || 
            ee.getIdEmpleado().isEmpty() || ee.getIdEspecialidad().isEmpty()) {
            return false;
        }

        ee.setIdEmpleadoEspecialidad(generarId()); 
        ee.setEstado("EJERCE"); 

        return dao.insertar(ee);
    }

    //SELECT (1)
    public List<EmpleadoEspecialidad> listar() {
        return dao.listar();
    }

    //DELETE
    public boolean eliminar(String id) {
        return dao.eliminar(id);
    }

    //SELECT (0)
    public List<EmpleadoEspecialidad> listarInactivos() {
        return dao.listarInactivos();
    }

    //REACTIVAR
    public boolean reactivar(String id) {
        return dao.reactivar(id);
    }
}

