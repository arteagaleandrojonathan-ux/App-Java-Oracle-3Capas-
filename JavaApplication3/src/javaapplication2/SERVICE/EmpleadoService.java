package javaapplication2.SERVICE;

import javaapplication2.DAO.EmpleadoDAO;
import javaapplication2.MODEL.Empleado;
import java.util.List;
import java.util.regex.Pattern;

public class EmpleadoService {

    private final EmpleadoDAO dao = new EmpleadoDAO();
    
    //INSERTAR
    public String generarId() {
        String ultimoId = dao.obtenerUltimoId();

        if (ultimoId == null || ultimoId.isEmpty()) {
            return "EMP0000001"; // Si la tabla está vacía;
        }
        
        int numeroActual = Integer.parseInt(ultimoId.substring(3));
        int siguienteNumero = numeroActual + 1;

        return String.format("EMP%07d", siguienteNumero);
    };

    public boolean registrar(Empleado emp) throws Exception {
        emp.setNombres(emp.getNombres().trim().toUpperCase());
        emp.setApePaterno(emp.getApePaterno().trim().toUpperCase());
        emp.setApeMaterno(emp.getApeMaterno().trim().toUpperCase());
        emp.setEmail(emp.getEmail().trim().toLowerCase());
        emp.setNumDOI(emp.getNumDOI().trim().toUpperCase());
        emp.setTelefono(emp.getTelefono().trim());
        
        //ÚNICO CAMPO NULO
        if (emp.getTelefonoEmergencia() != null) {
            emp.setTelefonoEmergencia(emp.getTelefonoEmergencia().trim());
        }

        //NOMBRES Y APELLIDOS OBLIGATORIOS
        if (emp.getNombres().isEmpty() || emp.getApePaterno().isEmpty() || emp.getApeMaterno().isEmpty()) {
            throw new Exception("Los nombres y apellidos son obligatorios.");
        }

        //FORMATO DE NOMBRES Y APELLIDOS
        String regexNombres = "^[A-ZÑÁÉÍÓÚ\\- ]{2,}$";
        if (!emp.getNombres().matches(regexNombres) || 
            !emp.getApePaterno().matches(regexNombres) || 
            !emp.getApeMaterno().matches(regexNombres)) {
            throw new Exception("Los nombres Y apellidos solo permiten letras y guiones.");
        }

        //LONGITUDES MÁXIMAS
        if (emp.getApePaterno().length() < 2 || emp.getApePaterno().length() > 30) {
            throw new Exception("El Apellido Paterno debe tener entre 2 y 30 caracteres.");
        }

        if (emp.getApeMaterno().length() < 2 || emp.getApeMaterno().length() > 30) {
            throw new Exception("El Apellido Materno debe tener entre 2 y 30 caracteres.");
        }

        if (emp.getNombres().length() < 2 || emp.getNombres().length() > 50) {
            throw new Exception("Los nombres deben tener entre 2 y 40 caracteres.");
        }

        //TIPO DE DOCUMENTO
        String num = emp.getNumDOI();
        String tipo = emp.getTipoDOI(); // Asegúrate que en el ComboBox diga exactamente esto

        if (tipo.equals("DNI")) {
            if (!num.matches("^[0-9]{8}$")) throw new Exception("DNI debe tener exactamente 8 dígitos numéricos.");
        } 
        else if (tipo.equals("CARNET_DE_EXTRANJERIA")) {
            if (!num.matches("^[0-9]{9}$")) throw new Exception("Carnet de Extranjería debe tener exactamente 9 dígitos numéricos.");
        } 
        else if (tipo.equals("PASAPORTE")) {
            if (!num.matches("^[A-Z0-9]{7,10}$")) throw new Exception("Pasaporte debe tener entre 7 y 10 caracteres alfanuméricos.");
        } 
        else if (tipo.equals("CPP/PTP")) {
            if (!num.matches("^[0-9]{8,9}$")) throw new Exception("CPP/PTP debe tener entre 8 y 9 dígitos numéricos.");
        }

        //TELÉFONOS
        if (!emp.getTelefono().matches("^9[0-9]{8}$")) {
            throw new Exception("El teléfono debe empezar con 9 y tener 9 dígitos.");
        }
        if (emp.getTelefonoEmergencia() != null && !emp.getTelefonoEmergencia().isEmpty()) {
            if (!emp.getTelefonoEmergencia().matches("^9[0-9]{8}$")) {
                throw new Exception("El teléfono de emergencia debe tener 9 dígitos.");
            }
        }

        //EMAIL
        String regexEmail = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        
        if (emp.getEmail().length() > 75) {
            throw new Exception("El email es demasiado largo (máximo 75 caracteres).");
        }
        
        if (!emp.getEmail().matches(regexEmail)) {
            throw new Exception("El formato del Email no es válido. Debe ser ejemplo@correo.com");
        }

        // 8. CONTROL DE DUPLICADOS Y REACTIVACIÓN
        Empleado existe = dao.buscarPorDocumento(emp.getTipoDOI(), emp.getNumDOI());
        if (existe != null) {
            if (existe.getEstado() == 0) {
                // Código para que el Formulario reconozca que debe preguntar por reactivación
                throw new Exception("REAC-001|" + existe.getIdEmpleado());
            } else {
                throw new Exception("El empleado con " + emp.getTipoDOI() + " " + num + " ya está activo.");
            }
        }

        //ID E INSERCIÓN
        emp.setIdEmpleado(generarId());
        emp.setEstado(1); // 1 = ACTIVO
        
        return dao.insertar(emp);
    }
    
    //DELETE
    public boolean eliminar(String id) throws Exception{
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("Error: El ID del empleado es necesario para la desactivación.");
        }

        if (dao.buscarPorId(id) == null) {
            throw new Exception("Error: El empleado con ID " + id + " no existe en el sistema.");
        }

        boolean exito = dao.eliminar(id);

        if (!exito) {
            throw new Exception("No se pudo desactivar al empleado. Intente de nuevo.");
        }

        return exito;
    }

    //UPDATE
    public boolean actualizar(String id, String email, String telefono, String telefonoEmergencia) throws Exception{

        id = id.trim();
        email = email.trim().toLowerCase();
        telefono = telefono.trim();
        String telEmergencia = (telefonoEmergencia != null) ? telefonoEmergencia.trim() : null;

        if (!telefono.matches("^9[0-9]{8}$")) {
            throw new Exception("El teléfono debe empezar con 9 y tener 9 dígitos.");
        }

        //TELÉFONO ÚNICO
        List<Empleado> todos = dao.listar(); 
        for (Empleado e : todos) {
            if (e.getTelefono().equals(telefono) && !e.getIdEmpleado().equals(id)) {
                throw new Exception("El teléfono " + telefono + " ya pertenece a otro empleado (" + e.getApePaterno() + ").");
            }
        }

        // 3. VALIDACIÓN DE TELÉFONO DE EMERGENCIA (Si existe)
        if (telEmergencia != null && !telEmergencia.isEmpty()) {
            if (!telEmergencia.matches("^9[0-9]{8}$")) {
                throw new Exception("El teléfono de emergencia debe tener 9 dígitos.");
            }
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new Exception("El formato del Email no es válido.");
        }

        Empleado emp = new Empleado();
        emp.setIdEmpleado(id);
        emp.setEmail(email);
        emp.setTelefono(telefono);
        emp.setTelefonoEmergencia(telEmergencia);

        boolean exito = dao.actualizar(emp);
        if (!exito) {
            throw new Exception("No se pudo actualizar la información en la base de datos.");
        }

        return true;
    }

    //SELECT (1)
    public List<Empleado> listar(){
        return dao.listar();
    }
    
    //REACTIVAR
    public boolean reactivar(String id) throws Exception {
        if (!dao.reactivar(id)) {
            throw new Exception("No se pudo reactivar al empleado. Verifique el ID.");
        }
        return true;
    }
    
    //LISTAR (0)
    public List<Empleado> listarInactivos() {
        return dao.listarInactivos();
    }
    
    //BUSCAR POR ID
    public Empleado buscarPorId(String id) throws Exception{
        Empleado emp = dao.buscarPorId(id);
        if (emp == null) {
            throw new Exception("El empleado con código " + id + " no existe.");
        }
        return emp;
    }
    
    //SELECT COMBO
    public List<Empleado> listarParaCombo() {
        return dao.listarParaCombo();
    }
    
 // ESTO ES AGREADO EXTRA
    public Empleado buscarPorNombreCompleto(String nombreCompleto) {

        for (Empleado e : listar()) {

            String completo = e.getNombres() + " " + e.getApePaterno() + " " + e.getApeMaterno();

            if (completo.trim().equalsIgnoreCase(nombreCompleto.trim())) {
                return e;
            }
        }
        return null;
    }
 
    
    
    
}

