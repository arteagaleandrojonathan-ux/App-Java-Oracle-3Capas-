package javaapplication2.CONFIG;

    import java.sql.Connection;
    import java.sql.DriverManager;


    public class Conexion {
        
private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        
        private static final String USER = "ESTETICA";
        private static final String PASS="1234";

        public static Connection getConexion() {
            Connection con =null;

            try {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión exitosa");
            } catch (Exception e) {
                System.out.println("Error de conexión: " + e);
            }
             return con;

        }

    }
