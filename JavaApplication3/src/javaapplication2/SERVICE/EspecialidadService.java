package javaapplication2.SERVICE;

import javaapplication2.DAO.EspecialidadDAO;
import javaapplication2.MODEL.Especialidad;
import java.util.List;
import java.text.Normalizer;

public class EspecialidadService {
    
    private final EspecialidadDAO dao = new EspecialidadDAO();
    
    //INSERTAR
    public String generarId() {
        String ultimoId = dao.obtenerUltimoId();

        if (ultimoId == null || ultimoId.isEmpty()) {
            return "ESP0000001"; // Si la tabla está vacía;
        }
        
        int numeroActual = Integer.parseInt(ultimoId.substring(3));
        int siguienteNumero = numeroActual + 1;

        return String.format("ESP%07d", siguienteNumero);
    };

    public boolean registrar(String nombre) throws Exception {
        
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío.");
        }

        String nombreLimpio = nombre.trim().toUpperCase();
        
        String nombreComparacion = removerTildes(nombreLimpio);

        if (!nombreLimpio.matches("^[A-ZÑÁÉÍÓÚ ]+$")) {
            throw new Exception("El nombre solo permite letras y espacios.");
        }

        if (nombreLimpio.length() > 30) {
            throw new Exception("El nombre es demasiado largo (máximo 30 caracteres).");
        }

        List<Especialidad> listaActual = dao.listar();
        List<Especialidad> listaInactivas = dao.listarInactivos(); 

        listaActual.addAll(listaInactivas);

        for (Especialidad e : listaActual) {
            String nombreBaseNormalizado = Normalizer.normalize(e.getNombre().toUpperCase(), Normalizer.Form.NFD);
            nombreBaseNormalizado = nombreBaseNormalizado.replaceAll("\\p{M}", "");
            /*Si se quisiera diferenciar entre dos registros similares, como MANICURA y MANICURE; 
            se tendría que usar el Algoritmo de distancia de Levenshtein;*/
            
            if (nombreBaseNormalizado.equals(nombreComparacion)) {
                if (e.getEstado().equals("INACTIVA")) {
                    throw new Exception("REAC-001|" + e.getIdEspecialidad());
                } else {
                    throw new Exception("La especialidad '" + e.getNombre() + "' ya existe (se detectó duplicado por tildes).");
                }
            }
        }

        // 7. Si llegó hasta aquí, es porque realmente es nueva
        Especialidad nueva = new Especialidad(generarId(), nombreLimpio, "ACTIVA");
        if (!dao.insertar(nueva)) {
            throw new Exception("Error al insertar en la base de datos.");
        }

        return true;
    };
    
    //DELETE
    public boolean eliminar(String id) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new Exception("ID no válido para eliminar.");
        }
        if (!dao.eliminar(id)) {
            throw new Exception("No se pudo desactivar la especialidad.");
        }
        return true;
    }
    
    //UPDATE
    public boolean actualizar(String id, String nombre) throws Exception {
        if (!nombre.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$")) {
            throw new Exception("El nombre solo permite letras.");
        }
        
        if (dao.existeNombreParaActualizar(nombre, id)) {
            throw new Exception("No puedes actualizar: Ya existe otra especialidad llamada '" + nombre + "'.");
        }

        Especialidad esp = new Especialidad();
        esp.setIdEspecialidad(id);
        esp.setNombre(nombre.trim().toUpperCase());

        if (!dao.actualizar(esp)) {
            throw new Exception("Error al intentar actualizar en la base de datos.");
        }
        return true;
    }
    
    //SELECT (1)
    public List<Especialidad> listar(){
        return dao.listar();
    }
    
    //REACTIVAR
    public void reactivar(String id) throws Exception {
        if (!dao.reactivar(id)) {
            throw new Exception("No se pudo reactivar la especialidad.");
        }
    }

    //SELECT (0)
    public List<Especialidad> listarInactivos() {
        return dao.listarInactivos();
    }
    
    //SELECT COMBO
    public List<Especialidad> listarParaCombo() {
       return dao.listarParaCombo();
    }
    
    //QUITAR TILDES PARA EVITAR DUPLICADOS
    private String removerTildes(String texto) {
        if (texto == null) return "";
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("\\p{M}", "").toUpperCase().trim();
    }
}

